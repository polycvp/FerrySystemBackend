/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferry.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "RESERVATION_TRAVELING_ENTITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservationTravelingEntity.findAll", query = "SELECT r FROM ReservationTravelingEntity r"),
    @NamedQuery(name = "ReservationTravelingEntity.findById", query = "SELECT r FROM ReservationTravelingEntity r WHERE r.id = :id")})
public class ReservationTravelingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "RESERVATION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Reservation reservationId;
    @JoinColumn(name = "TRAVELING_ENTITY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TravelingEntity travelingEntityId;

    public ReservationTravelingEntity() {
    }

    public ReservationTravelingEntity(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Reservation getReservationId() {
        return reservationId;
    }

    public void setReservationId(Reservation reservationId) {
        this.reservationId = reservationId;
    }

    public TravelingEntity getTravelingEntityId() {
        return travelingEntityId;
    }

    public void setTravelingEntityId(TravelingEntity travelingEntityId) {
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
        if (!(object instanceof ReservationTravelingEntity)) {
            return false;
        }
        ReservationTravelingEntity other = (ReservationTravelingEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.ReservationTravelingEntity[ id=" + id + " ]";
    }
    
}
