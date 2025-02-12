package kz.tenko.solva.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ClientLimitDTO {
    private Long clientId;

    private String accountNum;

    private String category;


}
