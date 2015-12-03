/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.dao.impl;

import com.sat.dao.AbstractFacade;
import com.sat.dao.HopitalFacadeLocal;
import com.sat.entities.Hopital;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author philippe
 */
@Stateless
public class HopitalFacade extends AbstractFacade<Hopital> implements HopitalFacadeLocal {
    @PersistenceContext(unitName = "SAT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HopitalFacade() {
        super(Hopital.class);
    }
    
}
