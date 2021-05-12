package services.impl;

import core.LoanRequest;
import core.Request;
import services.CommandService;
import services.LedgerDao;

public class LoanServiceImpl implements CommandService {

    private LedgerDao ledgerDao;

    public LoanServiceImpl(LedgerDao ledgerDao) {
        this.ledgerDao = ledgerDao;
    }

    @Override
    public void process(Request request) {
        LoanRequest loanRequest = (LoanRequest) request;
        ledgerDao.addLoan(loanRequest);
    }
}
