package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public ArrayList<Book> bookList = new ArrayList<>();
    public ArrayList<Book> checkedOutBookList = new ArrayList<>();

    public Book getBook(int index) {
        return bookList.get(index-1);
    }

    public Book getCheckedoutBook(int index) {
        return checkedOutBookList.get(index-1);
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void addToCheckoutListBook(Book book) {
        checkedOutBookList.add(book);
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
        String choice;
        do{
            showMenuMessage();
            choice = getInput();
            selectMenuOptionWithChoice(choice);
        } while(!choice.equals("q"));
    }

    public void selectMenuOptionWithChoice(String choice) {
        switch(choice){
            case "1":
                displayBooks();
                break;

            case "2":
                System.out.println("Enter the id of the book you plan to checkout");
                int index = getIndexInput();
                checkoutBook(index);
                break;

            case "3":
                if(checkedOutBookList.size() == 0){
                    System.out.println("You have not checked out any books!");
                    break;
                }
                displayCheckedoutBooks();
                System.out.println("Enter the id of the book you plan to return");
                int returnBookIndex = getIndexInput();
                returnBook(returnBookIndex);
                break;

            case "q":
                break;

            default:
                System.out.println("Select a valid option!");
        }
    }

    private void returnBook(int returnBookIndex) {
        Book book;
        if(returnBookIndex <= 0 || returnBookIndex > checkedOutBookList.size()){
            System.out.println("That is not a valid book to return");
            return;
        }

        book = getCheckedoutBook(returnBookIndex);
        checkedOutBookList.remove(book);
        bookList.add(book);
        System.out.println("Thank you for returning the book");
    }

    private int getIndexInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public void displayCheckedoutBooks() {
        System.out.println("Here's a list of your checked out books\n");
        int index = 1;
        for(Book book: checkedOutBookList){
            System.out.println(index + " " + book.getName());
            index++;
        }
    }

    public void checkoutBook(int index) {
        Book book;
        if(index <= 0 || index > bookList.size()){
            System.out.println("Book id does not exist! Try again with another id");
            return;
        }
        book = getBook(index);
        if(!book.getIsBookAvailable()){
            System.out.println("That book is not available");
        }else{
            book.setBookAvailable(false);
            bookList.remove(book);
            addToCheckoutListBook(book);
            System.out.println("Thank you! Enjoy the book");
        }

    }

    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine().toLowerCase();
    }

    public void showMenuMessage() {
        System.out.println("\nChoose a menu option\n\n" +
                "1 - List Books\n" +
                "2 - Check out Book\n" +
                "3 - Return book\n" +
                "Q - Quit\n");
    }


    private void setupBookList() {
        addBook(new Book("Harry Potter", "J.K Rowling", 1999));
        addBook(new Book("Lord Of The Rings", "Peter Jackson", 2001));
        addBook(new Book("Game Of Thrones", "Stephen Smith", 2007));
        addBook(new Book("Head First Java", "Kathy Sierra", 2010));
    }

    private void displayBooks(){
        String titleTemplate = "%-5s %-20s %-20s %-15s %-6s%n";
        String template = "%-5s %-20s %-20s %-15s %-6s%n";
        System.out.println("***************Book List**********************");
        System.out.printf(titleTemplate, "Id", "Name", "Author", "Year Published", "Available");
        int index = 1;
        for(Book book : bookList){
            System.out.printf(template, index, book.getName(),
                    book.getAuthor(), book.getYearPublished(), book.getIsBookAvailable());
            index++;
        }
        System.out.println("***************End of Book List***************");
    }


}
