package services.impl;

import core.*;
import services.LedgerDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LedgerDaoImpl implements LedgerDao {
    private static String delimeter = ":";
    //loan details with key as bankName + customerName
    private Map<String, List<LoanDetail>> keyToLoanDetails = new HashMap<>();
    //EMI Details for given key as bankName + customerName
    private Map<String, List<EMIDetail>> keyToEmiDetails = new HashMap<>();
    //IF lumpsum was paid, i am removing EMIs this is used to keep total EMIs before lumpsum was paid
    private Map<String, Map<Integer,Integer>> keyToEMIToRemainingEMIS = new HashMap<>();

    @Override
    public boolean addLoan(LoanRequest request){
        String key = createKey(request);
        List<LoanDetail> loanDetails = keyToLoanDetails.getOrDefault(key, new ArrayList<>());
        LoanDetail loanDetail = new LoanDetail(request.getPrincipalAmount(), request.getYears(), request.getRateOfInterest());
        loanDetails.add(loanDetail);
        keyToLoanDetails.put(key, loanDetails);
        Double finalAmount = (double) getFinalAmount(loanDetail);
        Integer noOfEmis = loanDetail.getYears() * 12;
        int emiAmount = (int)Math.ceil(finalAmount/noOfEmis);
        //System.out.println(emiAmount);
        List<EMIDetail> emiDetails = keyToEmiDetails.getOrDefault(key, new ArrayList<>());
        for(int i = 1 ; i <= noOfEmis; i++){
            if(emiAmount > finalAmount)
                emiAmount = finalAmount.intValue();
            finalAmount = finalAmount - emiAmount;
            if(i > emiDetails.size()){
                emiDetails.add(new EMIDetail(emiAmount));
            } else {
                EMIDetail emiDetail = emiDetails.get(i-1);
                emiDetail.addAmount(emiAmount);
            }
            if(finalAmount == 0)
                break;
        }
        keyToEmiDetails.put(key, emiDetails);
        return true;
    }

    @Override
    public void addPayment(PaymentRequest request) {
        String key = createKey(request);
        List<EMIDetail> emiDetails = keyToEmiDetails.get(key);
        Integer amountPaid = request.getLumpsum();
        int k = 0;
        for(int i = emiDetails.size() ; i > request.getEmiPaid(); i-- ){
            amountPaid = emiDetails.get(i-1).subtractAmount(amountPaid);
            if(amountPaid >= 0){
                k++;
                emiDetails.remove(i-1);
            } else {
                break;
            }
        }
        Map<Integer, Integer> m = keyToEMIToRemainingEMIS.getOrDefault(key, new HashMap<>());
        for(int i = 1 ; i < request.getEmiPaid(); i++){
            m.put(i , m.getOrDefault(i, 0) + k);
        }
        keyToEMIToRemainingEMIS.put(key, m);

        emiDetails.get(request.getEmiPaid()).setLumpum(request.getLumpsum());
    }

    @Override
    public Balance returnBalance(BalanceRequest request) {
        String key = createKey(request);
        List<EMIDetail> emiDetails = keyToEmiDetails.get(key);
        int amount = 0;
        for(int i = 0 ; i <= request.getEmiPaid(); i++){
            if(i == 0 )
                amount = amount + emiDetails.get(i).getLumpum();
            else
                amount = amount + emiDetails.get(i-1).getEmiAmount() + emiDetails.get(i).getLumpum();
            //System.out.println(amount);
        }
        Map<Integer, Integer> m = keyToEMIToRemainingEMIS.getOrDefault(key, new HashMap<>());
        int remaning = m.getOrDefault(request.getEmiPaid(), 0);
        return new Balance(amount, emiDetails.size()-request.getEmiPaid() + remaning);
    }

    private String createKey(Request request){
        return request.getBankName() + delimeter + request.getCustomerName();
    }

    private int getFinalAmount(LoanDetail loanDetail){
        int interestAmount = loanDetail.getRateOfInterest() * loanDetail.getPrincipalAmount() * loanDetail.getYears();
        interestAmount = interestAmount/100;
        return loanDetail.getPrincipalAmount() + interestAmount;
    }
}
