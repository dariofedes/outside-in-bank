package com.bank.account;

public abstract class Transaction {
    protected String date;
    protected int amount;

    protected Transaction(int amount) {
        Date date = new Date();
        this.date = date.getDateString();
        this.amount = amount;
    }
}
