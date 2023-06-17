package com.priyanshu.springjpatxn.controller;

import com.priyanshu.springjpatxn.service.BalanceTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Autowired
    private BalanceTransferService balanceTransferService;

    @GetMapping("/transfer-amount")
    public String performOperations(@RequestParam Long sourceAccount, @RequestParam Long destAccount, @RequestParam Double amount) {

        balanceTransferService.transferAmount(sourceAccount, destAccount, amount);
        return "Success";
    }

}