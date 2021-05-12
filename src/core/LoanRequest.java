package core;

public class LoanRequest extends Request{
    private Integer principalAmount;
    private Integer years;
    private Integer rateOfInterest;

    public LoanRequest(String bankName, String customerName, Integer principalAmount, Integer years, Integer rateOfInterest) {
        super(bankName, customerName);
        this.principalAmount = principalAmount;
        this.years = years;
        this.rateOfInterest = rateOfInterest;
    }

    public Integer getPrincipalAmount() {
        return principalAmount;
    }

    public Integer getYears() {
        return years;
    }

    public Integer getRateOfInterest() {
        return rateOfInterest;
    }
}
