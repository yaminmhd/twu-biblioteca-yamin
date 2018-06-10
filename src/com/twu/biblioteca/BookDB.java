package com.twu.biblioteca;

import java.util.ArrayList;

public class BookDB {

    BookDB() {
        addBook(new Book("Harry Potter", "J.K Rowling", 1999));
        addBook(new Book("Lord Of The Rings", "Peter Jackson", 2001));
        addBook(new Book("Game Of Thrones", "Stephen Smith", 2007));
        addBook(new Book("Head First Java", "Kathy Sierra", 2010));
    }

    ArrayList<Book> bookList = new ArrayList<>();
    ArrayList<Book> checkedOutBookList = new ArrayList<>();

    void returnBook(int returnBookIndex) {
        Book book;
        if (returnBookIndex <= 0 || returnBookIndex > checkedOutBookList.size()) {
            System.out.println("That is not a valid book to return");
            return;
        }

        book = getCheckedoutBook(returnBookIndex);
        book.markBookAsAvailable();
        checkedOutBookList.remove(book);
        bookList.add(book);
        System.out.println("Thank you for returning the book");
    }


    void checkoutBook(int index) {
        Book book;
        if (index <= 0 || index > bookList.size()) {
            System.out.println("Book id does not exist! Try again with another id");
            return;
        }
        book = getBook(index);
        if (!book.getIsBookAvailable()) {
            System.out.println("That book is not available");
        } else {
            book.markBookAsBorrowed();
            bookList.remove(book);
            addToCheckoutListBook(book);
            System.out.println("Thank you! Enjoy the book");
        }

    }

    Book getBook(int index) {
        return bookList.get(index - 1);
    }

    Book getCheckedoutBook(int index) {
        return checkedOutBookList.get(index - 1);
    }

    void addBook(Book book) {
        bookList.add(book);
    }

    void addToCheckoutListBook(Book book) {
        checkedOutBookList.add(book);
    }


}
