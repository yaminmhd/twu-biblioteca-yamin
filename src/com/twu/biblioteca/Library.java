package com.twu.biblioteca;

import java.util.Scanner;

public class Library {
    BookDB bookDB = new BookDB();
    MovieDB movieDB = new MovieDB();

    void start() {
        displayOpeningMessage();
        displayMenuOptions();
    }

    void displayOpeningMessage() {
        System.out.println("Welcome to Biblioteca!");
        System.out.println("Total of " + bookDB.bookList.size() + " books in the library");
        System.out.println("Total of " + movieDB.movieList.size() + " movies in the library");
    }

    void displayMenuOptions() {
        String choice;
        do {
            showMenuMessage();
            choice = getInput();
            selectMenuOptionWithChoice(choice);
        } while (!choice.equals("q"));
    }

    private void selectMenuOptionWithChoice(String choice) {
        switch (choice) {
            case "1":
                Book.displayBook(bookDB.bookList);
                break;

            case "2":
                System.out.println("Enter the id of the book you plan to checkout");
                bookDB.checkoutBook(getIndexInput());
                break;

            case "3":
                if (bookDB.checkedOutBookList.size() == 0) {
                    System.out.println("You have not checked out any books!Ø");
                    break;
                }
                Book.displayBook(bookDB.checkedOutBookList);
                System.out.println("Enter the id of the book you plan to return");
                bookDB.returnBook(getIndexInput());
                break;

            case "4":
                Movie.displayMovie(movieDB.movieList);
                break;

            case "5":
                System.out.println("Enter the id of the movie you plan to checkout");
                movieDB.checkoutMovie(getIndexInput());
                break;

            case "q":
                break;

            default:
                System.out.println("Select a valid option!");
        }
    }


    void showMenuMessage() {
        System.out.println("\nChoose a menu option\n\n" +
                "1 - List Books\n" +
                "2 - Check out Book\n" +
                "3 - Return book\n" +
                "4 - List Movies\n" +
                "5 - Check out Movie\n" +
                "Q - Quit\n");
    }

    private String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine().toLowerCase();
    }

    private int getIndexInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }


}
