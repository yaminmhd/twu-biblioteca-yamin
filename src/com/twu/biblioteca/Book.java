package com.twu.biblioteca;

import java.util.ArrayList;

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

    public boolean getIsBookAvailable() {
        return isBookAvailable;
    }

    public void markBookAsAvailable(){
        this.isBookAvailable = true;
    }

    public void markBookAsBorrowed(){
        this.isBookAvailable = false;
    }

    public static void displayBook(ArrayList<Book> list){
        System.out.println(toString(list));
    }

    public static String toString(ArrayList<Book> bookList){
        String titleTemplate = "%-5s %-20s %-20s %-15s %-6s%n";
        String result = "";
        System.out.println("***************Book List**********************");
        System.out.printf(titleTemplate, "Id", "Name", "Author", "Year Published", "Available");
        int index = 1;
        for(Book book: bookList){
            result += String.format("%-5s %-20s %-20s %-15s %-6s%n", index, book.getName(),book.getAuthor(),
                    book.getYearPublished(),book.getIsBookAvailable());
            index++;
        }
        return result;
    }
}
