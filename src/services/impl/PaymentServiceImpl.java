package services.impl;

import core.PaymentRequest;
import core.Request;
import services.CommandService;
import services.LedgerDao;

public class PaymentServiceImpl implements CommandService {

    private LedgerDao ledgerDao;

    public PaymentServiceImpl(LedgerDao ledgerDao) {
        this.ledgerDao = ledgerDao;
    }

    @Override
    public void process(Request request) {
        PaymentRequest paymentRequest = (PaymentRequest) request;
        ledgerDao.addPayment(paymentRequest);
    }
}
