package services;

import models.Book;
import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> allBooks;        // Knows ALL books
    private List<Customer> allCustomers; // Knows ALL customers
    
    public LibraryService() {
        this.allBooks = new ArrayList<>();
        this.allCustomers = new ArrayList<>();
    }
    
    // Add a book to library
    public void addBook(Book book) {
        allBooks.add(book);
        System.out.println("Added: " + book.getTitle());
    }
    
    // Find a book by ISBN
    public Book findBook(String isbn) {
        for (Book book : allBooks) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        System.out.println("Book not found with ISBN: " + isbn);
        return null;
    }
    
    // Show all available books
    public void showAvailableBooks() {
        System.out.println("\n=== Available Books ===");
        for (Book book : allBooks) {
            if (book.isAvailable()) {
                System.out.println("  " + book);
            }
        }
    }
}