package springnow.repository.adapters;



import springnow.domain.BaseEntity;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Adapter<ID extends Serializable,T extends BaseEntity<ID>> {

    List<T> findAll() throws SQLException;
    Optional<T> findOne(ID id) throws SQLException;
    Optional<T> add(T entity) throws SQLException;
    Optional<T> update(T entity) throws SQLException;
    Optional<T> delete(ID id) throws SQLException;

}
