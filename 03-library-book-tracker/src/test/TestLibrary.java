package test;
import models.Book;
import models.Customer;

public class TestLibrary {
    public static void main(String[] args) {
        Book book = new Book("Java", "John", "1234567890");
        Customer customer = new Customer("C001", "Alice");
        
        System.out.println(book);
        System.out.println(customer);
        
        book.borrowBook();
        System.out.println("After: " + book);
    }
}