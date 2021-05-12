package services.BuilderImpl;

import core.BalanceRequest;
import services.Builder;

public class BalanceRequestBuilder implements Builder {
    private String[] values;

    @Override
    public BalanceRequestBuilder setValues(String[] values){
        this.values = values;
        return this;
    }

    @Override
    public BalanceRequest build(){
        return new BalanceRequest(values[1], values[2], Integer.parseInt(values[3]));
    }
}
