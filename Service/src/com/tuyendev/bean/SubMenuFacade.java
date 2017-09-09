/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.common.ServiceName;
import com.tuyendev.inf.SubMenuFacadeLocal;
import com.tuyendev.inf.SubMenuFacadeRemote;
import com.tuyendev.entities.SubMenu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tuyen Nguyen
 */
@Stateless(name=ServiceName.EJB_NAME.SUB_MENU_FACADE,mappedName=ServiceName.EJB_MAPPED_NAME.SUB_MENU_FACADE)
public class SubMenuFacade extends AbstractFacade<SubMenu> implements SubMenuFacadeLocal, SubMenuFacadeRemote {

    @PersistenceContext(unitName = "Service")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubMenuFacade() {
        super(SubMenu.class);
    }
    
}
