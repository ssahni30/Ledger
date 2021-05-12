package services.impl;

import core.Balance;
import core.BalanceRequest;
import core.Request;
import services.CommandService;
import services.LedgerDao;

public class BalanceServiceImpl implements CommandService {

    private LedgerDao ledgerDao;
    public BalanceServiceImpl(LedgerDao ledgerDao) {
        this.ledgerDao = ledgerDao;
    }

    @Override
    public void process(Request request) {
        BalanceRequest balanceRequest = (BalanceRequest) request;
        Balance balance = ledgerDao.returnBalance(balanceRequest);
        System.out.println(request.getBankName() + " " + request.getCustomerName() + " " + balance.getRemainingAmount() + " " + balance.getRemaningEMI());
    }


}
