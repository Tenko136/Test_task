package kz.tenko.solva.solva.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "client_limit")
public class ClientLimits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "client_account_id")
    private int clientAccountId;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "amount")
    private double amount;

    @Column(name = "category")
    private String category;

    @Column(name = "rest")
    private double rest;

    @Column(name = "currency")
    private String currency;

    public ClientLimits() {
    }

    public ClientLimits(int clientAccountId, LocalDateTime dateTime, double amount, String category, double rest, String currency) {
        this.clientAccountId = clientAccountId;
        this.dateTime = dateTime;
        this.amount = amount;
        this.category = category;
        this.rest = rest;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientAccountId() {
        return clientAccountId;
    }

    public void setClientAccountId(int clientAccountId) {
        this.clientAccountId = clientAccountId;
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
