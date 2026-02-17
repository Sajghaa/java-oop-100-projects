package models;
public class Customer{
    private String customerId;
    private String name;

    public Customer(String customerId, String name){
        if (customerId == null || customerId.trim().isEmpty()){
            throw new IllegalArgumentException("Customer ID required");
        }

        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name required");
        }

        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId(){
        return customerId;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Customer: "+ name +"(ID: " + customerId + "";
    }
}