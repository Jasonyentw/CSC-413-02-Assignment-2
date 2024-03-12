package com.example;

import java.util.Date;

class Transaction 
{
    private TransactionType transactionType;
    private double amount;
    private Account recipient; // For transfer transactions
    private Date Creationtime;

    // Constructor for deposit and withdrawal transactions
    public Transaction(TransactionType transactionType, double amount) 
    {
        this.transactionType = transactionType;
        this.amount = amount;
        Creationtime = new Date();
    }

    // Constructor for transfer transactions
    public Transaction(TransactionType transactionType, double amount, Account recipient) 
    {
        this.transactionType = transactionType;
        this.amount = amount;
        this.recipient = recipient;
        Creationtime = new Date();
    }

    @Override
    public String toString() 
    {
        if (transactionType == TransactionType.TRANSFER) 
        {
            return "Transfer $" + amount + " to Account ID: " + recipient.getAccountID() + "    " + Creationtime;
        } 
        else 
        {
            return transactionType + " $" + amount + "    " + Creationtime;
        }
    }
}
