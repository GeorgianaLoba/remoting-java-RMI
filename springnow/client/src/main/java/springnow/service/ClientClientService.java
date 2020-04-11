package springnow.service;

import org.springframework.beans.factory.annotation.Autowired;
import springnow.domain.Client;

import java.sql.SQLException;
import java.util.Set;

public class ClientClientService implements CommonClientService {
    @Autowired
    CommonClientService clientService;

    @Override
    public void addClient(Client client) {
         clientService.addClient(client);
    }

    @Override
    public void deleteClient(Long id) throws SQLException {
        clientService.deleteClient(id);
    }

    @Override
    public void updateClient(Client client) {
        clientService.updateClient(client);
    }

    @Override
    public boolean isPresent(Long id) {
        return clientService.isPresent(id);
    }

    @Override
    public Set<Client> getAllClients() throws SQLException {
        return clientService.getAllClients();
    }
}
