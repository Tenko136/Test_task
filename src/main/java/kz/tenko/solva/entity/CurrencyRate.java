package kz.tenko.solva.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "currency_rate")
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_rate")
    private LocalDate dateRate;

    @Column(name = "rate_USD_KZ")
    private double rateKZ;

    @Column(name = "rate_USD_RU")
    private double rateRU;

    public CurrencyRate() {
    }

    public CurrencyRate(LocalDate dateRate, double rateKZ, double rateRU) {
        this.dateRate = dateRate;
        this.rateKZ = rateKZ;
        this.rateRU = rateRU;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return dateRate;
    }

    public void setDate(LocalDate dateRate) {
        this.dateRate = dateRate;
    }

    public double getRateKZ() {
        return rateKZ;
    }

    public void setRateKZ(double rateKZ) {
        this.rateKZ = rateKZ;
    }

    public double getRateRU() {
        return rateRU;
    }

    public void setRateRU(double rateRU) {
        this.rateRU = rateRU;
    }


}
