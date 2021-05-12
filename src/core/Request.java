package core;

public class Request {
    private String bankName;
    private String customerName;

    public Request(String bankName, String customerName) {
        this.bankName = bankName;
        this.customerName = customerName;
    }

    public String getBankName() {
        return bankName;
    }

    public String getCustomerName() {
        return customerName;
    }
}
