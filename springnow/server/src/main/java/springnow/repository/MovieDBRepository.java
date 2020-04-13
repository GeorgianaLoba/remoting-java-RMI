package springnow.repository;


import org.springframework.beans.factory.annotation.Autowired;
import springnow.domain.BaseEntity;
import springnow.domain.Movie;
import springnow.domain.exceptions.ValidatorException;
import springnow.repository.adapters.Adapter;
import springnow.repository.adapters.MovieAdapter;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;

public class MovieDBRepository implements InterfaceRepository<Long, Movie> {
    @Autowired
    private MovieAdapter adapter;

    @Override
    public Optional<Movie> findOne(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The ID must not be null");
        }
        try {
            return adapter.findOne(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Iterable<Movie> findALL() {
        try {
            return new HashSet<>(adapter.findAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    @Override
    public Optional<Movie> save(Movie entity) throws ValidatorException {
        if (entity == null) {
            throw new IllegalArgumentException("The entity must not be null");
        }
        try {
            return adapter.add(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Movie> delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The ID must not be null");
        }
        try {
            return adapter.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public Optional<Movie> update(Movie entity) throws ValidatorException {
        if (entity == null) {
            throw new IllegalArgumentException("The entity must not be null");
        }
        try {
            return adapter.update(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}
