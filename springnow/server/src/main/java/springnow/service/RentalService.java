package springnow.service;


import org.springframework.beans.factory.annotation.Autowired;
import rpc.domain.Client;
import rpc.domain.Movie;
import rpc.domain.Rental;
import springnow.repository.InterfaceRepository;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RentalService {
    @Autowired
    private InterfaceRepository<Long, Rental> repository;
    @Autowired
    private InterfaceRepository<Long, Movie> movieRepository;
    @Autowired
    private InterfaceRepository<Long, Client> clientRepository;


    public Set<Rental> getAllRentals() throws SQLException {
        Iterable<Rental> rentals = repository.findALL();
        return StreamSupport.stream(rentals.spliterator(), false).collect(Collectors.toSet());
    }

//    public void rentMovie(Long id, Long movieId, Long clientId) throws SQLException {
//        if (!movieRepository.findOne(movieId).isPresent() || !clientRepository.findOne(clientId).isPresent())
//            return;
//        Rental rental = new Rental(movieId, clientId);
//        rental.setId(id);
//        repository.save(rental);
//    }
    public void rentMovie(Rental rental)
    {
        if (!movieRepository.findOne(rental.getMovieId()).isPresent() || !clientRepository.findOne(rental.getClientId()).isPresent())
               return;
        repository.save(rental);

    }



    public Movie mostRented () throws SQLException {
        Set<Rental> rentals = getAllRentals();
        Map<Long, Long> mapping = rentals.stream().collect(Collectors.groupingBy(Rental::getMovieId, Collectors.counting()));
        Long most = mapping.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(null);
        return movieRepository.findOne(most).get();
    }

    public void deleteRental(Long id) throws SQLException {
        repository.delete(id);
    }

    public void updateRental(Rental rental)
    {
        repository.update(rental);
    }


    public void deleteRentalsOfMovie(Long movieId) throws SQLException {
        Set<Rental> rentals = getAllRentals();
        rentals.forEach(r->{ if (r.getMovieId().equals(movieId)) {
            try {
                deleteRental(r.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        });
    }

    public void deleteRentalsOfClient(Long clientId) throws SQLException {
        Set<Rental> rentals = getAllRentals();
        rentals.forEach(r->{ if (r.getClientId().equals(clientId)) {
            try {
                deleteRental(r.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        });
    }
}
