/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.base.BaseFacade;
import com.tuyendev.common.Constant;
import com.tuyendev.dto.JobsDTO;
import com.tuyendev.entities.Countries;
import com.tuyendev.local.JobsFacadeLocal;
import com.tuyendev.entities.Jobs;
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
                     .JOBS_FACADE,mappedName = com.tuyendev
                                                   .common
                                                   .Constant
                                                   .EJB_MAPPED_NAME
                                                   .JOBS_FACADE)
public class JobsFacade extends BaseFacade<Jobs,JobsDTO> implements JobsFacadeLocal, com.tuyendev.remote.JobsFacadeRemote {

    @PersistenceContext(unitName = "HR_Service")
    private EntityManager em;
    
    private final AdvanceMapper mapper = new AdvanceMapper<Jobs,JobsDTO>(Jobs.class, JobsDTO.class);

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobsFacade() {
        super(Jobs.class,JobsDTO.class);
    }

    @Override
    protected AdvanceMapper getMapper() {
        return mapper;
    }

    @Override
    public void create(Jobs entity) throws Exception {
        // TODO Implement this method
    }

    @Override
    public void save(JobsDTO dto) throws Exception {
        // TODO Implement this method
    }

    @Override
    public String getSequenceName() {
        return Constant.SEQUENCE_NAME.JOBS_SEQ;
    }
}
