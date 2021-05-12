package services.factory;

import core.Command;
import services.*;
import services.impl.BalanceServiceImpl;
import services.impl.LoanServiceImpl;
import services.impl.PaymentServiceImpl;

public class CommandServiceFactory {

    private CommandService paymentService;
    private CommandService loanService;
    private CommandService balanceService;

    public CommandServiceFactory(LedgerDao ledgerDao) {
        this.paymentService = new PaymentServiceImpl(ledgerDao);
        this.loanService = new LoanServiceImpl(ledgerDao);
        this.balanceService = new BalanceServiceImpl(ledgerDao);
    }

    public CommandService getService(Command command){
        switch (command){
            case LOAN:
                return this.loanService;
            case BALANCE:
                return this.balanceService;
            case PAYMENT:
                return this.paymentService;
            default:
                return null;
        }
    }
}
