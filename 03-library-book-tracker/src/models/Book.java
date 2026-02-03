package models;

public class Book{

    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // C: Creations here I'm just applied my formula 
    public Book(String title, String author, String isbn){
        
        if (title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("Title is required");
        }

        if (author == null || author.trim().isEmpty()){
            throw new IllegalArgumentException("Author is required");
        }
        
        if (isbn == null || isbn.trim().isEmpty()){
            throw new IllegalArgumentException("ISBN is required");
        }

        this.title = title.trim();
        this.author =author.trim();
        this.isbn = isbn.trim();
        this.isAvailable = true;
    }
}