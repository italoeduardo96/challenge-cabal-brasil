package br.com.cabal.challengemerchantapi.api.dto.email;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EmailResponseDto {

    private Integer id;
    private String dsEmail;
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

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
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
