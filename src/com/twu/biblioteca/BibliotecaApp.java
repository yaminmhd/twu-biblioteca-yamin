package com.twu.biblioteca;

import java.awt.print.Book;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BibliotecaApp {
    public static void start(){
        System.out.println("Welcome to Biblioteca!");
    }
    public static ArrayList<String> listBooks() {
        ArrayList<String> bookList= new ArrayList<String>();
        bookList.add("Harry Potter");
        bookList.add("Lord Of The Rings");
        bookList.add("Game Of Thrones");
        return bookList;
    }
    public static void main(String[] args) {
        start();
        System.out.println("I have " + listBooks().size() + " books in the library");

        for(String books : listBooks()){
            System.out.println("- " + books);
        }
    }
}
