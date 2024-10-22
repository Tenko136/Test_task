package kz.tenko.solva.dto;

public class TransactionDTO {
    private String clientAccountNum;
    private int targetAccNum;
    private double purchaseAmount;

    private String category;
    private String currency;
    public TransactionDTO() {
    }

    public String getClientAccountNum() {
        return clientAccountNum;
    }

    public void setClientAccountNum(String clientAccountNum) {
        this.clientAccountNum = clientAccountNum;
    }

    public int getTargetAccNum() {
        return targetAccNum;
    }

    public void setTargetAccNum(int targetAccNum) {
        this.targetAccNum = targetAccNum;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
