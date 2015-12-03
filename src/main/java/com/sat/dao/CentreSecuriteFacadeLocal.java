/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.dao;

import com.sat.entities.CentreSecurite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author philippe
 */
@Local
public interface CentreSecuriteFacadeLocal {

    void create(CentreSecurite centreSecurite);

    void edit(CentreSecurite centreSecurite);

    void remove(CentreSecurite centreSecurite);

    CentreSecurite find(Object id);

    List<CentreSecurite> findAll();

    List<CentreSecurite> findRange(int[] range);

    int count();
    
}
