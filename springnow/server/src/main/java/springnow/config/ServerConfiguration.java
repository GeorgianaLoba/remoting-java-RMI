package springnow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;
import springnow.domain.Client;
import springnow.domain.Movie;
import springnow.domain.Rental;
import springnow.domain.validators.ClientValidator;
import springnow.domain.validators.MovieValidator;
import springnow.domain.validators.RentalValidator;
import springnow.service.CommonClientService;
import springnow.service.CommonMovieService;
import springnow.service.CommonRentalService;
import springnow.repository.DBRepository;
import springnow.repository.InterfaceRepository;
import springnow.repository.adapters.ClientAdapter;
import springnow.repository.adapters.MovieAdapter;
import springnow.repository.adapters.RentalAdapter;
import springnow.serverService.ServerClientService;
import springnow.serverService.ServerMovieService;
import springnow.serverService.ServerRentalService;
import springnow.service.ClientService;
import springnow.service.MovieService;
import springnow.service.RentalService;

@Configuration
public class ServerConfiguration {

    @Bean
    RmiServiceExporter rmiServiceExporterMovie(){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("MovieService");
        rmiServiceExporter.setServiceInterface(CommonMovieService.class);
        rmiServiceExporter.setService(serverMovieService());
        return rmiServiceExporter;
    }

    @Bean
    RmiServiceExporter rmiServiceExporterClient(){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("ClientService");
        rmiServiceExporter.setServiceInterface(CommonClientService.class);
        rmiServiceExporter.setService(serverClientService());
        return rmiServiceExporter;
    }

    @Bean
    RmiServiceExporter rmiServiceExporterRental(){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("RentalService");
        rmiServiceExporter.setServiceInterface(CommonRentalService.class);
        rmiServiceExporter.setService(serverRentalService());
        return rmiServiceExporter;
    }

    @Bean
    ServerMovieService serverMovieService() {
        return new ServerMovieService();
    }

    @Bean
    ServerClientService serverClientService() {
        return new ServerClientService();
    }

    @Bean
    ServerRentalService serverRentalService() {
        return new ServerRentalService();
    }


    @Bean
    MovieValidator movieValidator(){
        return new MovieValidator();
    }

    @Bean
    ClientValidator clientValidator(){
        return new ClientValidator();
    }

    @Bean
    RentalValidator rentalValidator(){
        return new RentalValidator();
    }


    @Bean
    MovieAdapter movieAdapter(){
        return new MovieAdapter();
    }

    @Bean
    ClientAdapter clientAdapter(){
        return new ClientAdapter();
    }

    @Bean
    RentalAdapter rentalAdapter(){
        return new RentalAdapter();
    }

    @Bean
    InterfaceRepository<Long, Movie> movieRepository(){
        return new DBRepository<Long, Movie>();
    }

    @Bean
    InterfaceRepository<Long, Client> clientRepository(){
        return new DBRepository<Long, Client>();
    }

    @Bean
    InterfaceRepository<Long, Rental> rentalRepository(){
        return new DBRepository<Long, Rental>();
    }

    @Bean
    MovieService movieService(){
        return new MovieService();
    }

    @Bean
    ClientService clientService(){
        return new ClientService();
    }

    @Bean
    RentalService rentalService(){
        return new RentalService();
    }

}
