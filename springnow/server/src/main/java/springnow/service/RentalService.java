package springnow.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import springnow.domain.Client;
import springnow.domain.Movie;
import springnow.domain.Rental;
import springnow.repository.ClientDBRepository;
import springnow.repository.InterfaceRepository;
import springnow.repository.MovieDBRepository;
import springnow.repository.RentalDBRepository;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RentalService {
    @Autowired
    private RentalDBRepository repository;
    @Autowired
    private MovieDBRepository movieRepository;
    @Autowired
    private ClientDBRepository clientRepository;


    public List<Rental> getAllRentals() throws SQLException {
        Iterable<Rental> rentals = repository.findALL();
        return StreamSupport.stream(rentals.spliterator(), false).collect(Collectors.toList());
    }

    public void rentMovie(Rental rental)
    {
        if (!movieRepository.findOne(rental.getMovieId()).isPresent() || !clientRepository.findOne(rental.getClientId()).isPresent())
               return;
        repository.save(rental);

    }



    public Movie mostRented () throws SQLException {
        List<Rental> rentals = getAllRentals();
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
        List<Rental> rentals = getAllRentals();
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
        List<Rental> rentals = getAllRentals();
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
