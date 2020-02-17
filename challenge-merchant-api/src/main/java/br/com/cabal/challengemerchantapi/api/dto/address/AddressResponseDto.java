package br.com.cabal.challengemerchantapi.api.dto.address;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AddressResponseDto {

    private Integer id;
    private String nuAddress;
    private String dsComplement;
    private String cdUf;
    private String cdCity;
    private String dsAddress;
    private String cdNeighborhood;
    private String cdZipcode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dtInsert;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dtLastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getDtInsert() {
        return dtInsert;
    }

    public void setDtInsert(Date dtInsert) {
        this.dtInsert = dtInsert;
    }

    public Date getDtLastUpdate() {
        return dtLastUpdate;
    }

    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
}
