package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.awt.print.Book;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void seeOpeningMessageUponApplicationStart(){
        BibliotecaApp.start();
        String expected = "Welcome to Biblioteca!\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void ListBooks(){
        ArrayList<String> bookList = BibliotecaApp.listBooks();
        assertTrue(bookList.size() == 3);
    }

}
