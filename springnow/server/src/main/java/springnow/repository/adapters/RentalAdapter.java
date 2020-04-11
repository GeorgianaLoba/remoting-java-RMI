package springnow.repository.adapters;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import springnow.domain.Rental;
import springnow.domain.validators.RentalValidator;

import java.sql.*;
import java.util.List;
import java.util.Optional;


public class RentalAdapter implements Adapter<Long, Rental> {
    @Autowired
    RentalValidator rentalValidator;
    @Autowired
    JdbcOperations jdbcOperations;

    @Override
    public List<Rental> findAll() throws SQLException {
        String sql="select * from rentals";
        return jdbcOperations.query(sql, (rs,row)->makeRental(rs));
    }

    private Rental makeRental(ResultSet rs) {
        Rental rental = new Rental();
        try {
            rental.setId((long)rs.getInt("id"));
            rental.setMovieId((long)rs.getInt("movieId"));
            rental.setClientId((long)rs.getInt("rentalId"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rental;
    }

    @Override
    public Optional<Rental> findOne(Long id) throws SQLException {
        String sql = "select * from rentals where id=";
        return Optional.ofNullable(jdbcOperations.queryForObject(sql, new Object[]{id}, (rs,row)->makeRental(rs)));

    }

    @Override
    public Optional<Rental> add(Rental rental) throws SQLException {
        String sql = "insert into rentals (id,movieId, clientID) values(?,?,?)";
        rentalValidator.validate(rental);
        jdbcOperations.update(sql, rental.getId(), rental.getMovieId(), rental.getClientId());
        return Optional.of(rental);
    }

    @Override
    public Optional<Rental> update(Rental rental) throws SQLException {
        String sql = "update rentals set movieId=?, clientID=? where id=?";
        rentalValidator.validate(rental);
        jdbcOperations.update(sql,rental.getMovieId(), rental.getClientId(), rental.getId());
        return Optional.of(rental);
    }

    @Override
    public Optional<Rental> delete(Long id) throws SQLException {
        String sql = "delete from rentals where id=?";
        jdbcOperations.update(sql, id);
        return Optional.empty();
    }
}
