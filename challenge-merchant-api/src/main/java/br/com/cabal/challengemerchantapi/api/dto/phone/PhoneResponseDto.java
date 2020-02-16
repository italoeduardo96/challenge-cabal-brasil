package br.com.cabal.challengemerchantapi.api.dto.phone;

import br.com.cabal.challengemerchantapi.enums.PhoneTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class PhoneResponseDto {

    private Integer id;
    private String nuDdd;
    private String nuPhone;
    private PhoneTypeEnum tpPhone;
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
