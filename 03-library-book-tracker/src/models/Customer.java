package models;

import java.util.List;
import java.util.ArrayList;
public class Customer{
    private String customerId;
    private String name;
    private List<Book> borrowedBooks;
    public Customer(String customerId, String name){
        if (customerId == null || customerId.trim().isEmpty()){
            throw new IllegalArgumentException("Customer ID required");
        }

        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name required");
        }

        this.customerId = customerId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

     public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            borrowedBooks.add(book);
            System.out.println(name + " borrowed " + book.getTitle());
        }
    }

   public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
            System.out.println(name + " returned " + book.getTitle());
        }
    }    

    public String getCustomerId(){
        return customerId;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Customer: "+ name +"(ID: " + customerId + ")";
    }
}