/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.inf;

import com.tuyendev.entities.Locations;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Tuyen Nguyen
 */
@Remote
public interface LocationsFacadeRemote {

    void create(Locations locations);

    void edit(Locations locations);

    void remove(Locations locations);

    Locations find(Object id);

    List<Locations> findAll();

    List<Locations> findRange(int[] range);

    int count();
    
}
