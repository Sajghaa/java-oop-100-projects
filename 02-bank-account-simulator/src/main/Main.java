package main;

import model.BankAccount;
import service.BankService;

import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        BankService service  = new BankService();

        BankAccount account = new BankAccount("001", "John Doe", 1000);

        boolean running = true;


        while (running) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. View Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Choose option");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    service.showAccount(account);
                    break;

                case 2:
                    System.out.println("Enter deposit amount");
                    double depositAmount = scanner.nextDouble();
                    service.deposit(account, depositAmount);
                    break;
                
                case 3:
                    System.out.print("Enter withdraw amount:");
                    double withdrawAmount =  scanner.nextDouble();
                    service.withdraw(account, withdrawAmount);
                    break;
                
                case 4: 
                    running = false;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }

        scanner.close();
    }
}