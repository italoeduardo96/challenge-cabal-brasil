package br.com.cabal.challengemerchantapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_EMAIL", schema = "CORE")
public class EmailEntity extends BaseEntity{

    private static final long serialVersionUID = 9120946455728553395L;

    @Id
    @SequenceGenerator(name="seq_email", sequenceName="seq_email", schema = "core", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_email")
    @Column(name = "CD_SEQ_EMAIL")
    private Integer id;

    @Column(name = "DS_EMAIL")
    private String dsEmail;

    @Column(name = "DT_INSERT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsert;

    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtLastUpdate;

    @PrePersist
    public void prePersist() {
        setDtInsert(new Date());
        setDtLastUpdate(new Date());
    }

    @PreUpdate
    public void preUpdate() {
        setDtLastUpdate(new Date());
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCdSeqEmail(int cdSeqEmail) {
        this.id = cdSeqEmail;
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

    public void setDtLastUpdate(Date dtLastUse) {
        this.dtLastUpdate = dtLastUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailEntity that = (EmailEntity) o;
        return id == that.id &&
                Objects.equals(dsEmail, that.dsEmail) &&
                Objects.equals(dtInsert, that.dtInsert) &&
                Objects.equals(dtLastUpdate, that.dtLastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dsEmail, dtInsert, dtLastUpdate);
    }
}
