package springnow.serverService;


import org.springframework.beans.factory.annotation.Autowired;
import rpc.domain.Movie;
import rpc.service.CommonMovieService;
import springnow.service.MovieService;

import java.util.Set;

public class ServerMovieService implements CommonMovieService {

    @Autowired
    private MovieService movieService;

    @Override
    public void addMovie(Movie movie) {
        movieService.addMovie(movie);
    }

    @Override
    public void deleteMovie(Long id) {
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
    public Set<Movie> getAll(){
        return movieService.getAllMovies();

    }
}
