package kz.tenko.solva.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "currency_rate")
@Data
@NoArgsConstructor
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

    public CurrencyRate(LocalDate dateRate, double rateKZ, double rateRU) {
        this.dateRate = dateRate;
        this.rateKZ = rateKZ;
        this.rateRU = rateRU;
    }
}
