package kz.tenko.solva.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "client_transaction")
@Data
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

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

    public Transaction(ClientAccount clientAccount, int targetAccNum, double purchaseAmount, String category, LocalDateTime dateTime, String currency, boolean isLimitExceed) {
        this.clientAccount = clientAccount;
        this.targetAccNum = targetAccNum;
        this.purchaseAmount = purchaseAmount;
        this.category = category;
        this.dateTime = dateTime;
        this.currency = currency;
        this.isLimitExceed = isLimitExceed;
    }
}
