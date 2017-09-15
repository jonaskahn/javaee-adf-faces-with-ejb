/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.common.ServiceName;
import com.tuyendev.inf.EmpDetailsViewFacadeLocal;
import com.tuyendev.entities.EmpDetailsView;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tuyen Nguyen
 */
@Stateless(name=ServiceName.EJB_NAME.EMP_DETAILS_VIEW_FACADE,mappedName=ServiceName.EJB_MAPPED_NAME.EMP_DETAILS_VIEW_FACADE)
public class EmpDetailsViewFacade extends AbstractFacade<EmpDetailsView> implements EmpDetailsViewFacadeLocal, com.tuyendev.inf.EmpDetailsViewFacadeRemote {

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
