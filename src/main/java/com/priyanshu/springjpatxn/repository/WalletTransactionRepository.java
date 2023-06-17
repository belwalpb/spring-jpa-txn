package com.priyanshu.springjpatxn.repository;


import com.priyanshu.springjpatxn.entity.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
    // You can define custom repository methods here if needed
}
