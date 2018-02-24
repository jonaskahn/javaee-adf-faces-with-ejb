/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.base.BaseFacade;
import com.tuyendev.common.Constant;
import com.tuyendev.dto.DepartmentsDTO;
import com.tuyendev.local.DepartmentsFacadeLocal;
import com.tuyendev.entities.Departments;
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
                     .DEPARTMENTS_FACADE,mappedName = com.tuyendev
                                                          .common
                                                          .Constant
                                                          .EJB_MAPPED_NAME
                                                          .DEPARTMENTS_FACADE)
public class DepartmentsFacade extends BaseFacade<Departments,DepartmentsDTO> implements DepartmentsFacadeLocal, com.tuyendev.remote.DepartmentsFacadeRemote {

    @PersistenceContext(unitName = "HR_Service")
    private EntityManager em;
    
    private final AdvanceMapper mapper = new AdvanceMapper<Departments,DepartmentsDTO>(Departments.class, DepartmentsDTO.class);

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartmentsFacade() {
        super(Departments.class,DepartmentsDTO.class);
    }

    @Override
    protected AdvanceMapper getMapper() {
        return mapper;
    }

    @Override
    public void create(Departments entity) throws Exception {
        // TODO Implement this method
    }

    @Override
    public void save(DepartmentsDTO dto) throws Exception {
        // TODO Implement this method
    }

    @Override
    public String getSequenceName() {
        
        return null;
    }
}
