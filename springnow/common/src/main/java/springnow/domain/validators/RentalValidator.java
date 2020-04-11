package springnow.domain.validators;


import springnow.domain.Rental;
import springnow.domain.exceptions.ValidatorException;

public class RentalValidator implements Validator<Rental> {
    @Override
    public void validate(Rental entity) throws ValidatorException {
        //TODO: nothing to validate for now
    }
}
