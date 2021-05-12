package services.factory;

import core.Command;
import services.Builder;
import services.BuilderImpl.BalanceRequestBuilder;
import services.BuilderImpl.LoanRequestBuilder;
import services.BuilderImpl.PaymentRequestBuilder;

public class BuilderFactory {

    private static Builder loanBuilder = new LoanRequestBuilder();
    private static Builder balanceBuilder = new BalanceRequestBuilder();
    private static Builder paymentBuilder = new PaymentRequestBuilder();

    public static Builder getRequestBuilder(Command command){
        switch (command){
            case LOAN:
                return loanBuilder;
            case BALANCE:
                return balanceBuilder;
            case PAYMENT:
                return paymentBuilder;
            default:
                return null;
        }
    }
}
