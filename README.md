# Spring Data JPA With Transactions Support in RDBMS

## Application Components:

**ApplicationController:** It have one route named, `/transfer-amount`. It accepts three parameters, sourceWallet, destWallet and amount to be transferred.

**BalanceTransferService:** This service have the flow as below;

1. Fetch the wallet details for account 1 and account 2.
2. Debit Amount from wallet1 and create a debit entry in wallet transactions.
3. Credit Amount in wallet2 and create a credit entry in wallet transactions.

**UserWallet Entity:** This entity will hold the data of each wallet id and their balance. Target is to ensure that this table should always be consistant.

**WalletTransaction Entity:** This entity will hold the credit/debit transaction logs.

## Step-1: Implementation Without any synchronization/transactions:
**Branch:** main

In this case the application works fine, if there is any one request at a time for credit/debit. In case of parallel requests for credit/debit from same wallets, the application will malfunction.


## Step-2: Make the BalanceTransferService.transferAmount method synchronized
**Branch:** feature/step-2

Advantages:
1. It will ensure that the `BalanceTransferService.transferAmount` method is being called by only one thread at a time.

Drawbacks:
1. In case of multiple instances of same application, it will not work.
2. It will unnecessary hold all the requests. e.g. We are receiving 2 requests, Wallet1->Wallet2(Amount=50) and Wallet3->Wallet4(Amount=10). In this case second request have to unnecessary wait, which does not have any concurrency impact on request1.

Conclusion:
This method also can't be used in modern applications.