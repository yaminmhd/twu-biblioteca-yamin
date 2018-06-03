package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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

    @Test //TODO
    public void shouldDisplayMenuOptionsToUser(){
        library.displayMenuOptions();
        assertThat(outContent.toString(), containsString("menu"));
    }

}