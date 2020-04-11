package rpc.service;

//import ro.ubb.rpc.domain.Client;
import rpc.domain.Client;

import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface CommonClientService {


    void addClient(Client client);
    void deleteClient(Long id) throws SQLException;
    void updateClient(Client client);
    boolean isPresent(Long id);
    Set<Client> getAllClients() throws SQLException;



}
