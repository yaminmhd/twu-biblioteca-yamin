package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> bookList = new ArrayList<Book>();

    public Book getBook(int index) {
        return bookList.get(index-1);
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void start(){
        setupBookList();
        displayOpeningMessage();
        displayMenuOptions();
    }

    public void displayOpeningMessage() {
        System.out.println("Welcome to Biblioteca!");
        System.out.println("Total of " + bookList.size() + " books in the library");
    }


    public void displayMenuOptions() {
        char quit = 'n';
        while(quit != 'y' ){
            char choice = getInput();
            switch(choice){
                case '1': displayBooks();
                    break;

                case '2': quit = 'y';
                    break;

                default:
                    System.out.println("Select a valid option!");
            }
        }
    }

    private char getInput() {
        Scanner in = new Scanner(System.in);
        String optionMessage = "\nChoose a menu option\n\n" +
                "1 - List Books\n" +
                "2 - Quit\n";

        System.out.println(optionMessage);
        String input =  in.nextLine();
        return input.charAt(0);
    }


    private void setupBookList() {
        addBook(new Book("Harry Potter", "J.K Rowling", 1999));
        addBook(new Book("Lord Of The Rings", "Peter Jackson", 2001));
        addBook(new Book("Game Of Thrones", "Stephen Smith", 2007));
        addBook(new Book("Head First Java", "Kathy Sierra", 2010));
    }

    private void displayBooks(){
        String titleTemplate = "%-20s %-20s %-6s%n";
        String template = "%-20s %-20s %-6s%n";
        System.out.printf(titleTemplate, "Name", "Author", "Year Published");
        for(Book book : bookList){
            System.out.printf(template, book.getName(),
                    book.getAuthor(), book.getYearPublished());
        }
    }


}
