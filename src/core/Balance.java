package core;

public class Balance {
    private Integer remainingAmount;
    private Integer remaningEMI;

    public Balance(Integer remainingAmount, Integer remaningEMI) {
        this.remainingAmount = remainingAmount;
        this.remaningEMI = remaningEMI;
    }

    public Integer getRemainingAmount() {
        return remainingAmount;
    }

    public Integer getRemaningEMI() {
        return remaningEMI;
    }
}
