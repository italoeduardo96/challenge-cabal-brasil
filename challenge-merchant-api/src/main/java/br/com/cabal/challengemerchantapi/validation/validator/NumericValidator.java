package br.com.cabal.challengemerchantapi.validation.validator;

import br.com.cabal.challengemerchantapi.util.CnpjUtils;
import br.com.cabal.challengemerchantapi.validation.CnpjValidation;
import br.com.cabal.challengemerchantapi.validation.NumericValidation;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumericValidator implements ConstraintValidator<NumericValidation, String> {

    @Override
    public void initialize(NumericValidation annotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        if(StringUtils.isEmpty(value)) {
            return true;
        }

        return value.trim().matches("[0-9]+");
    }

}
