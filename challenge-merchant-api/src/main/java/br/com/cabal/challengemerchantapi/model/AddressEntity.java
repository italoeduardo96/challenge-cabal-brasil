package br.com.cabal.challengemerchantapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_ADDRESS", schema = "CORE")
public class AddressEntity extends BaseEntity {

    private static final long serialVersionUID = 5743306758549772806L;

    @Id
    @SequenceGenerator(name="seq_address", sequenceName="seq_address", schema = "core", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_address")
    @Column(name = "CD_SEQ_ADDRESS")
    private Integer id;

    @Column(name = "NU_ADDRESS")
    private String nuAddress;

    @Column(name = "DS_COMPLEMENT")
    private String dsComplement;

    @Column(name = "CD_UF")
    private String cdUf;

    @Column(name = "CD_CITY")
    private String cdCity;

    @Column(name = "DS_ADDRESS")
    private String dsAddress;

    @Column(name = "CD_NEIGHBORHOOD")
    private String cdNeighborhood;

    @Column(name = "CD_ZIPCODE")
    private String cdZipcode;

    @Column(name = "DT_INSERT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsert;

    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtLastUpdate;

    @JsonIgnore
    @OneToMany(mappedBy="address")
    private List<MerchantEntity> merchants;

    public void setId(Integer cdSeqAddress) {
        this.id = cdSeqAddress;
    }

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

    public void setMerchants(List<MerchantEntity> merchants) {
        this.merchants = merchants;
    }

    public int getId() {
        return id;
    }

    public void setCdSeqAddress(int cdSeqAddress) {
        this.id = cdSeqAddress;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return id == that.id &&
                Objects.equals(nuAddress, that.nuAddress) &&
                Objects.equals(dsComplement, that.dsComplement) &&
                Objects.equals(cdUf, that.cdUf) &&
                Objects.equals(cdCity, that.cdCity) &&
                Objects.equals(dsAddress, that.dsAddress) &&
                Objects.equals(cdNeighborhood, that.cdNeighborhood) &&
                Objects.equals(cdZipcode, that.cdZipcode) &&
                Objects.equals(dtInsert, that.dtInsert) &&
                Objects.equals(dtLastUpdate, that.dtLastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nuAddress, dsComplement, cdUf, cdCity, dsAddress, cdNeighborhood, cdZipcode, dtInsert, dtLastUpdate);
    }
}
