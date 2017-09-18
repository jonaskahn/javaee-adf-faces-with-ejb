/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.base.BaseFacade;
import com.tuyendev.common.ServiceName;
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
@Stateless(name = ServiceName.EJB_NAME.JOB_HISTORY_FACADE,mappedName = ServiceName.EJB_MAPPED_NAME.JOB_HISTORY_FACADE)
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
}
