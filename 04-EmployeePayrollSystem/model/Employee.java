class Employee{

    private String id;
    private String name;
    private double basicSalary;
    private double allowances;
    private double taxRate; // e.g, 0.1 = 10%

    public Employee(String id, String name, double basicSalary){
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.allowances = 0.0;
        this.taxRate = 0.1;
    }

    // getters or we call controlled access
    public String getId(){ return id; }
    public String getName() { return name; }
    public double getBasicSalary() { return basicSalary; }
    public double getAllowances(){ return allowances; }
    public double getTaxRate(){ return taxRate; }

    // and then setters with validation
    public void setAllowances(double allowances){
        if(allowances >=0 ){
            this.allowances = allowances;
        } else {
            System.out.println("ERROR: Allowances cannot be negative");
        }
    }

    public void setTaxRates(double taxRate){
        if(taxRate >= 0 && taxRate <= 1){
            this.taxRate = taxRate;
        } else {
            System.out.println("ERROR: Tax rate must be between 0 and 1(0% - 100%)! ");
        }
    }
    // And then business Logic Methods

    public double calculateGrossSalary(){
        return basicSalary + allowances;
    }

    public double calculateTax(){
        return calculateGrossSalary() * taxRate;
    }

    public double calculateNetSalary(){
        return calculateGrossSalary() - calculateTax();
    }
    // Display method
    public void displayPayslip(){
        System.out.println("\n======================");
        System.out.println("      PAYSLIP           ");
        System.out.println("========================");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: $" + basicSalary);
        System.out.println("Allowances: $" +allowances);
        System.out.println("Gross Salary: $"+calculateGrossSalary());
        System.out.println("Tax (" + (taxRate*100) + "%): $" + calculateTax());
        System.out.println("========================");
        System.out.println("NET SALARY: $" + calculateNetSalary());
        System.out.println("=========================");
    }
}