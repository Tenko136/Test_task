package kz.tenko.solva.dto;

public class TransactionSearchDTO {

    private String clientAccountNum;

    private boolean isExceededLimit = true;

    public TransactionSearchDTO() {
    }

    public String getClientAccountNum() {
        return clientAccountNum;
    }

    public void setClientAccountNum(String clientAccountNum) {
        this.clientAccountNum = clientAccountNum;
    }

    public boolean isExceededLimit() {
        return isExceededLimit;
    }

    public void setExceededLimit(boolean exceededLimit) {
        isExceededLimit = exceededLimit;
    }
}
