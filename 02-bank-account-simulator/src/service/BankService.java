package service;

import model.BankAccount;

public class BankService {
    
    // Simple method to show account info
    public void showAccount(BankAccount account) {
        if (account == null) {
            System.out.println("Account is null!");
            return;
        }
        System.out.println("\n=== Account Information ===");
        System.out.println(account.getAccountInfo());
        System.out.println("===========================\n");
    }
    
    // Deposit with account parameter
    public void deposit(BankAccount account, double amount) {
        if (account == null) {
            System.out.println("Cannot deposit: Account is null");
            return;
        }
        
        System.out.println("\nAttempting to deposit: $" + amount);
        account.deposit(amount);
        System.out.println("New balance: $" + account.getBalance());
    }
    
    // Withdraw with account parameter  
    public void withdraw(BankAccount account, double amount) {
        if (account == null) {
            System.out.println("Cannot withdraw: Account is null");
            return;
        }
        
        System.out.println("\nAttempting to withdraw: $" + amount);
        boolean success = account.withdraw(amount);
        
        if (success) {
            System.out.println("Withdrawal successful!");
            System.out.println("New balance: $" + account.getBalance());
        } else {
            System.out.println("Withdrawal failed.");
            System.out.println("Current balance: $" + account.getBalance());
        }
    }
    
    // BONUS: Transfer between two accounts
    public void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        if (fromAccount == null || toAccount == null) {
            System.out.println("Transfer failed: One or both accounts are null");
            return;
        }
        
        System.out.println("\nAttempting to transfer $" + amount + 
                          " from " + fromAccount.getOwnerName() + 
                          " to " + toAccount.getOwnerName());
        
        boolean success = fromAccount.withdraw(amount);
        
        if (success) {
            toAccount.deposit(amount);
            System.out.println("Transfer successful!");
            System.out.println(fromAccount.getOwnerName() + "'s new balance: $" + fromAccount.getBalance());
            System.out.println(toAccount.getOwnerName() + "'s new balance: $" + toAccount.getBalance());
        } else {
            System.out.println("Transfer failed: Insufficient funds in source account");
        }
    }
}