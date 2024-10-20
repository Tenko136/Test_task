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
    private double rateUSDxKZ;

    @Column(name = "rate_USD_RU")
    private double rateUSDxRU;

    public CurrencyRate() {
    }

    public CurrencyRate(LocalDateTime dateTime, double rateUSDxKZ, double rateUSDxRU) {
        this.dateTime = dateTime;
        this.rateUSDxKZ = rateUSDxKZ;
        this.rateUSDxRU = rateUSDxRU;
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

    public double getRateUSDxKZ() {
        return rateUSDxKZ;
    }

    public void setRateUSDxKZ(double rateUSDxKZ) {
        this.rateUSDxKZ = rateUSDxKZ;
    }

    public double getRateUSDxRU() {
        return rateUSDxRU;
    }

    public void setRateUSDxRU(double rateUSDxRU) {
        this.rateUSDxRU = rateUSDxRU;
    }
}
