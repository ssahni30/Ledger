package core;

public class LoanDetail {
    private Integer principalAmount;
    private Integer years;
    private Integer rateOfInterest;

    public LoanDetail(Integer principalAmount, Integer years, Integer rateOfInterest) {
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

    @Override
    public String toString() {
        return "LoanDetail{" +
                "principalAmount=" + principalAmount +
                ", years=" + years +
                ", rateOfInterest=" + rateOfInterest +
                '}';
    }
}
