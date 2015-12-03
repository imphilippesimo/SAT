/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.dao;

import com.sat.entities.Stationbase;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author philippe
 */
@Local
public interface StationbaseFacadeLocal {

    void create(Stationbase stationbase);

    void edit(Stationbase stationbase);

    void remove(Stationbase stationbase);

    Stationbase find(Object id);

    List<Stationbase> findAll();

    List<Stationbase> findRange(int[] range);

    int count();
    
}
