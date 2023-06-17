package com.priyanshu.springjpatxn.repository;


import com.priyanshu.springjpatxn.entity.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWallet, Long> {
    // You can define custom repository methods here if needed

}
