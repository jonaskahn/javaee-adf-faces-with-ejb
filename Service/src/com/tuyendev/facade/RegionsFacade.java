/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.facade;

import com.tuyendev.remote.RegionsFacadeRemote;
import com.tuyendev.local.RegionsFacadeLocal;
import com.tuyendev.entities.Regions;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tuyen Nguyen
 */
@Stateless(name = "EJB-Name-RegionsFacade", mappedName="EJB-Mapped-Name-RegionsFacade")
public class RegionsFacade extends AbstractFacade<Regions> implements RegionsFacadeLocal, RegionsFacadeRemote {

    @PersistenceContext(unitName = "Service")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegionsFacade() {
        super(Regions.class);
    }
    
}
