package kz.tenko.solva.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "client_limit")
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

    public ClientLimit() {
    }

    public ClientLimit(ClientAccount clientAccount, LocalDateTime dateTime, double amount, String category, double rest, String currency) {
        this.clientAccount = clientAccount;
        this.dateTime = dateTime;
        this.amount = amount;
        this.category = category;
        this.rest = rest;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRest() {
        return rest;
    }

    public void setRest(double rest) {
        this.rest = rest;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
