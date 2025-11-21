package model;

public class Book {
    private String title;
    private String author;
    private String id;
    private boolean borrowed;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return borrowed; }

    public void borrow() { this.borrowed = true; }
    public void returned() { this.borrowed = false; }
}

