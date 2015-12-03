/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author philippe
 */
@Entity
@Table(name = "Alerte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alerte.findAll", query = "SELECT a FROM Alerte a"),
    @NamedQuery(name = "Alerte.findById", query = "SELECT a FROM Alerte a WHERE a.id = :id"),
    @NamedQuery(name = "Alerte.findByDate", query = "SELECT a FROM Alerte a WHERE a.date = :date")})
public class Alerte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "destinationCs", referencedColumnName = "id")
    @ManyToOne
    private CentreSecurite destinationCs;
    @JoinColumn(name = "destinationHop", referencedColumnName = "id")
    @ManyToOne
    private Hopital destinationHop;
    @JoinColumn(name = "operateur", referencedColumnName = "id")
    @ManyToOne
    private Utilisateur operateur;

    public Alerte() {
    }

    public Alerte(Integer id) {
        this.id = id;
    }

    public Alerte(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CentreSecurite getDestinationCs() {
        return destinationCs;
    }

    public void setDestinationCs(CentreSecurite destinationCs) {
        this.destinationCs = destinationCs;
    }

    public Hopital getDestinationHop() {
        return destinationHop;
    }

    public void setDestinationHop(Hopital destinationHop) {
        this.destinationHop = destinationHop;
    }

    public Utilisateur getOperateur() {
        return operateur;
    }

    public void setOperateur(Utilisateur operateur) {
        this.operateur = operateur;
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
        if (!(object instanceof Alerte)) {
            return false;
        }
        Alerte other = (Alerte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sat.entities.Alerte[ id=" + id + " ]";
    }
    
}
