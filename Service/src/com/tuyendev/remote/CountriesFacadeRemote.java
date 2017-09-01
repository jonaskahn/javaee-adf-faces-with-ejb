/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.remote;

import com.tuyendev.entities.Countries;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Tuyen Nguyen
 */
@Remote
public interface CountriesFacadeRemote {

    void create(Countries countries);

    void edit(Countries countries);

    void remove(Countries countries);

    Countries find(Object id);

    List<Countries> findAll();

    List<Countries> findRange(int[] range);

    int count();
    
}
