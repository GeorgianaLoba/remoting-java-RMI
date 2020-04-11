package springnow.repository;


import org.springframework.beans.factory.annotation.Autowired;
import springnow.domain.BaseEntity;
import springnow.domain.exceptions.ValidatorException;
import springnow.repository.adapters.Adapter;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;

public class DBRepository<ID extends Serializable, T extends BaseEntity<ID>> implements InterfaceRepository<ID, T> {
    @Autowired
    private Adapter<ID, T> adapter;

    @Override
    public Optional<T> findOne(ID id) {
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
    public Iterable<T> findALL() {
        try {
            return new HashSet<>(adapter.findAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    @Override
    public Optional<T> save(T entity) throws ValidatorException {
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
    public Optional<T> delete(ID id) {
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
    public Optional<T> update(T entity) throws ValidatorException {
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
