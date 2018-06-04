package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class LibraryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    Library library;


    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        library = new Library();
    }

    @After
    public void tearDown(){
        System.setOut(null);
    }

    @Test
    public void shouldDisplayWelcomeMessage(){
        library.displayOpeningMessage();
        assertThat(outContent.toString(), containsString("Welcome"));
    }

    @Test
    public void shouldDisplayMenuMessageToUser(){
        library.showMenuMessage();
        assertThat(outContent.toString(), containsString("menu"));
    }

    @Test
    public void shouldBeAbletoAddToBookList(){
        Book testBook = new Book("Test Book", "Tester", 1995);
        library.addBook(testBook);
        assertEquals(1, library.bookList.size());
    }

    @Test
    public void shouldBeAbleToCheckoutAvailableBook(){
        library.addBook(new Book("Junit Book", "Junit", 1995));
        library.addBook(new Book("TestNG Book", "Test NG", 1996));

        library.checkoutBook(1);
        assertEquals(false, library.getBook(1).getIsBookAvailable());
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookIfNotAvailable(){
        library.addBook(new Book("Junit Book", "Junit", 1995));
        library.addBook(new Book("TestNG Book", "Test NG", 1996));

        library.getBook(1).setBookAvailable(false);
        library.checkoutBook(1);
        assertEquals("That book is not available\n", outContent.toString());
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookIfIdDoesNotExist(){
        library.addBook(new Book("Junit Book", "Junit", 1995));
        library.addBook(new Book("TestNG Book", "Test NG", 1996));
        library.checkoutBook(0);
        assertEquals("Book id does not exist! Try again with another id\n", outContent.toString());
    }






}