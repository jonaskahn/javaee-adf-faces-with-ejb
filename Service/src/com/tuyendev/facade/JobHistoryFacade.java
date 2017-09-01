/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.facade;

import com.tuyendev.remote.JobHistoryFacadeRemote;
import com.tuyendev.local.JobHistoryFacadeLocal;
import com.tuyendev.entities.JobHistory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tuyen Nguyen
 */
@Stateless(name = "EJB-Name-JobHistoryFacade", mappedName="EJB-Mapped-Name-JobHistoryFacade")
public class JobHistoryFacade extends AbstractFacade<JobHistory> implements JobHistoryFacadeLocal, JobHistoryFacadeRemote {

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
