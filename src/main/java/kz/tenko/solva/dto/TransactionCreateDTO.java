package kz.tenko.solva.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionCreateDTO {

    private String clientAccountNum;

    private int targetAccNum;

    private double purchaseAmount;

    private String category;

    private String currency;

    public TransactionCreateDTO() {
    }

}
