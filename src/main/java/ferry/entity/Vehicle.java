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
@Table(name = "VEHICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
    @NamedQuery(name = "Vehicle.findById", query = "SELECT v FROM Vehicle v WHERE v.id = :id"),
    @NamedQuery(name = "Vehicle.findByWeight", query = "SELECT v FROM Vehicle v WHERE v.weight = :weight"),
    @NamedQuery(name = "Vehicle.findByRegno", query = "SELECT v FROM Vehicle v WHERE v.regno = :regno"),
    @NamedQuery(name = "Vehicle.findByLenght", query = "SELECT v FROM Vehicle v WHERE v.lenght = :lenght"),
    @NamedQuery(name = "Vehicle.findByType", query = "SELECT v FROM Vehicle v WHERE v.type = :type")})
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEIGHT")
    private Serializable weight;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "REGNO")
    private String regno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LENGHT")
    private Serializable lenght;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "TYPE")
    private String type;

    public Vehicle() {
    }

    public Vehicle(BigDecimal id) {
        this.id = id;
    }

    public Vehicle(BigDecimal id, Serializable weight, String regno, Serializable lenght, String type) {
        this.id = id;
        this.weight = weight;
        this.regno = regno;
        this.lenght = lenght;
        this.type = type;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Serializable getWeight() {
        return weight;
    }

    public void setWeight(Serializable weight) {
        this.weight = weight;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public Serializable getLenght() {
        return lenght;
    }

    public void setLenght(Serializable lenght) {
        this.lenght = lenght;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.entity.Vehicle[ id=" + id + " ]";
    }
    
}
