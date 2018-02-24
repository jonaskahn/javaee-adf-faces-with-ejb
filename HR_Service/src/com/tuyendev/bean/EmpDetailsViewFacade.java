/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.base.BaseFacade;
import com.tuyendev.common.Constant;
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
@Stateless(name = com.tuyendev
                     .common
                     .Constant
                     .EJB_NAME
                     .EMP_DETAILS_VIEW_FACADE,mappedName = com.tuyendev
                                                               .common
                                                               .Constant
                                                               .EJB_MAPPED_NAME
                                                               .EMP_DETAILS_VIEW_FACADE)
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

    @Override
    public void create(EmpDetailsView entity) throws Exception {
        // TODO Implement this method
    }

    @Override
    public void save(EmpDetailsViewDTO dto) throws Exception {
        // TODO Implement this method
    }

    @Override
    public String getSequenceName() {
        // TODO Implement this method
        return null;
    }
}
