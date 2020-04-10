package springnow.repository.adapters;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import rpc.domain.Client;
import rpc.domain.exceptions.ValidatorException;
import rpc.domain.validators.ClientValidator;

import javax.swing.text.html.Option;
import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ClientAdapter implements Adapter<Long, Client> {
    @Autowired
    private ClientValidator clientValidator;
    @Autowired
    private JdbcOperations jdbcOperations;

    private Client makeClient(ResultSet rs){
        Client newClient = new Client();
        try {
            newClient.setId((long) rs.getInt("id"));
            newClient.setName(rs.getString("name"));
            newClient.setAddress(rs.getString("address"));
            newClient.setAge(rs.getInt("age"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return newClient;
    }

    @Override
    public Set<Client> findAll() throws SQLException {
        String sql = "select * from clients";
        return jdbcOperations.query(sql,(rs,row)->makeClient(rs));
    }

    @Override
    public Optional<Client> findOne(Long id) throws SQLException {
        String sql = "select * from clients where id=";
        //List<Employee> employees = jdbcTemplate.queryForObject(
        //  query, new Object[] { id }, new EmployeeRowMapper());
        Client client = jdbcOperations.queryForObject(sql, new Object[]{id}, (rs, row) ->makeClient(rs));
        return Optional.ofNullable(client);
    }

    @Override
    public Optional<Client> add(Client client) throws SQLException, ValidatorException {
        String sql = "insert into clients (id,name, address, age) values(?,?,?,?)";
        clientValidator.validate(client);
        jdbcOperations.update(sql, client.getId(),client.getName(),client.getAddress(), client.getAge());
        return Optional.of(client);
    }

    @Override
    public Optional<Client> update(Client client) throws SQLException {
        String sql = "update Client set name=?, address=?, age=? where id=?";
        clientValidator.validate(client);
        jdbcOperations.update(sql, client.getName(), client.getAddress(), client.getAge(), client.getId());
        return Optional.of(client);
    }

    @Override
    public Optional<Client> delete(Long id) throws SQLException {
        String sql = "delete from clients where id=?";
        jdbcOperations.update(sql, id);
        return Optional.empty();
    }
}
