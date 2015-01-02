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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "RESERVATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findById", query = "SELECT r FROM Reservation r WHERE r.id = :id"),
    @NamedQuery(name = "Reservation.findByReservationNumber", query = "SELECT r FROM Reservation r WHERE r.reservationNumber = :reservationNumber"),
    @NamedQuery(name = "Reservation.findByHasArrived", query = "SELECT r FROM Reservation r WHERE r.hasArrived = :hasArrived"),
    @NamedQuery(name = "Reservation.findByTotalprice", query = "SELECT r FROM Reservation r WHERE r.totalprice = :totalprice")})
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "RESERVATION_NUMBER")
    private String reservationNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HAS_ARRIVED")
    private Character hasArrived;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALPRICE")
    private Serializable totalprice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservationId")
    private Collection<ReservationTravelingEntity> reservationTravelingEntityCollection;
    @JoinColumn(name = "DEPARTURE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Departure departureId;
    @JoinColumn(name = "BOOKER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Person bookerId;

    public Reservation() {
    }

    public Reservation(BigDecimal id) {
        this.id = id;
    }

    public Reservation(BigDecimal id, String reservationNumber, Character hasArrived, Serializable totalprice) {
        this.id = id;
        this.reservationNumber = reservationNumber;
        this.hasArrived = hasArrived;
        this.totalprice = totalprice;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Character getHasArrived() {
        return hasArrived;
    }

    public void setHasArrived(Character hasArrived) {
        this.hasArrived = hasArrived;
    }

    public Serializable getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Serializable totalprice) {
        this.totalprice = totalprice;
    }

    @XmlTransient
    public Collection<ReservationTravelingEntity> getReservationTravelingEntityCollection() {
        return reservationTravelingEntityCollection;
    }

    public void setReservationTravelingEntityCollection(Collection<ReservationTravelingEntity> reservationTravelingEntityCollection) {
        this.reservationTravelingEntityCollection = reservationTravelingEntityCollection;
    }

    public Departure getDepartureId() {
        return departureId;
    }

    public void setDepartureId(Departure departureId) {
        this.departureId = departureId;
    }

    public Person getBookerId() {
        return bookerId;
    }

    public void setBookerId(Person bookerId) {
        this.bookerId = bookerId;
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
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.Reservation[ id=" + id + " ]";
    }
    
}
