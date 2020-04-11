package springnow.repository.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import springnow.domain.Movie;
import springnow.domain.validators.MovieValidator;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class MovieAdapter implements Adapter<Long,Movie > {
    @Autowired
    JdbcOperations jdbcOperations;
    @Autowired
    MovieValidator movieValidator;

    @Override
    public List<Movie> findAll() throws SQLException {
        String sql="select * from movies";
        return jdbcOperations.query(sql, (rs, row)->makeMovie(rs));
    }

    @Override
    public Optional<Movie> findOne(Long id) throws SQLException {
        String sql = "select * from movies where id=";
        return Optional.ofNullable(jdbcOperations.queryForObject(sql, new Object[]{id},(rs,row)->makeMovie(rs)));
    }

    private Movie makeMovie(ResultSet rs) {
        Movie movie = new Movie();
        try {
            movie.setId((long)rs.getInt("id"));
            movie.setTitle(rs.getString("title"));
            movie.setDirector(rs.getString("director"));
            movie.setReleaseYear(rs.getInt("releaseYear"));
            movie.setImdbRating(rs.getInt("imdbRating"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return movie;
    }

    @Override
    public Optional<Movie> add(Movie movie) throws SQLException {
        String sql = "insert into movies (id,title, director, imdbRating, releaseYear) values(?,?,?,?,?)";
        movieValidator.validate(movie);
        jdbcOperations.update(sql, movie.getId(), movie.getTitle(), movie.getDirector(), movie.getImdbRating(), movie.getReleaseYear());
        return Optional.of(movie);
    }

    @Override
    public Optional<Movie> update(Movie movie) throws SQLException {
        String sql = "update movies set title=?, director=?, imdbRating=?, releaseYear=? where id=?";
        movieValidator.validate(movie);
        jdbcOperations.update(sql,movie.getTitle(), movie.getDirector(), movie.getImdbRating(), movie.getReleaseYear(), movie.getId());
        return Optional.of(movie);
    }

    @Override
    public Optional<Movie> delete(Long id) throws SQLException {
        String sql = "delete from movies where id=?";
        jdbcOperations.update(sql, id);
        return Optional.empty();
    }
}
