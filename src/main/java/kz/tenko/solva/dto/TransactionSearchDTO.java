package kz.tenko.solva.dto;


import lombok.Getter;
import lombok.Setter;

public class TransactionSearchDTO {

    @Setter
    @Getter
    private String clientAccountNum;

    private boolean isExceededLimit = true;

    public TransactionSearchDTO() {
    }

    public boolean isExceededLimit() {
        return isExceededLimit;
    }

    public void setExceededLimit(boolean exceededLimit) {
        isExceededLimit = exceededLimit;
    }
}
