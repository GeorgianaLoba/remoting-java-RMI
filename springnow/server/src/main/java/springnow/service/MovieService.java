package springnow.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import springnow.domain.Movie;
import springnow.repository.InterfaceRepository;
import springnow.repository.MovieDBRepository;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class MovieService {
    @Autowired
    private MovieDBRepository repository;

    public List<Movie> getAllMovies() throws SQLException {
        Iterable<Movie> movies=repository.findALL();
        return StreamSupport.stream(movies.spliterator(),false).collect(Collectors.toList());
    }

    public void addMovie (Movie movie){
        repository.save(movie);
    }

    public void updateMovie(Movie movie)
    {
        repository.save(movie);
    }

    public void deleteMovie(Long id) throws SQLException {
        repository.delete(id);
    }

    public Set<Movie> filterMovieByTitle(String s) throws SQLException {
        Iterable<Movie> movies=repository.findALL();
        Set<Movie> filteredMovie=new HashSet<>();
        movies.forEach(filteredMovie::add);
        filteredMovie.removeIf(movie -> !movie.getTitle().contains(s));
        return StreamSupport.stream(filteredMovie.spliterator(),false).collect(Collectors.toSet());
    }

    public boolean isPresent (Long id){
        try{
            repository.findOne(id);
            return true;
        }catch (IllegalArgumentException e)
        {
            return false;
        }
    }
}
