package com.example;

import java.util.Iterator;

public class Administrator 
{
    private String username;
    private String password;
    private Bank bank;

    public Administrator(String username, String password, Bank bank) 
    {
        this.username = username;
        this.password = password;
        this.bank = bank;
    }

    public void viewAllCustomers() 
    {
        Iterator<Customer> customerIterator = bank.getCustomers().iterator();
        while (customerIterator.hasNext()) 
        {
            Customer customer = customerIterator.next();
            System.out.println("Customer: " + customer.getName());
            customer.viewAccount(); // View customer's accounts
        }
        System.out.println();
    }

    public void viewAllAccounts() 
    {
        Iterator<Account> accountIterator = bank.getAccounts().iterator();
        while (accountIterator.hasNext()) 
        {
            Account account = accountIterator.next();
            System.out.println("Account ID: " + account.getAccountID() + ", Balance: $" + account.getBalance());
        }
    }
}

