package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Iterator;
//import com.fasterxml.jackson.databind.ObjectMapper;

public class BankSystem 
{

    public static void main(String[] args) 
    {
        // Create an instance of Bank
        Bank bank = new Bank();
        Administrator admin = new Administrator("admin", "adminpass", bank);

        // Register and create accounts for customers
        bank.RegisterAndCreateAccount("C1", "John Doe", "123 Main St", "johndoe", "adsdd@gmail.com", "password", "A1");
        bank.RegisterAndCreateAccount("C2", "Jane Smith", "456 Oak St", "janesmith", "adlklk@gmail.com", "securepwd", "A2");
        bank.RegisterAndCreateAccount("C3", "Bob Johnson", "789 Pine St", "bobjohnson", "kljklad@gmail.com", "secret123", "A3");

        // Authenticate customers
        Customer customer1 = bank.authenticateCustomer("johndoe", "password");
        Customer customer2 = bank.authenticateCustomer("janesmith", "securepwd");
        Customer customer3 = bank.authenticateCustomer("bobjohnson", "wrongpassword"); // Authentication fails
        
        // Deposit and withdraw funds
        if (customer1 != null) 
        {
            customer1.addAccount(new Account("A4"));
            customer1.getAccount("A1").setBalance(500.0);
            customer1.viewAccount();
            customer1.getAccount("A1").deposit(200.0);
            customer1.viewAccount();
            customer1.getAccount("A1").withdraw(100.0);
            customer1.viewAccount();
            customer1.getAccount("A1").vewTransactionHistory();
        }

        // View all customers and their accounts
        viewAllCustomers(bank);
        System.out.println("Administrator: " + "\n");
        admin.viewAllCustomers();
        admin.viewAllAccounts();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(customer1);
            System.out.println("JSON String: " + jsonString);

            // Convert the JSON string back to User object
            Customer parsedUser = objectMapper.readValue(jsonString, Customer.class);
            System.out.println(parsedUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to view all customers and their accounts
    private static void viewAllCustomers(Bank bank) 
    {
        Iterator<Customer> customerIterator = bank.getCustomers().iterator();
        System.out.println("\nAll Customer : ");
        while (customerIterator.hasNext()) 
        {
            Customer currentCustomer = customerIterator.next();
            System.out.println("Customer: " + currentCustomer.getName());
            currentCustomer.viewAccount();
        }
    }
}
