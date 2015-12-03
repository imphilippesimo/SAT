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
public class CameraPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "numeroCam")
    private String numeroCam;

    public CameraPK() {
    }

    public CameraPK(int id, String numeroCam) {
        this.id = id;
        this.numeroCam = numeroCam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroCam() {
        return numeroCam;
    }

    public void setNumeroCam(String numeroCam) {
        this.numeroCam = numeroCam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (numeroCam != null ? numeroCam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CameraPK)) {
            return false;
        }
        CameraPK other = (CameraPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.numeroCam == null && other.numeroCam != null) || (this.numeroCam != null && !this.numeroCam.equals(other.numeroCam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sat.entities.CameraPK[ id=" + id + ", numeroCam=" + numeroCam + " ]";
    }
    
}
