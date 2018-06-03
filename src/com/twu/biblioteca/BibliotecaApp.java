package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    public static void start(){
        System.out.println("Welcome to Biblioteca!");
    }
    public static ArrayList<Book> listBooks() {
        ArrayList<Book> bookList= new ArrayList<Book>();
        bookList.add(new Book("Harry Potter", "J.K Rowling", 1999));
        bookList.add(new Book("Lord Of The Rings", "Peter Jackson", 2001));
        bookList.add(new Book("Game Of Thrones", "Stephen Smith", 2007));
        bookList.add(new Book("Head First Java", "Kathy Sierra", 2010));
        return bookList;
    }
    public static void main(String[] args) {
        start();
        System.out.println("Total of " + listBooks().size() + " books in the library\n");

        String titleTemplate = "%-20s %-20s %-6s%n";
        String template = "%-20s %-20s %-6s%n";

        System.out.printf(titleTemplate, "Name", "Author", "Year Published");

        for(Book book : listBooks()){
//            System.out.println("*****\n" +
//                                "Name - " + book.getName() + "\n" +
//                                "Author - " + book.getAuthor() + "\n" +
//                                "Year Published - " + book.getYearPublished() + "\n"
//            );
            System.out.printf(template, book.getName(),
                    book.getAuthor(), book.getYearPublished());
        }
    }
}
