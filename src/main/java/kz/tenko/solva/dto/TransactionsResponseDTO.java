package kz.tenko.solva.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class TransactionsResponseDTO {

    private double purchaseAmount;

    private String currency;

    private String category;

    private LocalDateTime dateTime;

    public TransactionsResponseDTO() {
    }

}
