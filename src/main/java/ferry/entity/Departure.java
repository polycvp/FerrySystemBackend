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
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "DEPARTURE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departure.findAll", query = "SELECT d FROM Departure d"),
    @NamedQuery(name = "Departure.findById", query = "SELECT d FROM Departure d WHERE d.id = :id"),
    @NamedQuery(name = "Departure.findByDepartureTime", query = "SELECT d FROM Departure d WHERE d.departureTime = :departureTime"),
    @NamedQuery(name = "Departure.findByDepartureDate", query = "SELECT d FROM Departure d WHERE d.departureDate = :departureDate")})
public class Departure implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEPARTURE_TIME")
    private BigInteger departureTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEPARTURE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departureId")
    private Collection<Reservation> reservationCollection;
    @JoinColumn(name = "ROUTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Route routeId;

    public Departure() {
    }

    public Departure(BigDecimal id) {
        this.id = id;
    }

    public Departure(BigDecimal id, BigInteger departureTime, Date departureDate) {
        this.id = id;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(BigInteger departureTime) {
        this.departureTime = departureTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
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
        if (!(object instanceof Departure)) {
            return false;
        }
        Departure other = (Departure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.Departure[ id=" + id + " ]";
    }
    
}
