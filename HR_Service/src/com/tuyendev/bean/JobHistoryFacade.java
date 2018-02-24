/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.base.BaseFacade;
import com.tuyendev.common.Constant;
import com.tuyendev.dto.JobHistoryDTO;
import com.tuyendev.local.JobHistoryFacadeLocal;
import com.tuyendev.entities.JobHistory;
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
                     .JOB_HISTORY_FACADE,mappedName = com.tuyendev
                                                          .common
                                                          .Constant
                                                          .EJB_MAPPED_NAME
                                                          .JOB_HISTORY_FACADE)
public class JobHistoryFacade extends BaseFacade<JobHistory,JobHistoryDTO> implements JobHistoryFacadeLocal, com.tuyendev.remote.JobHistoryFacadeRemote {

    @PersistenceContext(unitName = "HR_Service")
    private EntityManager em;
    
    private final AdvanceMapper mapper  = new AdvanceMapper<JobHistory,JobHistoryDTO>(JobHistory.class, JobHistoryDTO.class);

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobHistoryFacade() {
        super(JobHistory.class,JobHistoryDTO.class);
    }

    @Override
    protected AdvanceMapper getMapper() {
        return mapper;
    }

    @Override
    public void create(JobHistory entity) throws Exception {
        // TODO Implement this method
    }

    @Override
    public void save(JobHistoryDTO dto) throws Exception {
        // TODO Implement this method
    }

    @Override
    public String getSequenceName() {
        // TODO Implement this method
        return null;
    }
}
