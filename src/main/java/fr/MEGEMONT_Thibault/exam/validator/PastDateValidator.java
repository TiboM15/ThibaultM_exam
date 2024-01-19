package fr.MEGEMONT_Thibault.exam.validator;

import fr.MEGEMONT_Thibault.exam.validator.annotation.PastDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Date;

public class PastDateValidator implements ConstraintValidator<PastDate, Date> {

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        return date.before(new Date());
    }

}
