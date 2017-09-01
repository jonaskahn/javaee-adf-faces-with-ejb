/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.facade;

import com.tuyendev.remote.EmpDetailsViewFacadeRemote;
import com.tuyendev.local.EmpDetailsViewFacadeLocal;
import com.tuyendev.entities.EmpDetailsView;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tuyen Nguyen
 */
@Stateless(name = "EJB-Name-EmpDetailsViewFacade", mappedName="EJB-Mapped-Name-EmpDetailsViewFacade")
public class EmpDetailsViewFacade extends AbstractFacade<EmpDetailsView> implements EmpDetailsViewFacadeLocal, EmpDetailsViewFacadeRemote {

    @PersistenceContext(unitName = "Service")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpDetailsViewFacade() {
        super(EmpDetailsView.class);
    }
    
}
