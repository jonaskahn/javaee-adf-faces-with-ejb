/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.base.BaseFacade;
import com.tuyendev.common.ServiceName;
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
@Stateless(name = ServiceName.EJB_NAME.DEPARTMENTS_FACADE,mappedName = ServiceName.EJB_MAPPED_NAME.DEPARTMENTS_FACADE)
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
}
