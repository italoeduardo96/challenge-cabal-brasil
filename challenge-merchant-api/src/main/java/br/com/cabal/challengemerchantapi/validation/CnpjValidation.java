package br.com.cabal.challengemerchantapi.validation;


import br.com.cabal.challengemerchantapi.validation.validator.CnpjValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Constraint(validatedBy = CnpjValidator.class)
public @interface CnpjValidation {

    String message() default "CNPJ inválido";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
