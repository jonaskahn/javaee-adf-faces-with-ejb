/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.common.ServiceName;
import com.tuyendev.inf.JobHistoryFacadeLocal;
import com.tuyendev.entities.JobHistory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tuyen Nguyen
 */
@Stateless(name=ServiceName.EJB_NAME.JOB_HISTORY_FACADE,mappedName=ServiceName.EJB_MAPPED_NAME.JOB_HISTORY_FACADE)
public class JobHistoryFacade extends AbstractFacade<JobHistory> implements JobHistoryFacadeLocal, com.tuyendev.inf.JobHistoryFacadeRemote {

    @PersistenceContext(unitName = "Service")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobHistoryFacade() {
        super(JobHistory.class);
    }
    
}
