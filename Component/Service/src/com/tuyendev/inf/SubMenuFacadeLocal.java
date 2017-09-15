/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.inf;

import com.tuyendev.entities.SubMenu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tuyen Nguyen
 */
@Local
public interface SubMenuFacadeLocal {

    void create(SubMenu subMenu);

    void edit(SubMenu subMenu);

    void remove(SubMenu subMenu);

    SubMenu find(Object id);

    List<SubMenu> findAll();

    List<SubMenu> findRange(int[] range);

    int count();
    
}
