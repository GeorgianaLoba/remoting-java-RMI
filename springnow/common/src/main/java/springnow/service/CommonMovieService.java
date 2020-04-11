package springnow.service;


import springnow.domain.Movie;

import java.sql.SQLException;
import java.util.List;

public interface CommonMovieService {
    void addMovie(Movie movie);
    void deleteMovie(Long id) throws SQLException;
    void updateMovie(Movie movie);
    boolean isPresent(Long id);
    List<Movie> getAll() throws SQLException;
}

