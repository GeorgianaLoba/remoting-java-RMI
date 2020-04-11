package rpc.service;

//import ro.ubb.rpc.domain.Rental;

import rpc.domain.Rental;

import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface CommonRentalService {




    void deleteRentalsOfMovie(Long movieId);
    void deleteRentalsofClient(Long clientId);
    void rentMovie(Rental rental);
    void deleteRental(Long id) throws SQLException;
    void updateRental(Rental rental);
    Set<Rental> getAllRentals() throws SQLException;


}
