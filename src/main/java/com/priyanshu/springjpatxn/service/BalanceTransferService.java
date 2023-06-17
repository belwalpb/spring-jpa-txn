package com.priyanshu.springjpatxn.service;

import com.priyanshu.springjpatxn.entity.UserWallet;
import com.priyanshu.springjpatxn.entity.WalletTransaction;
import com.priyanshu.springjpatxn.repository.UserWalletRepository;
import com.priyanshu.springjpatxn.repository.WalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceTransferService {

    @Autowired
    private UserWalletRepository userWalletRepository;

    @Autowired
    private WalletTransactionRepository walletTransactionsRepository;

    public synchronized  void transferAmount(long sourceWallet, long destWallet, double amount) {
        UserWallet source = userWalletRepository.findById(sourceWallet)
                .orElseThrow(() -> new IllegalArgumentException("Source Wallet Not Found"));
        UserWallet destination = userWalletRepository.findById(destWallet)
                .orElseThrow(() -> new IllegalArgumentException("Destination Wallet Not Found"));

        changeAmount(source, - amount);
         changeAmount(destination, amount);
    }

    private void changeAmount(UserWallet wallet, double amount) {
        double initialAmount = wallet.getWalletAmount();
        double finalAmount = initialAmount + amount;
        wallet.setWalletAmount(finalAmount);

        WalletTransaction transaction = WalletTransaction.builder()
                .txnAmount(amount)
                .initialAmount(initialAmount)
                .finalAmount(finalAmount)
                .userWallet(wallet)
                .build();

        userWalletRepository.save(wallet);
        walletTransactionsRepository.save(transaction);
    }

}
