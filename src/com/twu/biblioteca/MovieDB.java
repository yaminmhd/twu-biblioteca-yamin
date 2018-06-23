package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieDB {

    MovieDB(){
        addMovie(new Movie("Dark Knight Rises", 2012, "Christopher Nolan", 8));
        addMovie(new Movie("Fast and Furious", 2006, "Justin Lin"));
        addMovie(new Movie("Fight Club", 1999, "David Fincher", 7));
    }

    ArrayList<Movie> movieList = new ArrayList<>();
    ArrayList<Movie> checkedOutMovieList = new ArrayList<>();

    void addMovie(Movie movie){
        movieList.add(movie);
    }


}
