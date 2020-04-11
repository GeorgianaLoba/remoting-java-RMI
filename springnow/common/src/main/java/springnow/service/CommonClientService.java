package springnow.service;

import springnow.domain.Client;

import java.sql.SQLException;
import java.util.List;

public interface CommonClientService {


    void addClient(Client client);
    void deleteClient(Long id) throws SQLException;
    void updateClient(Client client);
    boolean isPresent(Long id);
    List<Client> getAllClients() throws SQLException;



}
