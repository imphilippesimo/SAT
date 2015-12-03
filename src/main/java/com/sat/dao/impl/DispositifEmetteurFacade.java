/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.dao.impl;

import com.sat.dao.AbstractFacade;
import com.sat.dao.DispositifEmetteurFacadeLocal;
import com.sat.entities.DispositifEmetteur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author philippe
 */
@Stateless
public class DispositifEmetteurFacade extends AbstractFacade<DispositifEmetteur> implements DispositifEmetteurFacadeLocal {
    @PersistenceContext(unitName = "SAT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DispositifEmetteurFacade() {
        super(DispositifEmetteur.class);
    }
    
}
