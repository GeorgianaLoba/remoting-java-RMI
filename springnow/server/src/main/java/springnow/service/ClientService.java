package springnow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import springnow.domain.Client;
import springnow.repository.ClientDBRepository;
import springnow.repository.InterfaceRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ClientService {
    @Autowired
    private ClientDBRepository repository;


    public void addClient(Client client)
    {
        repository.save(client);
    }

    public void updateClient(Client client)
    {
        repository.update(client);
    }

    public void deleteClient(Long id) throws SQLException {
        repository.delete(id);
    }

    public List<Client> getAllClients() throws SQLException {
        Iterable<Client> clients = repository.findALL();
        return StreamSupport.stream(clients.spliterator(), false).collect(Collectors.toList());
    }

    public boolean isPresent (Long id){
        try{
            repository.findOne(id);
            return true;
        }catch (IllegalArgumentException e)
        {
            return false;
        }
    }

}
