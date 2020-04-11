package springnow.domain.validators;


import springnow.domain.exceptions.ValidatorException;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}
