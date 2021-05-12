package core;

public class BalanceRequest extends Request{
    private Integer emiPaid;

    public BalanceRequest(String bankName, String customerName, Integer emiPaid) {
        super(bankName, customerName);
        this.emiPaid = emiPaid;
    }

    public Integer getEmiPaid() {
        return emiPaid;
    }
}
