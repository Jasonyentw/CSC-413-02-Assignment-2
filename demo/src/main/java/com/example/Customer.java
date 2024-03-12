package com.example;
import java.util.Date;
import java.util.Iterator;

class Customer implements Comparable<Customer>
{
    private String name;
    private String username;
    private String userID;
    private String address;
    private String password;
    private String email;
    private Date dateOfCreation;
    private AccountPriorityQueue accountQueue;

    public Customer()
    {
        dateOfCreation = new Date();
        this.name = null;
        this.userID = null;
        this.email = null;
        accountQueue = new AccountPriorityQueue();
    }

    public Customer(String userID, String name, String address, String username, String email, String password)
    {
        dateOfCreation = new Date();
        this.name = name;
        this.userID = userID;
        this.address = address;
        this.username = username;
        this.password = password;
        this.email = email;
        accountQueue = new AccountPriorityQueue();
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setuserID(String userID)
    {
        this.userID = userID;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public Date getDateOfCreation()
    {
        return dateOfCreation;
    }

    public String getName()
    {
        return name;
    }

    public String getUserID()
    {
        return userID;
    }

    public String getAddress()
    {
        return address;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public Account getAccount(String accountID)
    {
        Iterator<Account> iterator = accountQueue.iterator();
        while (iterator.hasNext()) 
        {
            Account currentAccount = iterator.next();
            if (currentAccount.getAccountID().equals(accountID)) 
            {
                return currentAccount;
            }
        }
        System.out.println("Account not found.");
        return null; 
    }

    public void addAccount(Account account)
    {
        accountQueue.enqueue(account);
    }

    public void removeAccount(Account account) 
    {
        Iterator<Account> iterator = accountQueue.iterator();
        while (iterator.hasNext()) 
        {
            Account currentAccount = iterator.next();
            if (currentAccount.equals(account)) 
            {
                iterator.remove(); // Remove the account from the queue
                System.out.println("Account removed successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void viewAccount()
    {
        Iterator<Account> iterator = accountQueue.iterator();
        while (iterator.hasNext()) 
        {
            Account currentAccount = iterator.next();
            System.out.println("Balance in " + currentAccount.getAccountID() + " Account: " + currentAccount.getBalance());
        }
        System.out.println("-------------------------------------------------------");
    }

    @Override
    public int compareTo(Customer other) 
    {
        // compare by date of creation
        int dateComparison = this.dateOfCreation.compareTo(other.dateOfCreation);
            return dateComparison;

    }
}
