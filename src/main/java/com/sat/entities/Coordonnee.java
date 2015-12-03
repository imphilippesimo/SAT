/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author philippe
 */
@Entity
@Table(name = "Coordonnee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordonnee.findAll", query = "SELECT c FROM Coordonnee c"),
    @NamedQuery(name = "Coordonnee.findById", query = "SELECT c FROM Coordonnee c WHERE c.id = :id"),
    @NamedQuery(name = "Coordonnee.findByAbs", query = "SELECT c FROM Coordonnee c WHERE c.abs = :abs"),
    @NamedQuery(name = "Coordonnee.findByOrd", query = "SELECT c FROM Coordonnee c WHERE c.ord = :ord")})
public class Coordonnee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "abs")
    private BigInteger abs;
    @Column(name = "ord")
    private BigInteger ord;
    @OneToMany(mappedBy = "idCoord")
    private Collection<Adresse> adresseCollection;

    public Coordonnee() {
    }

    public Coordonnee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getAbs() {
        return abs;
    }

    public void setAbs(BigInteger abs) {
        this.abs = abs;
    }

    public BigInteger getOrd() {
        return ord;
    }

    public void setOrd(BigInteger ord) {
        this.ord = ord;
    }

    @XmlTransient
    public Collection<Adresse> getAdresseCollection() {
        return adresseCollection;
    }

    public void setAdresseCollection(Collection<Adresse> adresseCollection) {
        this.adresseCollection = adresseCollection;
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
        if (!(object instanceof Coordonnee)) {
            return false;
        }
        Coordonnee other = (Coordonnee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sat.entities.Coordonnee[ id=" + id + " ]";
    }
    
}
