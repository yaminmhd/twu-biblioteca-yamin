package com.twu.biblioteca;

import java.util.Scanner;

public class Library {
    BookDB db = new BookDB();

    void start() {
        displayOpeningMessage();
        displayMenuOptions();
    }

    void displayOpeningMessage() {
        System.out.println("Welcome to Biblioteca!");
        System.out.println("Total of " + db.bookList.size() + " books in the library");
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
                Book.displayBook(db.bookList);
                break;

            case "2":
                System.out.println("Enter the id of the book you plan to checkout");
                int index = getIndexInput();
                db.checkoutBook(index);
                break;

            case "3":
                if (db.checkedOutBookList.size() == 0) {
                    System.out.println("You have not checked out any books!Ø");
                    break;
                }
                Book.displayBook(db.checkedOutBookList);
                System.out.println("Enter the id of the book you plan to return");
                int returnBookIndex = getIndexInput();
                db.returnBook(returnBookIndex);
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
