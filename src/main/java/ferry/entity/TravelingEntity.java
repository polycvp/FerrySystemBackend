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
@Table(name = "TRAVELING_ENTITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TravelingEntity.findAll", query = "SELECT t FROM TravelingEntity t"),
    @NamedQuery(name = "TravelingEntity.findById", query = "SELECT t FROM TravelingEntity t WHERE t.id = :id"),
    @NamedQuery(name = "TravelingEntity.findByIsresident", query = "SELECT t FROM TravelingEntity t WHERE t.isresident = :isresident"),
    @NamedQuery(name = "TravelingEntity.findByPassangerreference", query = "SELECT t FROM TravelingEntity t WHERE t.passangerreference = :passangerreference"),
    @NamedQuery(name = "TravelingEntity.findByVehiclereference", query = "SELECT t FROM TravelingEntity t WHERE t.vehiclereference = :vehiclereference")})
public class TravelingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISRESIDENT")
    private Character isresident;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PASSANGERREFERENCE")
    private BigInteger passangerreference;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VEHICLEREFERENCE")
    private BigInteger vehiclereference;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "travelingEntityId")
    private Collection<ReservationTravelingEntity> reservationTravelingEntityCollection;
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TravelingEntityType typeId;

    public TravelingEntity() {
    }

    public TravelingEntity(BigDecimal id) {
        this.id = id;
    }

    public TravelingEntity(BigDecimal id, Character isresident, BigInteger passangerreference, BigInteger vehiclereference) {
        this.id = id;
        this.isresident = isresident;
        this.passangerreference = passangerreference;
        this.vehiclereference = vehiclereference;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Character getIsresident() {
        return isresident;
    }

    public void setIsresident(Character isresident) {
        this.isresident = isresident;
    }

    public BigInteger getPassangerreference() {
        return passangerreference;
    }

    public void setPassangerreference(BigInteger passangerreference) {
        this.passangerreference = passangerreference;
    }

    public BigInteger getVehiclereference() {
        return vehiclereference;
    }

    public void setVehiclereference(BigInteger vehiclereference) {
        this.vehiclereference = vehiclereference;
    }

    @XmlTransient
    public Collection<ReservationTravelingEntity> getReservationTravelingEntityCollection() {
        return reservationTravelingEntityCollection;
    }

    public void setReservationTravelingEntityCollection(Collection<ReservationTravelingEntity> reservationTravelingEntityCollection) {
        this.reservationTravelingEntityCollection = reservationTravelingEntityCollection;
    }

    public TravelingEntityType getTypeId() {
        return typeId;
    }

    public void setTypeId(TravelingEntityType typeId) {
        this.typeId = typeId;
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
        if (!(object instanceof TravelingEntity)) {
            return false;
        }
        TravelingEntity other = (TravelingEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.TravelingEntity[ id=" + id + " ]";
    }
    
}
