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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "PASSANGER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passanger.findAll", query = "SELECT p FROM Passanger p"),
    @NamedQuery(name = "Passanger.findById", query = "SELECT p FROM Passanger p WHERE p.id = :id"),
    @NamedQuery(name = "Passanger.findByPassangerName", query = "SELECT p FROM Passanger p WHERE p.passangerName = :passangerName")})
public class Passanger implements Serializable {
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
    @Column(name = "PASSANGER_NAME")
    private String passangerName;

    public Passanger() {
    }

    public Passanger(BigDecimal id) {
        this.id = id;
    }

    public Passanger(BigDecimal id, String passangerName) {
        this.id = id;
        this.passangerName = passangerName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getPassangerName() {
        return passangerName;
    }

    public void setPassangerName(String passangerName) {
        this.passangerName = passangerName;
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
        if (!(object instanceof Passanger)) {
            return false;
        }
        Passanger other = (Passanger) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.Passanger[ id=" + id + " ]";
    }
    
}
