package com.priyanshu.springjpatxn.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "wallet_transaction")
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @Column(name="txn_amount")
    private Double txnAmount;

    @Column(name="initial_amount")
    private Double initialAmount;

    @Column(name="final_amount")
    private Double finalAmount;

    @ManyToOne
    @JoinColumn(name = "user_wallet_id")
    private UserWallet userWallet;

    @PrePersist
    private void prePersist() {
        this.transactionDate = new Date(); // Set current date/time
    }
}
