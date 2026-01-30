package service;

import model.BankAccount;
public class BankService {
    public void showAccount(BankAccount account){
        System.out.println(account.getAccountInfo());
    }

    public void deposit(BankAccount account, double amount){
        account.deposit(amount);
        System.out.println("Deposit completed");
    }

    public void withdraw(BankAccount account, double amount){
        boolean success = account.withdraw(amount);

        if (success){
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed: Insufficient balance.");
        }
    }

}
