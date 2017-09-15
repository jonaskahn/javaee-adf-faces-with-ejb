/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.common.ServiceName;
import com.tuyendev.inf.RegionsFacadeLocal;
import com.tuyendev.entities.Regions;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tuyen Nguyen
 */
@Stateless(name=ServiceName.EJB_NAME.REGIONS_FACADE,mappedName=ServiceName.EJB_MAPPED_NAME.REGIONS_FACADE)
public class RegionsFacade extends AbstractFacade<Regions> implements RegionsFacadeLocal, com.tuyendev.inf.RegionsFacadeRemote {

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
