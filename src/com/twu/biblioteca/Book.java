package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int yearPublished;
    private boolean isBookAvailable = true;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public boolean getIsBookAvailable() {
        return isBookAvailable;
    }

    public void setBookAvailable(boolean bookAvailable) {
        this.isBookAvailable = bookAvailable;
    }
}
