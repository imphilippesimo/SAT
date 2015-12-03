/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.dao;

import com.sat.entities.Coordonnee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author philippe
 */
@Local
public interface CoordonneeFacadeLocal {

    void create(Coordonnee coordonnee);

    void edit(Coordonnee coordonnee);

    void remove(Coordonnee coordonnee);

    Coordonnee find(Object id);

    List<Coordonnee> findAll();

    List<Coordonnee> findRange(int[] range);

    int count();
    
}
