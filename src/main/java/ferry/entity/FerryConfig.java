/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferry.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "FERRY_CONFIG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FerryConfig.findAll", query = "SELECT f FROM FerryConfig f"),
    @NamedQuery(name = "FerryConfig.findById", query = "SELECT f FROM FerryConfig f WHERE f.id = :id"),
    @NamedQuery(name = "FerryConfig.findByPeopleCapacity", query = "SELECT f FROM FerryConfig f WHERE f.peopleCapacity = :peopleCapacity"),
    @NamedQuery(name = "FerryConfig.findByVehicleCapacity", query = "SELECT f FROM FerryConfig f WHERE f.vehicleCapacity = :vehicleCapacity"),
    @NamedQuery(name = "FerryConfig.findByWeightCapacity", query = "SELECT f FROM FerryConfig f WHERE f.weightCapacity = :weightCapacity")})
public class FerryConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEOPLE_CAPACITY")
    private BigInteger peopleCapacity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VEHICLE_CAPACITY")
    private BigInteger vehicleCapacity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEIGHT_CAPACITY")
    private BigInteger weightCapacity;
    @JoinColumn(name = "FERRY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ferry ferryId;

    public FerryConfig() {
    }

    public FerryConfig(BigDecimal id) {
        this.id = id;
    }

    public FerryConfig(BigDecimal id, BigInteger peopleCapacity, BigInteger vehicleCapacity, BigInteger weightCapacity) {
        this.id = id;
        this.peopleCapacity = peopleCapacity;
        this.vehicleCapacity = vehicleCapacity;
        this.weightCapacity = weightCapacity;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(BigInteger peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    public BigInteger getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(BigInteger vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public BigInteger getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(BigInteger weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public Ferry getFerryId() {
        return ferryId;
    }

    public void setFerryId(Ferry ferryId) {
        this.ferryId = ferryId;
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
        if (!(object instanceof FerryConfig)) {
            return false;
        }
        FerryConfig other = (FerryConfig) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.FerryConfig[ id=" + id + " ]";
    }
    
}
