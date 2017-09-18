/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.base.BaseFacade;
import com.tuyendev.common.ServiceName;
import com.tuyendev.dto.EmpDetailsViewDTO;
import com.tuyendev.local.EmpDetailsViewFacadeLocal;
import com.tuyendev.entities.EmpDetailsView;
import com.tuyendev.mapper.AdvanceMapper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tuyendev
 */
@Stateless(name = ServiceName.EJB_NAME.EMP_DETAILS_VIEW_FACADE,mappedName = ServiceName.EJB_MAPPED_NAME.EMP_DETAILS_VIEW_FACADE)
public class EmpDetailsViewFacade extends BaseFacade<EmpDetailsView,EmpDetailsViewDTO> implements EmpDetailsViewFacadeLocal, com.tuyendev.remote.EmpDetailsViewFacadeRemote {

    @PersistenceContext(unitName = "HR_Service")
    private EntityManager em;
    
    private final AdvanceMapper mapper = new AdvanceMapper<EmpDetailsView,EmpDetailsViewDTO>(EmpDetailsView.class,EmpDetailsViewDTO.class);

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpDetailsViewFacade() {
        super(EmpDetailsView.class,EmpDetailsViewDTO.class);
    }

    @Override
    protected AdvanceMapper getMapper() {
        return mapper;
    }
}
