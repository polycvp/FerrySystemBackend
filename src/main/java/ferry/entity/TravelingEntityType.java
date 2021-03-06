/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferry.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "TRAVELING_ENTITY_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TravelingEntityType.findAll", query = "SELECT t FROM TravelingEntityType t"),
    @NamedQuery(name = "TravelingEntityType.findById", query = "SELECT t FROM TravelingEntityType t WHERE t.id = :id"),
    @NamedQuery(name = "TravelingEntityType.findByType", query = "SELECT t FROM TravelingEntityType t WHERE t.type = :type")})
public class TravelingEntityType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TYPE")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "travelingEntityId")
    private Collection<Price> priceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    private Collection<TravelingEntity> travelingEntityCollection;

    public TravelingEntityType() {
    }

    public TravelingEntityType(BigDecimal id) {
        this.id = id;
    }

    public TravelingEntityType(BigDecimal id, String type) {
        this.id = id;
        this.type = type;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Price> getPriceCollection() {
        return priceCollection;
    }

    public void setPriceCollection(Collection<Price> priceCollection) {
        this.priceCollection = priceCollection;
    }

    @XmlTransient
    public Collection<TravelingEntity> getTravelingEntityCollection() {
        return travelingEntityCollection;
    }

    public void setTravelingEntityCollection(Collection<TravelingEntity> travelingEntityCollection) {
        this.travelingEntityCollection = travelingEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TravelingEntityType)) {
            return false;
        }
        TravelingEntityType other = (TravelingEntityType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.TravelingEntityType[ id=" + id + " ]";
    }
    
}
