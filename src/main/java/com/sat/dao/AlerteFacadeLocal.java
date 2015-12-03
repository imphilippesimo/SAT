/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.dao;

import com.sat.entities.Alerte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author philippe
 */
@Local
public interface AlerteFacadeLocal {

    void create(Alerte alerte);

    void edit(Alerte alerte);

    void remove(Alerte alerte);

    Alerte find(Object id);

    List<Alerte> findAll();

    List<Alerte> findRange(int[] range);

    int count();
    
}
