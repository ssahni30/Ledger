package services;

import core.Balance;
import core.BalanceRequest;
import core.LoanRequest;
import core.PaymentRequest;

public interface LedgerDao {
    boolean addLoan(LoanRequest request);

    void addPayment(PaymentRequest request);

    Balance returnBalance(BalanceRequest balanceRequest);
}
