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
@Table(name = "FERRY_IN_HARBOUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FerryInHarbour.findAll", query = "SELECT f FROM FerryInHarbour f"),
    @NamedQuery(name = "FerryInHarbour.findById", query = "SELECT f FROM FerryInHarbour f WHERE f.id = :id")})
public class FerryInHarbour implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "FERRY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ferry ferryId;
    @JoinColumn(name = "HARBOUR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Harbour harbourId;

    public FerryInHarbour() {
    }

    public FerryInHarbour(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Ferry getFerryId() {
        return ferryId;
    }

    public void setFerryId(Ferry ferryId) {
        this.ferryId = ferryId;
    }

    public Harbour getHarbourId() {
        return harbourId;
    }

    public void setHarbourId(Harbour harbourId) {
        this.harbourId = harbourId;
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
        if (!(object instanceof FerryInHarbour)) {
            return false;
        }
        FerryInHarbour other = (FerryInHarbour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.FerryInHarbour[ id=" + id + " ]";
    }
    
}
