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
@Table(name = "Hopital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hopital.findAll", query = "SELECT h FROM Hopital h"),
    @NamedQuery(name = "Hopital.findById", query = "SELECT h FROM Hopital h WHERE h.id = :id"),
    @NamedQuery(name = "Hopital.findByNom", query = "SELECT h FROM Hopital h WHERE h.nom = :nom")})
public class Hopital implements Serializable {
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
    @OneToMany(mappedBy = "destinationHop")
    private Collection<Alerte> alerteCollection;
    @JoinColumn(name = "id_addr", referencedColumnName = "id")
    @ManyToOne
    private Adresse idAddr;

    public Hopital() {
    }

    public Hopital(Integer id) {
        this.id = id;
    }

    public Hopital(Integer id, String nom) {
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

    @XmlTransient
    public Collection<Alerte> getAlerteCollection() {
        return alerteCollection;
    }

    public void setAlerteCollection(Collection<Alerte> alerteCollection) {
        this.alerteCollection = alerteCollection;
    }

    public Adresse getIdAddr() {
        return idAddr;
    }

    public void setIdAddr(Adresse idAddr) {
        this.idAddr = idAddr;
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
        if (!(object instanceof Hopital)) {
            return false;
        }
        Hopital other = (Hopital) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sat.entities.Hopital[ id=" + id + " ]";
    }
    
}
