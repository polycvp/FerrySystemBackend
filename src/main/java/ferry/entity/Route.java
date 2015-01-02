/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferry.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "ROUTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findById", query = "SELECT r FROM Route r WHERE r.id = :id"),
    @NamedQuery(name = "Route.findByDuration", query = "SELECT r FROM Route r WHERE r.duration = :duration")})
public class Route implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURATION")
    private BigInteger duration;
    @JoinColumn(name = "ID_ORIGIN", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Harbour idOrigin;
    @JoinColumn(name = "ID_DESTINATION", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Harbour idDestination;
    @JoinColumn(name = "ID_PRICE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Price idPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<Departure> departureCollection;

    public Route() {
    }

    public Route(BigDecimal id) {
        this.id = id;
    }

    public Route(BigDecimal id, BigInteger duration) {
        this.id = id;
        this.duration = duration;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
        this.duration = duration;
    }

    public Harbour getIdOrigin() {
        return idOrigin;
    }

    public void setIdOrigin(Harbour idOrigin) {
        this.idOrigin = idOrigin;
    }

    public Harbour getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Harbour idDestination) {
        this.idDestination = idDestination;
    }

    public Price getIdPrice() {
        return idPrice;
    }

    public void setIdPrice(Price idPrice) {
        this.idPrice = idPrice;
    }

    @XmlTransient
    public Collection<Departure> getDepartureCollection() {
        return departureCollection;
    }

    public void setDepartureCollection(Collection<Departure> departureCollection) {
        this.departureCollection = departureCollection;
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
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.Route[ id=" + id + " ]";
    }
    
}
