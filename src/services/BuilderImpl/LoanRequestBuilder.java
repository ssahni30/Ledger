package services.BuilderImpl;


import core.LoanRequest;
import services.Builder;

public class LoanRequestBuilder implements Builder {
    private String[] values;

    @Override
    public LoanRequestBuilder setValues(String[] values){
        this.values = values;
        return this;
    }

    @Override
    public LoanRequest build(){
        return new LoanRequest(values[1], values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]));
    }
}
