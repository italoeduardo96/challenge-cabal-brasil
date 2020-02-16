package br.com.cabal.challengemerchantapi.api.dto.merchant;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MerchantResponseDto {

    private Integer id;
    private String nmMerchant;
    private String nuDocument;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dtInsert;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dtLastUpdate;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
