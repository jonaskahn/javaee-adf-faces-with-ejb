/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.facade;

import com.tuyendev.remote.CountriesFacadeRemote;
import com.tuyendev.local.CountriesFacadeLocal;
import com.tuyendev.entities.Countries;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tuyen Nguyen
 */
@Stateless(name = "EJB-Name-CountriesFacade", mappedName="EJB-Mapped-Name-CountriesFacade")
public class CountriesFacade extends AbstractFacade<Countries> implements CountriesFacadeLocal, CountriesFacadeRemote {

    @PersistenceContext(unitName = "Service")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountriesFacade() {
        super(Countries.class);
    }
    
}
