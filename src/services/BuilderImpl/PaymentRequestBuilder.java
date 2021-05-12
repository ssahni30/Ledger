package services.BuilderImpl;

import core.PaymentRequest;
import services.Builder;

public class PaymentRequestBuilder implements Builder {

    private String[] values;

    @Override
    public PaymentRequestBuilder setValues(String[] values){
        this.values = values;
        return this;
    }

    @Override
    public PaymentRequest build(){
        return new PaymentRequest(values[1], values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]));
    }
}
