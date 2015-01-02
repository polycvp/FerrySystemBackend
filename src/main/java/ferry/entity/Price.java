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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "PRICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Price.findAll", query = "SELECT p FROM Price p"),
    @NamedQuery(name = "Price.findById", query = "SELECT p FROM Price p WHERE p.id = :id"),
    @NamedQuery(name = "Price.findByAmount", query = "SELECT p FROM Price p WHERE p.amount = :amount")})
public class Price implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private Serializable amount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrice")
    private Collection<Route> routeCollection;
    @JoinColumn(name = "TRAVELING_ENTITY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TravelingEntityType travelingEntityId;

    public Price() {
    }

    public Price(BigDecimal id) {
        this.id = id;
    }

    public Price(BigDecimal id, Serializable amount) {
        this.id = id;
        this.amount = amount;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Serializable getAmount() {
        return amount;
    }

    public void setAmount(Serializable amount) {
        this.amount = amount;
    }

    @XmlTransient
    public Collection<Route> getRouteCollection() {
        return routeCollection;
    }

    public void setRouteCollection(Collection<Route> routeCollection) {
        this.routeCollection = routeCollection;
    }

    public TravelingEntityType getTravelingEntityId() {
        return travelingEntityId;
    }

    public void setTravelingEntityId(TravelingEntityType travelingEntityId) {
        this.travelingEntityId = travelingEntityId;
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
        if (!(object instanceof Price)) {
            return false;
        }
        Price other = (Price) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.Price[ id=" + id + " ]";
    }
    
}
