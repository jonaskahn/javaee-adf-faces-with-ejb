/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.facade;

import com.tuyendev.remote.DepartmentsFacadeRemote;
import com.tuyendev.local.DepartmentsFacadeLocal;
import com.tuyendev.entities.Departments;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tuyen Nguyen
 */
@Stateless(name = "EJB-Name-DepartmentsFacade", mappedName="EJB-Mapped-Name-DepartmentsFacade")
public class DepartmentsFacade extends AbstractFacade<Departments> implements DepartmentsFacadeLocal, DepartmentsFacadeRemote {

    @PersistenceContext(unitName = "Service")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartmentsFacade() {
        super(Departments.class);
    }
    
}
