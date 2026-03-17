package services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import models.Employee;
// ====================================
// FILE 2: PayrollSystem.java (The CONTROLLER)
// ====================================
public class PayrollSystem {
    // STATIC variables (one copy shared by all)
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Employee> employees = new HashMap<>();
    static ArrayList<String> history = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("🎯 EMPLOYEE PAYROLL SYSTEM");
        
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
                case 6: deleteEmployee(); break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    
    static void showMenu() {
        System.out.println("\n=== PAYROLL MENU ===");
        System.out.println("1. Register Employee");
        System.out.println("2. Add Allowance");
        System.out.println("3. Calculate Pay");
        System.out.println("4. Generate Payslip");
        System.out.println("5. Display All Employees");
        System.out.println("6. Delete Employee");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }
    
    // METHOD 1: Register Employee (CREATE)
    static void registerEmployee() {
        System.out.println("\n--- REGISTER EMPLOYEE ---");
        
        // Get inputs
        System.out.print("Employee ID: ");
        String id = sc.nextLine();
        
        // VALIDATION: ID not empty
        if(id.trim().isEmpty()) {
            System.out.println("ERROR: ID cannot be empty!");
            return;
        }
        
        // VALIDATION: ID unique
        if(employees.containsKey(id)) {
            System.out.println("ERROR: Employee ID already exists!");
            return;
        }
        
        System.out.print("Employee Name: ");
        String name = sc.nextLine();
        
        // VALIDATION: Name not empty
        if(name.trim().isEmpty()) {
            System.out.println("ERROR: Name cannot be empty!");
            return;
        }
        
        System.out.print("Basic Salary: $");
        double salary = sc.nextDouble();
        sc.nextLine();
        
        // VALIDATION: Salary > 0
        if(salary <= 0) {
            System.out.println("ERROR: Salary must be greater than 0!");
            return;
        }
        
        // Create and store
        Employee emp = new Employee(id, name, salary);
        employees.put(id, emp);
        history.add("Registered: " + name + " (ID: " + id + ")");
        
        System.out.println("✅ Employee registered successfully!");
        emp.displayPayslip(); // Show immediately
    }
    
    // METHOD 2: Add Allowance (UPDATE)
    static void addAllowance() {
        System.out.println("\n--- ADD ALLOWANCE ---");
        
        // Find employee
        System.out.print("Employee ID: ");
        String id = sc.nextLine();
        
        // VALIDATION: Employee exists
        if(!employees.containsKey(id)) {
            System.out.println("ERROR: Employee not found!");
            return;
        }
        
        Employee emp = employees.get(id);
        
        System.out.print("Allowance amount: $");
        double allowance = sc.nextDouble();
        sc.nextLine();
        
        // VALIDATION: Allowance ≥ 0
        if(allowance < 0) {
            System.out.println("ERROR: Allowance cannot be negative!");
            return;
        }
        
        // Update
        double current = emp.getAllowances();
        emp.setAllowances(current + allowance);
        history.add("Allowance: +$" + allowance + " for " + emp.getName());
        
        System.out.println("✅ Allowance added! New total: $" + emp.getAllowances());
    }
    
    // METHOD 3: Calculate Pay (PROCESS)
    static void calculatePay() {
        System.out.println("\n--- CALCULATE PAY ---");
        
        System.out.print("Employee ID: ");
        String id = sc.nextLine();
        
        if(!employees.containsKey(id)) {
            System.out.println("ERROR: Employee not found!");
            return;
        }
        
        Employee emp = employees.get(id);
        
        // Ask for tax rate if needed
        System.out.print("Enter tax rate % (or press Enter for default 10%): ");
        String taxInput = sc.nextLine();
        
        if(!taxInput.isEmpty()) {
            double taxRate = Double.parseDouble(taxInput) / 100.0;
            emp.setTaxRate(taxRate);
        }
        
        // Show calculation
        System.out.println("\n📊 PAY CALCULATION for " + emp.getName());
        System.out.println("Basic: $" + emp.getBasicSalary());
        System.out.println("Allowances: $" + emp.getAllowances());
        System.out.println("Gross: $" + emp.calculateGrossSalary());
        System.out.println("Tax: $" + emp.calculateTax());
        System.out.println("NET: $" + emp.calculateNetSalary());
        
        history.add("Calculated pay for " + emp.getName());
    }
    
    // METHOD 4: Generate Payslip (READ)
    static void generatePayslip() {
        System.out.println("\n--- GENERATE PAYSLIP ---");
        
        System.out.print("Employee ID: ");
        String id = sc.nextLine();
        
        if(!employees.containsKey(id)) {
            System.out.println("ERROR: Employee not found!");
            return;
        }
        
        employees.get(id).displayPayslip();
        history.add("Generated payslip for ID: " + id);
    }
    
    // METHOD 5: Display All Employees (READ ALL)
    static void displayAllEmployees() {
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
    
    // METHOD 6: Delete Employee (DELETE)
    static void deleteEmployee() {
        System.out.println("\n--- DELETE EMPLOYEE ---");
        
        System.out.print("Employee ID: ");
        String id = sc.nextLine();
        
        if(!employees.containsKey(id)) {
            System.out.println("ERROR: Employee not found!");
            return;
        }
        
        Employee emp = employees.get(id);
        System.out.print("Delete " + emp.getName() + "? (yes/no): ");
        String confirm = sc.nextLine();
        
        if(confirm.equalsIgnoreCase("yes")) {
            employees.remove(id);
            history.add("Deleted: " + emp.getName());
            System.out.println("✅ Employee deleted.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
}