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
@Table(name = "HARBOUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Harbour.findAll", query = "SELECT h FROM Harbour h"),
    @NamedQuery(name = "Harbour.findById", query = "SELECT h FROM Harbour h WHERE h.id = :id"),
    @NamedQuery(name = "Harbour.findByName", query = "SELECT h FROM Harbour h WHERE h.name = :name")})
public class Harbour implements Serializable {
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
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrigin")
    private Collection<Route> routeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDestination")
    private Collection<Route> routeCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "harbourId")
    private Collection<FerryInHarbour> ferryInHarbourCollection;

    public Harbour() {
    }

    public Harbour(BigDecimal id) {
        this.id = id;
    }

    public Harbour(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Route> getRouteCollection() {
        return routeCollection;
    }

    public void setRouteCollection(Collection<Route> routeCollection) {
        this.routeCollection = routeCollection;
    }

    @XmlTransient
    public Collection<Route> getRouteCollection1() {
        return routeCollection1;
    }

    public void setRouteCollection1(Collection<Route> routeCollection1) {
        this.routeCollection1 = routeCollection1;
    }

    @XmlTransient
    public Collection<FerryInHarbour> getFerryInHarbourCollection() {
        return ferryInHarbourCollection;
    }

    public void setFerryInHarbourCollection(Collection<FerryInHarbour> ferryInHarbourCollection) {
        this.ferryInHarbourCollection = ferryInHarbourCollection;
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
        if (!(object instanceof Harbour)) {
            return false;
        }
        Harbour other = (Harbour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.Harbour[ id=" + id + " ]";
    }
    
}
