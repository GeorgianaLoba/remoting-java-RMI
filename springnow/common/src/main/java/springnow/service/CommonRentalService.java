package springnow.service;

import springnow.domain.Rental;

import java.sql.SQLException;
import java.util.List;

public interface CommonRentalService {

    void deleteRentalsOfMovie(Long movieId) throws SQLException;
    void deleteRentalsofClient(Long clientId) throws SQLException;
    void rentMovie(Rental rental);
    void deleteRental(Long id) throws SQLException;
    void updateRental(Rental rental);
    List<Rental> getAllRentals() throws SQLException;
}
