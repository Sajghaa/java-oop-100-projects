package main;

import model.BankAccount;
import service.BankService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService service = new BankService();
        
        // Create an account using YOUR BankAccount constructor
        // Note: Your BankAccount needs 4 parameters, not 3!
        BankAccount account = new BankAccount("001", "John Doe", 1000.0, 
                                            BankAccount.AccountType.CHECKING);
        
        boolean running = true;
        
        System.out.println("=== Welcome to Bank Account Simulator ===");
        System.out.println("Account created for: " + account.getOwnerName());
        
        while (running) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. View Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1: // View Account
                    service.showAccount(account);
                    break;
                    
                case 2: // Deposit
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    service.deposit(account, depositAmount);
                    break;
                    
                case 3: // Withdraw
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    service.withdraw(account, withdrawAmount);
                    break;
                    
                case 4: // Transfer (NEW FEATURE!)
                    // Create a second account for transfer demo
                    BankAccount otherAccount = new BankAccount("002", "Jane Smith", 500.0,
                                                              BankAccount.AccountType.SAVINGS);
                    System.out.print("Enter transfer amount: $");
                    double transferAmount = scanner.nextDouble();
                    service.transfer(account, otherAccount, transferAmount);
                    break;
                    
                case 5: // Exit
                    running = false;
                    System.out.println("\nThank you for banking with us!");
                    System.out.println("Final balance: $" + account.getBalance());
                    break;
                    
                default:
                    System.out.println("Invalid option! Please choose 1-5.");
            }
        }
        
        scanner.close();
        System.out.println("Program ended.");
    }
}