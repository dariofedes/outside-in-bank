package com.bank.account;

public interface ITransactionRepository {
    void saveTransaction(Deposit deposit);
}
