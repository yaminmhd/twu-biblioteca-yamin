package com.twu.biblioteca;

import java.util.ArrayList;

public class UserDB {
    ArrayList<User> usersList = new ArrayList<>();
    User currentUser;


    UserDB(){
        addUser(new User("yamin",  "123", "000-0001"));
        addUser(new User("dave", "12345", "000-0002"));
        addUser(new User("jack", "123456", "000-0003"));
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
