/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.dao;

import com.sat.entities.DispositifEmetteur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author philippe
 */
@Local
public interface DispositifEmetteurFacadeLocal {

    void create(DispositifEmetteur dispositifEmetteur);

    void edit(DispositifEmetteur dispositifEmetteur);

    void remove(DispositifEmetteur dispositifEmetteur);

    DispositifEmetteur find(Object id);

    List<DispositifEmetteur> findAll();

    List<DispositifEmetteur> findRange(int[] range);

    int count();
    
}
