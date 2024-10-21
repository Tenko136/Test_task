package kz.tenko.solva.entity;


import java.util.HashMap;


public class OpenExchangeRates {

    private String base;
    private HashMap<String, Double> rates;

    public OpenExchangeRates() {
    }

    public OpenExchangeRates(String base, HashMap<String, Double> rates) {
        this.base = base;
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public HashMap<String, Double> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, Double> rates) {
        this.rates = rates;
    }
}

