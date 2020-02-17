package br.com.cabal.challengemerchantapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_MERCHANT", schema = "CORE")
public class MerchantEntity extends BaseEntity{

    private static final long serialVersionUID = 8209226749238826045L;

    @Id
    @Column(name = "CD_SEQ_MERCHANT")
    @SequenceGenerator(name="seq_merchant", sequenceName="seq_merchant", schema = "core", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_merchant")
    private Integer id;

    @Column(name = "NM_MERCHANT")
    private String nmMerchant;

    @Column(name = "NU_DOCUMENT")
    private String nuDocument;

    @Column(name = "DT_INSERT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsert;

    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtLastUpdate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cd_seq_address")
    private AddressEntity address;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PhoneEntity> phones;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmailEntity> emails;

    @PrePersist
    public void prePersist() {
        setDtInsert(new Date());
        setDtLastUpdate(new Date());
    }

    @PreUpdate
    public void preUpdate() {
        setDtLastUpdate(new Date());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<PhoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneEntity> phones) {
        this.phones = phones;
    }

    public List<EmailEntity> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailEntity> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchantEntity that = (MerchantEntity) o;
        return id == that.id &&
                Objects.equals(nmMerchant, that.nmMerchant) &&
                Objects.equals(nuDocument, that.nuDocument) &&
                Objects.equals(dtInsert, that.dtInsert) &&
                Objects.equals(dtLastUpdate, that.dtLastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nmMerchant, nuDocument, dtInsert, dtLastUpdate);
    }
}
