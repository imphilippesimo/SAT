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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "Station_base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stationbase.findAll", query = "SELECT s FROM Stationbase s"),
    @NamedQuery(name = "Stationbase.findById", query = "SELECT s FROM Stationbase s WHERE s.stationbasePK.id = :id"),
    @NamedQuery(name = "Stationbase.findByNumeroRcpt", query = "SELECT s FROM Stationbase s WHERE s.stationbasePK.numeroRcpt = :numeroRcpt"),
    @NamedQuery(name = "Stationbase.findByNom", query = "SELECT s FROM Stationbase s WHERE s.nom = :nom")})
public class Stationbase implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StationbasePK stationbasePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "id_addr", referencedColumnName = "id")
    @ManyToOne
    private Adresse idAddr;
    @OneToMany(mappedBy = "idStationBase")
    private Collection<Camera> cameraCollection;

    public Stationbase() {
    }

    public Stationbase(StationbasePK stationbasePK) {
        this.stationbasePK = stationbasePK;
    }

    public Stationbase(StationbasePK stationbasePK, String nom) {
        this.stationbasePK = stationbasePK;
        this.nom = nom;
    }

    public Stationbase(int id, String numeroRcpt) {
        this.stationbasePK = new StationbasePK(id, numeroRcpt);
    }

    public StationbasePK getStationbasePK() {
        return stationbasePK;
    }

    public void setStationbasePK(StationbasePK stationbasePK) {
        this.stationbasePK = stationbasePK;
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
    public Collection<Camera> getCameraCollection() {
        return cameraCollection;
    }

    public void setCameraCollection(Collection<Camera> cameraCollection) {
        this.cameraCollection = cameraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stationbasePK != null ? stationbasePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stationbase)) {
            return false;
        }
        Stationbase other = (Stationbase) object;
        if ((this.stationbasePK == null && other.stationbasePK != null) || (this.stationbasePK != null && !this.stationbasePK.equals(other.stationbasePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sat.entities.Stationbase[ stationbasePK=" + stationbasePK + " ]";
    }
    
}
