/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.local;

import com.tuyendev.entities.Jobs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tuyen Nguyen
 */
@Local
public interface JobsFacadeLocal {

    void create(Jobs jobs);

    void edit(Jobs jobs);

    void remove(Jobs jobs);

    Jobs find(Object id);

    List<Jobs> findAll();

    List<Jobs> findRange(int[] range);

    int count();
    
}
