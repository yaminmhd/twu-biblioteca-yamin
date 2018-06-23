package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BookDBTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    BookDB db;

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        db = new BookDB();
    }

    @After
    public void tearDown(){
        System.setOut(null);
    }

    @Test
    public void shouldBeAbletoAddToBookList(){
        Book testBook = new Book("Test Book", "Tester", 1995);
        db.addBook(testBook);
        assertEquals(5, db.bookList.size());
    }

    @Test
    public void shouldBeAbleToCheckoutAvailableBook(){
        db.checkoutBook(1);
        assertEquals(false, db.getCheckedoutBook(1).getIsBookAvailable());
        assertEquals(3, db.bookList.size());
        assertEquals(1, db.checkedOutBookList.size());
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookIfNotAvailable(){
//        bookDB.addBook(new Book("Junit Book", "Junit", 1995));
//        bookDB.addBook(new Book("TestNG Book", "Test NG", 1996));

        db.getBook(1).markBookAsBorrowed();
        db.checkoutBook(1);
        assertEquals("That book is not available\n", outContent.toString());
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookIfIdDoesNotExist(){
//        bookDB.addBook(new Book("Junit Book", "Junit", 1995));
//        bookDB.addBook(new Book("TestNG Book", "Test NG", 1996));
        db.checkoutBook(0);
        assertEquals("Book id does not exist! Try again with another id\n", outContent.toString());
    }

    @Test
    public void shouldBeAbleToReturnCheckoutBook(){
//        bookDB.addBook(new Book("Junit Book", "Junit", 1995));
//        bookDB.addBook(new Book("TestNG Book", "Test NG", 1996));
        db.checkoutBook(1);
        db.returnBook(1);
        assertEquals(4, db.bookList.size());
        assertEquals(true, db.getBook(1).getIsBookAvailable());
        assertThat(outContent.toString(), containsString("Thank you for returning the book"));
    }

    @Test
    public void shouldNotBeAbleToReturnCheckoutBookIfIdIsOutOfIndex(){
//        bookDB.addBook(new Book("Junit Book", "Junit", 1995));
//        bookDB.addBook(new Book("TestNG Book", "Test NG", 1996));
        db.checkoutBook(1);
        db.returnBook(0);
        assertThat(outContent.toString(), containsString("That is not a valid book to return"));
    }

    @Test
    public void shouldNotBeAbleToReturnCheckoutBookIfIdIsAboveTheSizeOfList(){
//        bookDB.addBook(new Book("Junit Book", "Junit", 1995));
//        bookDB.addBook(new Book("TestNG Book", "Test NG", 1996));
        db.checkoutBook(1);
        db.returnBook(5);
        assertThat(outContent.toString(), containsString("That is not a valid book to return"));
    }
}
