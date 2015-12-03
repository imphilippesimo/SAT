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
@Table(name = "DispositifEmetteur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DispositifEmetteur.findAll", query = "SELECT d FROM DispositifEmetteur d"),
    @NamedQuery(name = "DispositifEmetteur.findById", query = "SELECT d FROM DispositifEmetteur d WHERE d.dispositifEmetteurPK.id = :id"),
    @NamedQuery(name = "DispositifEmetteur.findByNumeroEm", query = "SELECT d FROM DispositifEmetteur d WHERE d.dispositifEmetteurPK.numeroEm = :numeroEm"),
    @NamedQuery(name = "DispositifEmetteur.findByNom", query = "SELECT d FROM DispositifEmetteur d WHERE d.nom = :nom")})
public class DispositifEmetteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DispositifEmetteurPK dispositifEmetteurPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "id_addr", referencedColumnName = "id")
    @ManyToOne
    private Adresse idAddr;

    public DispositifEmetteur() {
    }

    public DispositifEmetteur(DispositifEmetteurPK dispositifEmetteurPK) {
        this.dispositifEmetteurPK = dispositifEmetteurPK;
    }

    public DispositifEmetteur(DispositifEmetteurPK dispositifEmetteurPK, String nom) {
        this.dispositifEmetteurPK = dispositifEmetteurPK;
        this.nom = nom;
    }

    public DispositifEmetteur(int id, String numeroEm) {
        this.dispositifEmetteurPK = new DispositifEmetteurPK(id, numeroEm);
    }

    public DispositifEmetteurPK getDispositifEmetteurPK() {
        return dispositifEmetteurPK;
    }

    public void setDispositifEmetteurPK(DispositifEmetteurPK dispositifEmetteurPK) {
        this.dispositifEmetteurPK = dispositifEmetteurPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dispositifEmetteurPK != null ? dispositifEmetteurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DispositifEmetteur)) {
            return false;
        }
        DispositifEmetteur other = (DispositifEmetteur) object;
        if ((this.dispositifEmetteurPK == null && other.dispositifEmetteurPK != null) || (this.dispositifEmetteurPK != null && !this.dispositifEmetteurPK.equals(other.dispositifEmetteurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sat.entities.DispositifEmetteur[ dispositifEmetteurPK=" + dispositifEmetteurPK + " ]";
    }
    
}
