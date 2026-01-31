package model;

public class BankAccount {
    // ========== FIELDS ==========
    private String accountNumber;
    private String ownerName;
    private double balance;
    private AccountType type;
    
    // ========== CONSTANTS ==========
    private static final double CHECKING_OVERDRAFT = -500.00;
    private static final double SAVINGS_OVERDRAFT = 0.00;
    
    // ========== ENUM ==========
    public enum AccountType {
        CHECKING,
        SAVINGS
    }
    
    // ========== CONSTRUCTOR ==========
    public BankAccount(String accountNumber, String ownerName, 
                      double balance, AccountType type) {
        // Basic validation
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number required");
        }
        if (ownerName == null || ownerName.isEmpty()) {
            throw new IllegalArgumentException("Owner name required");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        if (type == null) {
            throw new IllegalArgumentException("Account type required");
        }
        
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.type = type;
    }
    
    // ========== METHODS ==========
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive");
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return false;
        }
        
        // Check overdraft based on account type
        double minimumBalance = (type == AccountType.CHECKING) 
            ? CHECKING_OVERDRAFT 
            : SAVINGS_OVERDRAFT;
        
        if (balance - amount >= minimumBalance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient funds. Available: $" + balance);
            return false;
        }
    }
    
    // ========== GETTERS ==========
    public double getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getOwnerName() {
        return ownerName;
    }
    
    public AccountType getType() {
        return type;
    }
    
    public String getAccountInfo() {
        return String.format(
            "%s | Acc: %s | Type: %s | Balance: $%.2f",
            ownerName, accountNumber, type, balance
        );
    }
    
    // ========== BUILDER (Optional) ==========
    public static class Builder {
        private String accountNumber;
        private String ownerName;
        private double balance = 0.0;
        private AccountType type = AccountType.CHECKING;
        
        public Builder(String accountNumber, String ownerName) {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
        }
        
        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }
        
        public Builder type(AccountType type) {
            this.type = type;
            return this;
        }
        
        public BankAccount build() {
            return new BankAccount(accountNumber, ownerName, balance, type);
        }
    }
}