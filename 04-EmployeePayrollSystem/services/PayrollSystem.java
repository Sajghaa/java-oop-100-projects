package services;

import models.Employee;
import java.util.Scanner;
import java.util.HashMap;

public class PayrollSystem {
    // Static variables
    private static Scanner sc = new Scanner(System.in);
    private static HashMap<String, Employee> employees = new HashMap<>();
    
    public static void main(String[] args) {
        System.out.println(" EMPLOYEE PAYROLL SYSTEM");
        
        while(true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            
            if(choice == 0) {
                System.out.println("Goodbye!");
                break;
            }
            
            switch(choice) {
                case 1: registerEmployee(); break;
                case 2: addAllowance(); break;
                case 3: calculatePay(); break;
                case 4: generatePayslip(); break;
                case 5: displayAllEmployees(); break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void showMenu() {
        System.out.println("\n=== PAYROLL MENU ===");
        System.out.println("1. Register Employee");
        System.out.println("2. Add Allowance");
        System.out.println("3. Calculate Pay");
        System.out.println("4. Generate Payslip");
        System.out.println("5. Display All Employees");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }
    
    private static void registerEmployee() {
        System.out.println("\n--- REGISTER EMPLOYEE ---");
        
        System.out.print("Employee ID: ");
        String id = sc.nextLine();
        
        if(id.trim().isEmpty()) {
            System.out.println("ERROR: ID cannot be empty!");
            return;
        }
        
        if(employees.containsKey(id)) {
            System.out.println("ERROR: ID already exists!");
            return;
        }
        
        System.out.print("Employee Name: ");
        String name = sc.nextLine();
        
        if(name.trim().isEmpty()) {
            System.out.println("ERROR: Name cannot be empty!");
            return;
        }
        
        System.out.print("Basic Salary: $");
        double salary = sc.nextDouble();
        sc.nextLine();
        
        if(salary <= 0) {
            System.out.println("ERROR: Salary must be > 0!");
            return;
        }
        
        Employee emp = new Employee(id, name, salary);
        employees.put(id, emp);
        System.out.println(" Employee registered!");
    }
    
    private static void addAllowance() {
        System.out.println("\n--- ADD ALLOWANCE ---");
        
        System.out.print("Employee ID: ");
        String id = sc.nextLine();
        
        if(!employees.containsKey(id)) {
            System.out.println("ERROR: Employee not found!");
            return;
        }
        
        Employee emp = employees.get(id);
        
        System.out.print("Allowance amount: $");
        double allowance = sc.nextDouble();
        sc.nextLine();
        
        if(allowance < 0) {
            System.out.println("ERROR: Allowance cannot be negative!");
            return;
        }
        
        emp.setAllowances(emp.getAllowances() + allowance);
        System.out.println(" Allowance added! Total: $" + emp.getAllowances());
    }
    
    private static void calculatePay() {
        System.out.println("\n--- CALCULATE PAY ---");
        
        System.out.print("Employee ID: ");
        String id = sc.nextLine();
        
        if(!employees.containsKey(id)) {
            System.out.println("ERROR: Employee not found!");
            return;
        }
        
        Employee emp = employees.get(id);
        
        System.out.print("Tax rate % (Enter for default 10%): ");
        String taxInput = sc.nextLine();
        
        if(!taxInput.isEmpty()) {
            double taxRate = Double.parseDouble(taxInput) / 100.0;
            emp.setTaxRate(taxRate);
        }
        
        System.out.println("\n PAY for " + emp.getName());
        System.out.println("Net Salary: $" + emp.calculateNetSalary());
    }
    
    private static void generatePayslip() {
        System.out.println("\n--- GENERATE PAYSLIP ---");
        
        System.out.print("Employee ID: ");
        String id = sc.nextLine();
        
        if(!employees.containsKey(id)) {
            System.out.println("ERROR: Employee not found!");
            return;
        }
        
        employees.get(id).displayPayslip();
    }
    
    private static void displayAllEmployees() {
        System.out.println("\n=== ALL EMPLOYEES ===");
        
        if(employees.isEmpty()) {
            System.out.println("No employees registered.");
            return;
        }
        
        for(Employee emp : employees.values()) {
            System.out.println("ID: " + emp.getId() + 
                             " | Name: " + emp.getName() + 
                             " | Net: $" + emp.calculateNetSalary());
        }
    }
}