package br.com.cabal.challengemerchantapi.model;

import br.com.cabal.challengemerchantapi.enums.PhoneTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_PHONE", schema = "CORE")
public class PhoneEntity extends BaseEntity{

    private static final long serialVersionUID = -8034151676648419551L;

    @Id
    @SequenceGenerator(name="seq_phone", sequenceName="seq_phone", schema = "core", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_phone")
    @Column(name = "CD_SEQ_PHONE")
    private Integer id;

    @Column(name = "NU_DDD")
    private String nuDdd;

    @Column(name = "NU_PHONE")
    private String nuPhone;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_PHONE")
    private PhoneTypeEnum tpPhone;

    @Column(name = "DT_INSERT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsert;

    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtLastUpdate;

    @JsonIgnore
    @ManyToMany(mappedBy="phones")
    private List<MerchantEntity> merchants;

    @PrePersist
    public void prePersist() {
        setDtInsert(new Date());
        setDtLastUpdate(new Date());
    }

    @PreUpdate
    public void preUpdate() {
        setDtLastUpdate(new Date());
    }

    public List<MerchantEntity> getMerchants() {
        return merchants;
    }

    public void setId(Integer cdSeqPhone) {
        this.id = cdSeqPhone;
    }

    public void setMerchants(List<MerchantEntity> merchants) {
        this.merchants = merchants;
    }

    public int getId() {
        return id;
    }

    public void setCdSeqPhone(int cdSeqPhone) {
        this.id = cdSeqPhone;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneEntity that = (PhoneEntity) o;
        return id == that.id &&
                Objects.equals(nuDdd, that.nuDdd) &&
                Objects.equals(nuPhone, that.nuPhone) &&
                Objects.equals(tpPhone, that.tpPhone) &&
                Objects.equals(dtInsert, that.dtInsert) &&
                Objects.equals(dtLastUpdate, that.dtLastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nuDdd, nuPhone, tpPhone, dtInsert, dtLastUpdate);
    }
}
