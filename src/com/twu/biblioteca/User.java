package com.twu.biblioteca;

public class User {
    //private static int LIBRARY_NUMBER = 0000001;
    private String username;
    private String password;
    private String libraryNumber;
    private boolean isLoggedIn = false;

    public User(String username, String password, String libraryNumber) {
        this.username = username;
        this.password = password;
        this.libraryNumber = libraryNumber;
    }

    public boolean isLoggedIn(){
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean status){
        isLoggedIn = status;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getLibraryNumber(){
        return libraryNumber;
    }

}
