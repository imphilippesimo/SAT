/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author philippe
 */
@Embeddable
public class StationbasePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "numeroRcpt")
    private String numeroRcpt;

    public StationbasePK() {
    }

    public StationbasePK(int id, String numeroRcpt) {
        this.id = id;
        this.numeroRcpt = numeroRcpt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroRcpt() {
        return numeroRcpt;
    }

    public void setNumeroRcpt(String numeroRcpt) {
        this.numeroRcpt = numeroRcpt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (numeroRcpt != null ? numeroRcpt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StationbasePK)) {
            return false;
        }
        StationbasePK other = (StationbasePK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.numeroRcpt == null && other.numeroRcpt != null) || (this.numeroRcpt != null && !this.numeroRcpt.equals(other.numeroRcpt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sat.entities.StationbasePK[ id=" + id + ", numeroRcpt=" + numeroRcpt + " ]";
    }
    
}
