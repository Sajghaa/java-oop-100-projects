package models;

public class Employee {
    // Private properties
    private String id;
    private String name;
    private double basicSalary;
    private double allowances;
    private double taxRate;
    
    // Constructor
    public Employee(String id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.allowances = 0.0;
        this.taxRate = 0.1; // 10% default
    }
    
    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getBasicSalary() { return basicSalary; }
    public double getAllowances() { return allowances; }
    public double getTaxRate() { return taxRate; }
    
    // Setters with validation
    public void setAllowances(double allowances) {
        if(allowances >= 0) {
            this.allowances = allowances;
        }
    }
    
    public void setTaxRate(double taxRate) {
        if(taxRate >= 0 && taxRate <= 1) {
            this.taxRate = taxRate;
        }
    }
    
    // Business methods
    public double calculateGrossSalary() {
        return basicSalary + allowances;
    }
    
    public double calculateTax() {
        return calculateGrossSalary() * taxRate;
    }
    
    public double calculateNetSalary() {
        return calculateGrossSalary() - calculateTax();
    }
    
    public void displayPayslip() {
        System.out.println("\n═══════════════════════════════");
        System.out.println("        PAYSLIP");
        System.out.println("═══════════════════════════════");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: $" + basicSalary);
        System.out.println("Allowances: $" + allowances);
        System.out.println("Gross Salary: $" + calculateGrossSalary());
        System.out.println("Tax (" + (taxRate*100) + "%): $" + calculateTax());
        System.out.println("═══════════════════════════════");
        System.out.println("NET SALARY: $" + calculateNetSalary());
        System.out.println("═══════════════════════════════");
    }
}