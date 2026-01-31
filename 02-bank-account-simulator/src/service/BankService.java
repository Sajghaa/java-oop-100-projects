package service;

import model.BankAccount;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    // ========== FIELDS ==========
    private List<BankAccount> accounts;  // Stores all bank accounts
    private int totalTransactions;       // Tracks how many transactions happened
    
    // ========== CONSTRUCTOR ==========
    public BankService() {
        this.accounts = new ArrayList<>();
        this.totalTransactions = 0;
        System.out.println("BankService started!");
    }
    
    // ========== MAIN METHODS ==========
    
    // Creates a new bank account
    public BankAccount createAccount(String accountNumber, String ownerName, 
                                   double initialBalance, BankAccount.AccountType type) {
        // Check if account already exists
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account " + accountNumber + " already exists!");
                return null;
            }
        }
        
        // Create new account
        BankAccount newAccount = new BankAccount(accountNumber, ownerName, initialBalance, type);
        accounts.add(newAccount);
        
        System.out.println("Account created: " + newAccount.getAccountInfo());
        return newAccount;
    }
    
    // Finds an account by account number
    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found: " + accountNumber);
        return null;
    }
    
    // Deposits money into an account
    public boolean deposit(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        
        if (account == null) {
            System.out.println("Deposit failed: Account not found");
            return false;
        }
        
        account.deposit(amount);
        totalTransactions++;
        return true;
    }
    
    // Withdraws money from an account
    public boolean withdraw(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        
        if (account == null) {
            System.out.println("Withdrawal failed: Account not found");
            return false;
        }
        
        boolean success = account.withdraw(amount);
        if (success) {
            totalTransactions++;
        }
        return success;
    }
    
    // Transfers money between accounts
    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);
        
        // Check if both accounts exist
        if (fromAccount == null || toAccount == null) {
            System.out.println("Transfer failed: One or both accounts not found");
            return false;
        }
        
        // Try to withdraw from source
        boolean withdrawalSuccess = fromAccount.withdraw(amount);
        
        if (withdrawalSuccess) {
            // If withdrawal succeeded, deposit to target
            toAccount.deposit(amount);
            totalTransactions += 2; // Count as 2 transactions
            System.out.println("Transfer successful: $" + amount + 
                             " from " + fromAccountNumber + " to " + toAccountNumber);
            return true;
        } else {
            System.out.println("Transfer failed: Insufficient funds in " + fromAccountNumber);
            return false;
        }
    }
    
    // ========== GETTERS & INFO METHODS ==========
    
    // Gets all accounts
    public List<BankAccount> getAllAccounts() {
        return new ArrayList<>(accounts); // Return a copy for safety
    }
    
    // Gets total money in the bank
    public double getTotalBankBalance() {
        double total = 0;
        for (BankAccount account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
    
    // Gets number of accounts
    public int getAccountCount() {
        return accounts.size();
    }
    
    // Gets transaction count
    public int getTransactionCount() {
        return totalTransactions;
    }
    
    // Displays all accounts
    public void displayAllAccounts() {
        System.out.println("\n=== ALL BANK ACCOUNTS ===");
        if (accounts.isEmpty()) {
            System.out.println("No accounts yet.");
        } else {
            for (BankAccount account : accounts) {
                System.out.println(account.getAccountInfo());
            }
        }
        System.out.println("Total accounts: " + accounts.size());
        System.out.println("Total bank balance: $" + getTotalBankBalance());
        System.out.println("=========================\n");
    }
    
    // Displays bank summary
    public void displayBankSummary() {
        System.out.println("\n=== BANK SUMMARY ===");
        System.out.println("Accounts: " + getAccountCount());
        System.out.println("Transactions: " + getTransactionCount());
        System.out.println("Total balance: $" + getTotalBankBalance());
        
        // Count by account type
        int checkingCount = 0;
        int savingsCount = 0;
        
        for (BankAccount account : accounts) {
            if (account.getType() == BankAccount.AccountType.CHECKING) {
                checkingCount++;
            } else {
                savingsCount++;
            }
        }
        
        System.out.println("Checking accounts: " + checkingCount);
        System.out.println("Savings accounts: " + savingsCount);
        System.out.println("====================\n");
    }
}