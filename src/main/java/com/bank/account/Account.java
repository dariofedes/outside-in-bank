package com.bank.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Account {

	private ITransactionRepository repository;

	public Account() {}

	public Account (ITransactionRepository repository) {
		this.repository = repository;
	}

    public void deposit(int amount) {
    	Deposit deposit = new Deposit(amount);

    	repository.saveTransaction(deposit);
    }

	public void withdraw(int amount) {
	}

	public void printStatement() {
	}
}
