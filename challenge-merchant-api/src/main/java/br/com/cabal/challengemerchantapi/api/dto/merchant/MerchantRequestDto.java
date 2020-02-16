package br.com.cabal.challengemerchantapi.api.dto.merchant;

import br.com.cabal.challengemerchantapi.api.dto.address.AddressRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneRequestDto;
import br.com.cabal.challengemerchantapi.validation.CnpjValidation;
import br.com.cabal.challengemerchantapi.validation.CreateMerchantValidationInterface;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantRequestDto {

    @NotBlank(groups = CreateMerchantValidationInterface.class)
    @ApiModelProperty(position = 1)
    @Size(min = 20, max = 100 )
    private String nmMerchant;

    @CnpjValidation(groups = CreateMerchantValidationInterface.class)
    @NotBlank(groups = CreateMerchantValidationInterface.class)
    @ApiModelProperty(position = 2)
    @Size(max = 14 )
    private String nuDocument;

    @Valid
    @NotEmpty(groups = CreateMerchantValidationInterface.class)
    @ApiModelProperty(position = 3)
    private List<PhoneRequestDto> phones;

    @Valid
    @NotEmpty(groups = CreateMerchantValidationInterface.class)
    @ApiModelProperty(position = 4)
    private List<EmailRequestDto> emails;

    @Valid
    @NotNull(groups = CreateMerchantValidationInterface.class)
    @ApiModelProperty(position = 5)
    private AddressRequestDto address;

    public List<EmailRequestDto> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailRequestDto> emails) {
        this.emails = emails;
    }

    public AddressRequestDto getAddress() {
        return address;
    }

    public void setAddress(AddressRequestDto address) {
        this.address = address;
    }

    public String getNmMerchant() {
        return nmMerchant;
    }

    public void setNmMerchant(String nmMerchant) {
        this.nmMerchant = nmMerchant;
    }

    public String getNuDocument() {
        return nuDocument;
    }

    public void setNuDocument(String nuDocument) {
        this.nuDocument = nuDocument;
    }

    public List<PhoneRequestDto> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneRequestDto> phones) {
        this.phones = phones;
    }
}
