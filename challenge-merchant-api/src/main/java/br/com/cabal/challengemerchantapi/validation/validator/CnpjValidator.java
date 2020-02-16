package br.com.cabal.challengemerchantapi.validation.validator;

import br.com.cabal.challengemerchantapi.util.CnpjUtils;
import br.com.cabal.challengemerchantapi.validation.CnpjValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CnpjValidator implements ConstraintValidator<CnpjValidation, String> {

    @Override
    public void initialize(CnpjValidation annotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        return CnpjUtils.isValid(value);
    }

}
