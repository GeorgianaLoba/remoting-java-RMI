package springnow.repository;


import org.springframework.beans.factory.annotation.Autowired;

import springnow.domain.Rental;
import springnow.domain.exceptions.ValidatorException;
import springnow.repository.adapters.RentalAdapter;


import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;

public class RentalDBRepository implements InterfaceRepository<Long, Rental> {
    @Autowired
    private RentalAdapter adapter;

    @Override
    public Optional<Rental> findOne(Long id) {
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
    public Iterable<Rental> findALL() {
        try {
            return new HashSet<>(adapter.findAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    @Override
    public Optional<Rental> save(Rental entity) throws ValidatorException {
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
    public Optional<Rental> delete(Long id) {
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
    public Optional<Rental> update(Rental entity) throws ValidatorException {
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
