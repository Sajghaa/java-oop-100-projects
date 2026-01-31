package model;

public class BankAccount {

    public enum AccountType{
        CHECKING,
        SAVINGS
    }

    private String accountNumber;
    private AccountType type;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double balance){
        // simple validation

        if (accountNumber == null || accountNumber.isEmpty()){
            throw new IllegalArgumentException("Account number cannot be empty");
        }

        if (ownerName == null || ownerName.isEmpty()){
            throw new IllegalArgumentException("Owner name cannot be empty");
        }

        if (balance <0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.type = type;
    }

    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
        }
    }

    public boolean withdraw(double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance(){
        return balance;
    }

    public AccountType getType(){
        return type;
    }
    public String getAccountInfo(){
        return ownerName + " | Acc: " + accountNumber +"| Type: "+ type +"| Balance: " + balance;
    }
}