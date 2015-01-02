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
@Table(name = "FERRY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ferry.findAll", query = "SELECT f FROM Ferry f"),
    @NamedQuery(name = "Ferry.findById", query = "SELECT f FROM Ferry f WHERE f.id = :id"),
    @NamedQuery(name = "Ferry.findByFerryName", query = "SELECT f FROM Ferry f WHERE f.ferryName = :ferryName")})
public class Ferry implements Serializable {
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
    @Column(name = "FERRY_NAME")
    private String ferryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ferryId")
    private Collection<FerryConfig> ferryConfigCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ferryId")
    private Collection<FerryInHarbour> ferryInHarbourCollection;

    public Ferry() {
    }

    public Ferry(BigDecimal id) {
        this.id = id;
    }

    public Ferry(BigDecimal id, String ferryName) {
        this.id = id;
        this.ferryName = ferryName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFerryName() {
        return ferryName;
    }

    public void setFerryName(String ferryName) {
        this.ferryName = ferryName;
    }

    @XmlTransient
    public Collection<FerryConfig> getFerryConfigCollection() {
        return ferryConfigCollection;
    }

    public void setFerryConfigCollection(Collection<FerryConfig> ferryConfigCollection) {
        this.ferryConfigCollection = ferryConfigCollection;
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
        if (!(object instanceof Ferry)) {
            return false;
        }
        Ferry other = (Ferry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.Ferry[ id=" + id + " ]";
    }
    
}
