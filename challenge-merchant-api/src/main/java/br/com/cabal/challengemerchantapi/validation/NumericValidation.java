package br.com.cabal.challengemerchantapi.validation;


import br.com.cabal.challengemerchantapi.validation.validator.NumericValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Constraint(validatedBy = NumericValidator.class)
public @interface NumericValidation {

    String message() default "O campo deve conter apenas digitos numéricos";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
