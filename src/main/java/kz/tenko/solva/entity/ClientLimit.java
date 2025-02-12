package kz.tenko.solva.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "client_limit")
@Data
@NoArgsConstructor
public class ClientLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "amount")
    private double amount = 1000.00;

    @Column(name = "category")
    private String category;

    @Column(name = "rest")
    private double rest;

    @Column(name = "currency")
    private String currency = "USD";

    public ClientLimit(ClientAccount clientAccount, LocalDateTime dateTime, double amount, String category, double rest, String currency) {
        this.clientAccount = clientAccount;
        this.dateTime = dateTime;
        this.amount = amount;
        this.category = category;
        this.rest = rest;
        this.currency = currency;
    }
}
