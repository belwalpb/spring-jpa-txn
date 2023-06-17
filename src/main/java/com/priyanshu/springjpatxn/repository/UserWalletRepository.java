package com.priyanshu.springjpatxn.repository;


import com.priyanshu.springjpatxn.entity.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface UserWalletRepository extends JpaRepository<UserWallet, Long> {
    // You can define custom repository methods here if needed

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT w FROM UserWallet w WHERE w.id = :id")
    public Optional<UserWallet> findByIdLocked(Long id);

}
