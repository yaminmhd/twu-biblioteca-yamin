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

    Movie getMovie(int index) {
        return movieList.get(index - 1);
    }

    void addMovie(Movie movie){
        movieList.add(movie);
    }

    void checkoutMovie(int index){
        Movie movie;
        if (index <= 0 || index > movieList.size()) {
            System.out.println("Movie id does not exist! Try again with another id");
            return;
        }
        movie = getMovie(index);

        if (!movie.getIsMovieAvailable()) {
            System.out.println("That movie is not available");
        } else {
            movie.markMovieAsBorrowed();
            movieList.remove(movie);
            addToCheckoutListMovie(movie);
            System.out.println("Thank you! Enjoy the movie");
        }
    }

    void addToCheckoutListMovie(Movie movie){
        checkedOutMovieList.add(movie);
    }




}
