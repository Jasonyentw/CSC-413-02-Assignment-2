package dtoanddaodemo;
import java.util.*;


class Account implements Comparable<Account>
{
    private String accountID;
    private double balance;
    private Date Creationtime;
    private Customer customer;
    private Stack<Transaction> transactions;

    public Account()
    {
        Creationtime = new Date();
        this.balance = 0.0;
        this.accountID = null;
        this.transactions = new Stack<>();
    }

    public Account(String accountID)
    {
        Creationtime = new Date();
        this.balance = 0.0;
        this.accountID = accountID;
        this.transactions = new Stack<>();
    }

    public Account(String accountID, Customer customer)
    {
        Creationtime = new Date();
        this.balance = 0.0;
        this.accountID = accountID;
        this.customer = customer;
        this.transactions = new Stack<>();
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void setAccountID(String accountID)
    {
        this.accountID = accountID;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public double getBalance()
    {
        return balance;
    }

    public Date getDateOfCreation()
    {
        return Creationtime;
    }

    public String getAccountID()
    {
        return accountID;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void deposit(double amount)
    {
        
        balance += amount;
        Transaction Transaction = new Transaction(TransactionType.DEPOSIT, amount);
        transactions.push(Transaction);
    }

    public void withdraw(double amount)
    {
        if(balance >= amount)
        {
            balance -= amount;
            Transaction Transaction = new Transaction(TransactionType.WITHDRAWL, amount);
            transactions.push(Transaction);
        }
        else
        {
            System.out.println("Balance is insufficient.");
        }
    }

    public void transfer(Account destination, double amount)
    {
        if(balance >= amount)
        {
            balance -= amount;
            destination.deposit(amount);
            Transaction Transaction = new Transaction(TransactionType.TRANSFER, amount, destination);
            transactions.push(Transaction);
        }
        else
        {
            System.out.println("Balance is insufficient.");
        }
    }

    public void vewTransactionHistory()
    {
        System.out.println("Transaction History for Account ID: " + accountID);
        Iterator<Transaction> iterator = transactions.iterator();

        // Iterate through the stack using the iterator
        while (iterator.hasNext()) {
            Transaction element = iterator.next();
            System.out.println(element);
        }
        System.out.println("-------------------------------------------------------");
    }

    @Override
    public int compareTo(Account other) 
    {
        // First, compare by date of creation
        int dateComparison = this.Creationtime.compareTo(other.Creationtime);
        if (dateComparison != 0) {
            return dateComparison;
        }

        // If date of creation is the same, compare by balance in reverse order
        return Double.compare(other.balance, this.balance);
    }
}
