package com.twu.biblioteca;

import java.util.ArrayList;

public class Movie {
    private String title;
    private int year;
    private String director;
    private int rating = 0;

    public Movie(String title, int year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
    }

    public Movie(String title, int year, String director, int rating){
        this.title = title;
        this.year = year;
        this.director = director;
        setRating(rating);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int newRating){
       if(newRating > 0 && newRating <= 10){
           this.rating = newRating;
       }
    }

    public static void displayMovie(ArrayList<Movie> list){
        System.out.println(toString(list));
    }

    public static String toString(ArrayList<Movie> movieList){
        String titleTemplate = "%-5s %-20s %-20s %-15s %-6s%n";
        String result = "";
        System.out.println("***************Movie List**********************");
        System.out.printf(titleTemplate, "Id", "Title", "Year", "Director", "Rating");
        int index = 1;
        for(Movie movie: movieList){
            result += String.format("%-5s %-20s %-20s %-15s %-6s%n", index, movie.getTitle(),movie.getYear(),
                    movie.getDirector(),movie.getRating());
            index++;
        }
        return result;
    }
}
