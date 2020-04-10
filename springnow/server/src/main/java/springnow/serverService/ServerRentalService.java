package springnow.serverService;

import org.springframework.beans.factory.annotation.Autowired;
import rpc.domain.Rental;
import rpc.service.CommonRentalService;
import springnow.service.RentalService;


import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ServerRentalService implements CommonRentalService {
    @Autowired
    private RentalService rentalService;

    @Override
    public void deleteRentalsOfMovie(Long movieId) {
        rentalService.deleteRentalsOfClient(movieId);
    }

    @Override
    public void deleteRentalsofClient(Long clientId) {
        rentalService.deleteRentalsOfClient(clientId);
    }

    @Override
    public void rentMovie(Rental rental) {
        rentalService.rentMovie(rental);
    }

    @Override
    public void deleteRental(Long id) throws SQLException {
        rentalService.deleteRental(id);
    }

    @Override
    public void updateRental(Rental rental) {
        rentalService.updateRental(rental);
    }

    @Override
    public Set<Rental> getAllRentals() throws SQLException {
        return rentalService.getAllRentals();
    }
}
