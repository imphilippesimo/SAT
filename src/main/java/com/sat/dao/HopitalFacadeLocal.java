/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.dao;

import com.sat.entities.Hopital;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author philippe
 */
@Local
public interface HopitalFacadeLocal {

    void create(Hopital hopital);

    void edit(Hopital hopital);

    void remove(Hopital hopital);

    Hopital find(Object id);

    List<Hopital> findAll();

    List<Hopital> findRange(int[] range);

    int count();
    
}
