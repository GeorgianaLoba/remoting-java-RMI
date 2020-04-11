package springnow.serverService;


import org.springframework.beans.factory.annotation.Autowired;
import springnow.domain.Movie;
import springnow.service.CommonMovieService;
import springnow.service.MovieService;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class ServerMovieService implements CommonMovieService {

    @Autowired
    private MovieService movieService;

    @Override
    public void addMovie(Movie movie) {
        movieService.addMovie(movie);
    }

    @Override
    public void deleteMovie(Long id) throws SQLException{
        movieService.deleteMovie(id);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieService.updateMovie(movie);
    }

    @Override
    public boolean isPresent(Long id) {
        return movieService.isPresent(id);
    }

    @Override
    public List<Movie> getAll() throws SQLException {
        return movieService.getAllMovies();
    }
}
