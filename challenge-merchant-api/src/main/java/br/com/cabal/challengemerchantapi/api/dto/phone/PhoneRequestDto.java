package br.com.cabal.challengemerchantapi.api.dto.phone;

import br.com.cabal.challengemerchantapi.enums.PhoneTypeEnum;
import br.com.cabal.challengemerchantapi.validation.CreateMerchantValidationInterface;
import br.com.cabal.challengemerchantapi.validation.NumericValidation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneRequestDto {

    @NotBlank(groups = CreateMerchantValidationInterface.class)
    @Size(min = 2, max = 3)
    @NumericValidation
    private String nuDdd;

    @NotBlank(groups = CreateMerchantValidationInterface.class)
    @Size(min = 8, max = 9)
    @NumericValidation
    private String nuPhone;

    @NotNull(groups = CreateMerchantValidationInterface.class)
    private PhoneTypeEnum tpPhone;

    public String getNuDdd() {
        return nuDdd;
    }

    public void setNuDdd(String nuDdd) {
        this.nuDdd = nuDdd;
    }

    public String getNuPhone() {
        return nuPhone;
    }

    public void setNuPhone(String nuPhone) {
        this.nuPhone = nuPhone;
    }

    public PhoneTypeEnum getTpPhone() {
        return tpPhone;
    }

    public void setTpPhone(PhoneTypeEnum tpPhone) {
        this.tpPhone = tpPhone;
    }


}
