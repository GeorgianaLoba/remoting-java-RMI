package springnow.repository;



import springnow.domain.BaseEntity;
import springnow.domain.exceptions.ValidatorException;

import java.util.Optional;

public interface InterfaceRepository<ID,T extends BaseEntity<ID>> {
    Optional<T> findOne(ID id);
    Iterable<T> findALL();
    Optional<T> save(T entity) throws ValidatorException;
    Optional<T> delete(ID id);
    Optional<T> update(T entity) throws ValidatorException;
}
