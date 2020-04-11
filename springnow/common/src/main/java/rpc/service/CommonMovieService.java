package rpc.service;

//import ro.ubb.rpc.domain.Movie;

import rpc.domain.Movie;

import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface CommonMovieService {




    void addMovie(Movie movie);
    void deleteMovie(Long id) throws SQLException;
    void updateMovie(Movie movie);
    boolean isPresent(Long id);
    Set<Movie> getAll() throws SQLException;
}

