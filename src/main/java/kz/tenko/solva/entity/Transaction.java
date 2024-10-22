package kz.tenko.solva.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "client_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "client_account_id")
    private int clientAccountId;

    @Column(name = "target_acc_num")
    private int targetAccNum;

    @Column(name = "purchase_amount")
    private double purchaseAmount;

    @Column(name = "category")
    private String category;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "currency")
    private String currency;

    @Column(name = "is_limit_exceed")
    private boolean IsLimitExceed;


    public Transaction() {
    }

    public Transaction(int clientAccountId, int targetAccNum, double purchaseAmount, String category, LocalDateTime dateTime, String currency, boolean isLimitExceed) {
        this.clientAccountId = clientAccountId;
        this.targetAccNum = targetAccNum;
        this.purchaseAmount = purchaseAmount;
        this.category = category;
        this.dateTime = dateTime;
        this.currency = currency;
        IsLimitExceed = isLimitExceed;
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

    public int getTargetAccNum() {
        return targetAccNum;
    }

    public void setTargetAccNum(int targetAccNum) {
        this.targetAccNum = targetAccNum;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isLimitExceed() {
        return IsLimitExceed;
    }

    public void setLimitExceed(boolean limitExceed) {
        IsLimitExceed = limitExceed;
    }
}
