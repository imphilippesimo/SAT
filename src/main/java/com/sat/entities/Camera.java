/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author philippe
 */
@Entity
@Table(name = "Camera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camera.findAll", query = "SELECT c FROM Camera c"),
    @NamedQuery(name = "Camera.findById", query = "SELECT c FROM Camera c WHERE c.cameraPK.id = :id"),
    @NamedQuery(name = "Camera.findByNumeroCam", query = "SELECT c FROM Camera c WHERE c.cameraPK.numeroCam = :numeroCam"),
    @NamedQuery(name = "Camera.findByNom", query = "SELECT c FROM Camera c WHERE c.nom = :nom")})
public class Camera implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CameraPK cameraPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "id_addr", referencedColumnName = "id")
    @ManyToOne
    private Adresse idAddr;
    @JoinColumn(name = "id_station_base", referencedColumnName = "id")
    @ManyToOne
    private Stationbase idStationBase;

    public Camera() {
    }

    public Camera(CameraPK cameraPK) {
        this.cameraPK = cameraPK;
    }

    public Camera(CameraPK cameraPK, String nom) {
        this.cameraPK = cameraPK;
        this.nom = nom;
    }

    public Camera(int id, String numeroCam) {
        this.cameraPK = new CameraPK(id, numeroCam);
    }

    public CameraPK getCameraPK() {
        return cameraPK;
    }

    public void setCameraPK(CameraPK cameraPK) {
        this.cameraPK = cameraPK;
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

    public Stationbase getIdStationBase() {
        return idStationBase;
    }

    public void setIdStationBase(Stationbase idStationBase) {
        this.idStationBase = idStationBase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cameraPK != null ? cameraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camera)) {
            return false;
        }
        Camera other = (Camera) object;
        if ((this.cameraPK == null && other.cameraPK != null) || (this.cameraPK != null && !this.cameraPK.equals(other.cameraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sat.entities.Camera[ cameraPK=" + cameraPK + " ]";
    }
    
}
