/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sat.dao;

import com.sat.entities.Camera;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author philippe
 */
@Local
public interface CameraFacadeLocal {

    void create(Camera camera);

    void edit(Camera camera);

    void remove(Camera camera);

    Camera find(Object id);

    List<Camera> findAll();

    List<Camera> findRange(int[] range);

    int count();
    
}
