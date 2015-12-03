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
public class DispositifEmetteurPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "numeroEm")
    private String numeroEm;

    public DispositifEmetteurPK() {
    }

    public DispositifEmetteurPK(int id, String numeroEm) {
        this.id = id;
        this.numeroEm = numeroEm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroEm() {
        return numeroEm;
    }

    public void setNumeroEm(String numeroEm) {
        this.numeroEm = numeroEm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (numeroEm != null ? numeroEm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DispositifEmetteurPK)) {
            return false;
        }
        DispositifEmetteurPK other = (DispositifEmetteurPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.numeroEm == null && other.numeroEm != null) || (this.numeroEm != null && !this.numeroEm.equals(other.numeroEm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sat.entities.DispositifEmetteurPK[ id=" + id + ", numeroEm=" + numeroEm + " ]";
    }
    
}
