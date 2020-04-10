package springnow.repository.adapters;



import rpc.domain.BaseEntity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

public interface Adapter<ID extends Serializable,T extends BaseEntity<ID>> {

    Set<T> findAll() throws SQLException;
    Optional<T> findOne(ID id) throws SQLException;
    Optional<T> add(T entity) throws SQLException;
    Optional<T> update(T entity) throws SQLException;
    Optional<T> delete(ID id) throws SQLException;

}
