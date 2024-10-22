package kz.tenko.solva.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "client_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "client_account_id")
    private Long clientAccountId;

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
    private boolean isLimitExceed;


    public Transaction() {
    }

    public Transaction(Long clientAccountId, int targetAccNum, double purchaseAmount, String category, LocalDateTime dateTime, String currency, boolean isLimitExceed) {
        this.clientAccountId = clientAccountId;
        this.targetAccNum = targetAccNum;
        this.purchaseAmount = purchaseAmount;
        this.category = category;
        this.dateTime = dateTime;
        this.currency = currency;
        this.isLimitExceed = isLimitExceed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientAccountId() {
        return clientAccountId;
    }

    public void setClientAccountId(Long clientAccountId) {
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
        return isLimitExceed;
    }

    public void setLimitExceed(boolean limitExceed) {
        isLimitExceed = limitExceed;
    }
}
