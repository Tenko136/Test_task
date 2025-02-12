package kz.tenko.solva.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Setter
@Getter
public class OpenExchangeRatesDTO {

    private String base;
    private HashMap<String, Double> rates;

    public OpenExchangeRatesDTO() {
    }

    public OpenExchangeRatesDTO(String base, HashMap<String, Double> rates) {
        this.base = base;
        this.rates = rates;
    }

}

