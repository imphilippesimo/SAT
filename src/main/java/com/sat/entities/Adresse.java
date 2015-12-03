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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author philippe
 */
@Entity
@Table(name = "Adresse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a"),
    @NamedQuery(name = "Adresse.findById", query = "SELECT a FROM Adresse a WHERE a.id = :id"),
    @NamedQuery(name = "Adresse.findByAddrIp", query = "SELECT a FROM Adresse a WHERE a.addrIp = :addrIp")})
public class Adresse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 15)
    @Column(name = "addr_ip")
    private String addrIp;
    @JoinColumn(name = "id_coord", referencedColumnName = "id")
    @ManyToOne
    private Coordonnee idCoord;
    @OneToMany(mappedBy = "idAddr")
    private Collection<DispositifEmetteur> dispositifEmetteurCollection;
    @OneToMany(mappedBy = "idAddr")
    private Collection<Stationbase> stationbaseCollection;
    @OneToMany(mappedBy = "idAddr")
    private Collection<CentreSecurite> centreSecuriteCollection;
    @OneToMany(mappedBy = "idAddr")
    private Collection<Hopital> hopitalCollection;
    @OneToMany(mappedBy = "idAddr")
    private Collection<Camera> cameraCollection;
    @OneToMany(mappedBy = "idAddr")
    private Collection<Utilisateur> utilisateurCollection;

    public Adresse() {
    }

    public Adresse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddrIp() {
        return addrIp;
    }

    public void setAddrIp(String addrIp) {
        this.addrIp = addrIp;
    }

    public Coordonnee getIdCoord() {
        return idCoord;
    }

    public void setIdCoord(Coordonnee idCoord) {
        this.idCoord = idCoord;
    }

    @XmlTransient
    public Collection<DispositifEmetteur> getDispositifEmetteurCollection() {
        return dispositifEmetteurCollection;
    }

    public void setDispositifEmetteurCollection(Collection<DispositifEmetteur> dispositifEmetteurCollection) {
        this.dispositifEmetteurCollection = dispositifEmetteurCollection;
    }

    @XmlTransient
    public Collection<Stationbase> getStationbaseCollection() {
        return stationbaseCollection;
    }

    public void setStationbaseCollection(Collection<Stationbase> stationbaseCollection) {
        this.stationbaseCollection = stationbaseCollection;
    }

    @XmlTransient
    public Collection<CentreSecurite> getCentreSecuriteCollection() {
        return centreSecuriteCollection;
    }

    public void setCentreSecuriteCollection(Collection<CentreSecurite> centreSecuriteCollection) {
        this.centreSecuriteCollection = centreSecuriteCollection;
    }

    @XmlTransient
    public Collection<Hopital> getHopitalCollection() {
        return hopitalCollection;
    }

    public void setHopitalCollection(Collection<Hopital> hopitalCollection) {
        this.hopitalCollection = hopitalCollection;
    }

    @XmlTransient
    public Collection<Camera> getCameraCollection() {
        return cameraCollection;
    }

    public void setCameraCollection(Collection<Camera> cameraCollection) {
        this.cameraCollection = cameraCollection;
    }

    @XmlTransient
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
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
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sat.entities.Adresse[ id=" + id + " ]";
    }
    
}
