package com.twu.biblioteca;

import java.util.ArrayList;

public class UserDB {
    ArrayList<User> usersList = new ArrayList<>();
    User currentUser;
    BookDB bookDB;
    MovieDB movieDB;

    UserDB(){
        addUser(new User("yamin",  "123", "000-0001", "yamin@gmail.com", 97899034));
        addUser(new User("dave", "12345", "000-0002", "dave@gmail.com", 12332313));
        addUser(new User("jack", "123456", "000-0003", "jack@gmail.com", 89761234));
    }

    void addUser(User user) {
        usersList.add(user);
    }

    boolean isUserLoggedIn(){
        boolean result = false;
        for(User user: usersList){
            if(user.isLoggedIn()){
                result = true;
            }
        }
        return result;
    }

    User getCurrentUser(){
        return currentUser;
    }

    void displayUserDetails(User currentUser, ArrayList<Book> bookList){
        System.out.println("Here are your details");
        System.out.println("Name: " + currentUser.getUsername());
        System.out.println("Library Number: " + currentUser.getLibraryNumber());
        System.out.println("Email Address: " + currentUser.getEmailAddress());
        System.out.println("Phone Number: " + currentUser.getPhoneNumber());
        for(Book book: bookList){
            System.out.println("Books checked out by you - " + book.getName());
        }
    }

    void logout(User user){
        user.setIsLoggedIn(false);
        currentUser = null;
        System.out.println("You have logged out of the system!");
    }

    void login(String[] loginCredentials){
        String username = loginCredentials[0];
        String password = loginCredentials[1];
        if(authenticateUser(username, password ) != null){
            System.out.println("You have login successfully");
        }else{
            System.out.println("Your credentials are wrong. Please try again!");
        }
    }

    User authenticateUser(String libNum, String password){
        for(User user: usersList){
            if(user.getLibraryNumber().equals(libNum) && user.getPassword().equals(password)){
                user.setIsLoggedIn(true);
                currentUser = user;
                return user;
            }
        }
        return null;
    }
}
