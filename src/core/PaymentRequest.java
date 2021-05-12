package core;

public class PaymentRequest extends Request{
    private Integer lumpsum;
    private Integer emiPaid;

    public PaymentRequest(String bankName, String customerName, Integer lumpsum, Integer emiPaid) {
        super(bankName, customerName);
        this.lumpsum = lumpsum;
        this.emiPaid = emiPaid;
    }

    public Integer getLumpsum() {
        return lumpsum;
    }

    public Integer getEmiPaid() {
        return emiPaid;
    }
}
