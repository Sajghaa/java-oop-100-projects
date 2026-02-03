package models;

public class Book {
    // === FIELDS ===
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    
    // === CONSTRUCTOR (C - Creation) ===
    public Book(String title, String author, String isbn) {
        // Simple validation
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author is required");
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN is required");
        }
        
        this.title = title.trim();
        this.author = author.trim();
        this.isbn = isbn.trim();
        this.isAvailable = true; // New books are available
    }
    
    // === BEHAVIOR (B - Behavior) ===
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already borrowed!");
        }
    }
    
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was already available.");
        }
    }
    
    // === IDENTITY & EQUALITY (I & E) ===
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return isbn.equals(other.isbn);
    }
    
    @Override 
    public int hashCode() {
        return isbn.hashCode();
    }
    
    // === GETTERS (Data Access) ===
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    
    // === TO STRING ===
    @Override
    public String toString() {
        String status = isAvailable ? "Available" : "Borrowed";
        return title + " by " + author + " [" + status + "]";
    }
}