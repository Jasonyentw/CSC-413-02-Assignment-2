package com.example;

import java.util.Iterator;

public class Bank 
{
    private AccountPriorityQueue accounts;
    private CustomerPriorityQueue customers;
    
    Bank()
    {
        customers = new CustomerPriorityQueue();
        accounts = new AccountPriorityQueue();
    }

    public void addCustomer(Customer customer)
    {
        customers.enqueue(customer);
    }

    public void addAccount(Account account)
    {
        accounts.enqueue(account);
    }

    public CustomerPriorityQueue getCustomers() {
        return customers;
    }

    public AccountPriorityQueue getAccounts() {
        return accounts;
    }

    public void RegisterAndCreateAccount(String userID, String name, String address, String username, String email, String password, String accountID)
    {
        Customer newCustomer = new Customer(userID, name, address, username, email, password);
        Account newAccount = new Account(accountID, newCustomer);
        addCustomer(newCustomer);
        addAccount(newAccount);
        newCustomer.addAccount(newAccount);
    }

    public Customer authenticateCustomer(String username, String password)
    {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) 
        {
            Customer currentCustomer = iterator.next();
            if (currentCustomer.getUsername().equals(username) && currentCustomer.getPassword().equals(password)) 
            {
                //System.out.println("*");
                return currentCustomer;
            }
        }
        System.out.println("Account not found.");
        return null;
    }
}
