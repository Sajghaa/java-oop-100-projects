// File: src/test/TestBook.java
package test;
import models.Book;  // Import from models package

public class TestBook {
    public static void main(String[] args) {
        System.out.println("=== Testing Book Class ===\n");
        
        // Test 1: Create books
        Book book1 = new Book("Java Programming", "John Doe", "1234567890");
        Book book2 = new Book("Python Basics", "Jane Smith", "0987654321");
        
        System.out.println("Book 1: " + book1);
        System.out.println("Book 2: " + book2);
        
        // Test 2: Borrow
        book1.borrowBook();
        System.out.println("\nAfter borrowing: " + book1);
        
        // Test 3: Try borrowing again
        book1.borrowBook();
        
        // Test 4: Return
        book1.returnBook();
        System.out.println("\nAfter returning: " + book1);
    }
}