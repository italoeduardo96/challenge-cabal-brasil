package br.com.cabal.challengemerchantapi.api.dto.address;

import br.com.cabal.challengemerchantapi.validation.CreateMerchantValidationInterface;
import br.com.cabal.challengemerchantapi.validation.NumericValidation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressRequestDto {

    @Size(max = 10)
    private String nuAddress;

    @Size(max = 100)
    private String dsComplement;

    @Size(max = 2, min = 2)
    @NotBlank(groups = CreateMerchantValidationInterface.class)
    private String cdUf;

    @Size(max = 100)
    @NotBlank(groups = CreateMerchantValidationInterface.class)
    @NumericValidation
    private String cdCity;

    @Size(max = 100)
    @NotBlank(groups = CreateMerchantValidationInterface.class)
    private String dsAddress;

    @Size(max = 100)
    @NotBlank(groups = CreateMerchantValidationInterface.class)
    @NumericValidation
    private String cdNeighborhood;

    @Size(max = 100)
    @NotBlank(groups = CreateMerchantValidationInterface.class)
    @NumericValidation
    private String cdZipcode;

    public String getNuAddress() {
        return nuAddress;
    }

    public void setNuAddress(String nuAddress) {
        this.nuAddress = nuAddress;
    }

    public String getDsComplement() {
        return dsComplement;
    }

    public void setDsComplement(String dsComplement) {
        this.dsComplement = dsComplement;
    }

    public String getCdUf() {
        return cdUf;
    }

    public void setCdUf(String cdUf) {
        this.cdUf = cdUf;
    }

    public String getCdCity() {
        return cdCity;
    }

    public void setCdCity(String cdCity) {
        this.cdCity = cdCity;
    }

    public String getDsAddress() {
        return dsAddress;
    }

    public void setDsAddress(String dsAddress) {
        this.dsAddress = dsAddress;
    }

    public String getCdNeighborhood() {
        return cdNeighborhood;
    }

    public void setCdNeighborhood(String cdNeighborhood) {
        this.cdNeighborhood = cdNeighborhood;
    }

    public String getCdZipcode() {
        return cdZipcode;
    }

    public void setCdZipcode(String cdZipcode) {
        this.cdZipcode = cdZipcode;
    }
}
