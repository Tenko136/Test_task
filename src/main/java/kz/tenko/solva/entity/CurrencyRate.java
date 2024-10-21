package kz.tenko.solva.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "currency_rate")
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "rate_USD_KZ")
    private double rateKZ;

    @Column(name = "rate_USD_RU")
    private double rateRU;

    public CurrencyRate() {
    }

    public CurrencyRate(LocalDateTime dateTime, double rateUSDxKZ, double rateUSDxRU) {
        this.dateTime = dateTime;
        this.rateKZ = rateUSDxKZ;
        this.rateRU = rateUSDxRU;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
