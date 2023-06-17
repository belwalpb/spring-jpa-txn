CREATE DATABASE walletdb;

CREATE USER 'wallet-db-admin-user'@'%' IDENTIFIED BY 'sinsn@po!~';

GRANT ALL PRIVILEGES ON walletdb.* TO 'wallet-db-admin-user'@'%';

FLUSH PRIVILEGES;

use walletdb;

CREATE TABLE user_wallet (
  id INT AUTO_INCREMENT PRIMARY KEY,
  wallet_amount DOUBLE
);

CREATE TABLE wallet_transaction (
  id INT AUTO_INCREMENT PRIMARY KEY,
  txn_amount DOUBLE,
  initial_amount DOUBLE,
  final_amount DOUBLE,
  transaction_date TIMESTAMP,
  user_wallet_id INT,
  FOREIGN KEY (user_wallet_id) REFERENCES user_wallet (id)
);

INSERT INTO user_wallet (wallet_amount) VALUES(100);
INSERT INTO user_wallet (wallet_amount) VALUES(0);