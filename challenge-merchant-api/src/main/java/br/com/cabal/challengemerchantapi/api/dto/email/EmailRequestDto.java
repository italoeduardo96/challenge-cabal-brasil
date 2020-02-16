package br.com.cabal.challengemerchantapi.api.dto.email;

import br.com.cabal.challengemerchantapi.validation.CreateMerchantValidationInterface;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailRequestDto {

    @Email
    @NotBlank(groups = CreateMerchantValidationInterface.class)
    private String dsEmail;

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }
}
