package core;

public class EMIDetail {
    //represents amount to be paid
    private Integer emiAmount;
    // represents if lumpsum was paid at this moment
    private Integer lumpum;

    public EMIDetail(Integer emiAmount) {
        this.emiAmount = emiAmount;
        this.lumpum = 0;
    }

    public void addAmount(Integer amount){
        this.emiAmount = this.emiAmount + amount;
    }

    public Integer getEmiAmount() {
        return emiAmount;
    }

    public Integer subtractAmount(Integer amountPaid) {
        if(emiAmount > amountPaid){
            this.emiAmount = this.emiAmount - amountPaid;
            return -1;
        }
        return amountPaid - emiAmount;
    }

    public Integer getLumpum() {
        return lumpum;
    }

    public void setLumpum(Integer lumpum) {
        this.lumpum = this.lumpum + lumpum;
    }

    @Override
    public String toString() {
        return "EMIDetail{" +
                "emiAmount=" + emiAmount +
                '}';
    }
}
