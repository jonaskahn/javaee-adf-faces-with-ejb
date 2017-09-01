/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.facade;

import com.tuyendev.remote.EmployeesFacadeRemote;
import com.tuyendev.local.EmployeesFacadeLocal;
import com.tuyendev.entities.Employees;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tuyen Nguyen
 */
@Stateless(name = "EJB-Name-EmployeesFacade", mappedName="EJB-Mapped-Name-EmployeesFacade")
public class EmployeesFacade extends AbstractFacade<Employees> implements EmployeesFacadeLocal, EmployeesFacadeRemote {

    @PersistenceContext(unitName = "Service")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeesFacade() {
        super(Employees.class);
    }
    
}
