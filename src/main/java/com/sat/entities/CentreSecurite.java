/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author philippe
 */
@Entity
@Table(name = "CentreSecurite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentreSecurite.findAll", query = "SELECT c FROM CentreSecurite c"),
    @NamedQuery(name = "CentreSecurite.findById", query = "SELECT c FROM CentreSecurite c WHERE c.id = :id"),
    @NamedQuery(name = "CentreSecurite.findByNom", query = "SELECT c FROM CentreSecurite c WHERE c.nom = :nom")})
public class CentreSecurite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "id_addr", referencedColumnName = "id")
    @ManyToOne
    private Adresse idAddr;
    @OneToMany(mappedBy = "destinationCs")
    private Collection<Alerte> alerteCollection;

    public CentreSecurite() {
    }

    public CentreSecurite(Integer id) {
        this.id = id;
    }

    public CentreSecurite(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getIdAddr() {
        return idAddr;
    }

    public void setIdAddr(Adresse idAddr) {
        this.idAddr = idAddr;
    }

    @XmlTransient
    public Collection<Alerte> getAlerteCollection() {
        return alerteCollection;
    }

    public void setAlerteCollection(Collection<Alerte> alerteCollection) {
        this.alerteCollection = alerteCollection;
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
        if (!(object instanceof CentreSecurite)) {
            return false;
        }
        CentreSecurite other = (CentreSecurite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sat.entities.CentreSecurite[ id=" + id + " ]";
    }
    
}
