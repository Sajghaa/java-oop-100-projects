package test;

import models.Book;

public class TestBook {
    public static void main(String[] args) {
        System.out.println("=== Testing Book Class ===\n");
        
        // Test 1: Create books
        System.out.println("1. Creating books...");
        Book book1 = new Book("Java Programming", "John Doe", "1234567890");
        Book book2 = new Book("Python Basics", "Jane Smith", "0987654321");
        System.out.println("   Created: " + book1);
        System.out.println("   Created: " + book2);
        
        // Test 2: Borrow/Return cycle
        System.out.println("\n2. Testing borrow/return...");
        book1.borrowBook();
        System.out.println("   Book1 status: " + book1);
        book1.borrowBook(); // Try borrowing again
        book1.returnBook();
        System.out.println("   Book1 after return: " + book1);
        
        // Test 3: Equality test
        System.out.println("\n3. Testing equality...");
        Book book3 = new Book("Different Title", "Different Author", "1234567890");
        System.out.println("   book1 ISBN: " + book1.getIsbn());
        System.out.println("   book3 ISBN: " + book3.getIsbn());
        System.out.println("   book1.equals(book3)? " + book1.equals(book3));
        System.out.println("   book1.equals(book2)? " + book1.equals(book2));
        
        // Test 4: Getters
        System.out.println("\n4. Testing getters...");
        System.out.println("   Book2 title: " + book2.getTitle());
        System.out.println("   Book2 author: " + book2.getAuthor());
        System.out.println("   Book2 available? " + book2.isAvailable());
        
        // Test 5: Invalid creation (should crash)
        System.out.println("\n5. Testing validation...");
        try {
            Book badBook = new Book("", "Author", "123");
            System.out.println("   ERROR: Should have thrown exception!");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ Correctly caught: " + e.getMessage());
        }
        
        System.out.println("\n=== All tests completed ===");
    }
}