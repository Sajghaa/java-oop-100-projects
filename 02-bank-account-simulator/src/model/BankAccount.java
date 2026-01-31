package model;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
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

    public String getAccountInfo(){
        return ownerName + " | Acc: " + accountNumber + "| Balance: " + balance;
    }
}