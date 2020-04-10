package springnow.serverService;

import org.springframework.beans.factory.annotation.Autowired;
import rpc.domain.Client;
import rpc.service.CommonClientService;
import springnow.service.ClientService;

import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class ServerClientService implements CommonClientService {
    @Autowired
    private ClientService clientService;

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
