/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.common.ServiceName;
import com.tuyendev.inf.LocationsFacadeLocal;
import com.tuyendev.entities.Locations;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tuyen Nguyen
 */
@Stateless(name=ServiceName.EJB_NAME.LOCATIONS_FACADE,mappedName=ServiceName.EJB_MAPPED_NAME.LOCATIONS_FACADE)
public class LocationsFacade extends AbstractFacade<Locations> implements LocationsFacadeLocal, com.tuyendev.inf.LocationsFacadeRemote {

    @PersistenceContext(unitName = "Service")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocationsFacade() {
        super(Locations.class);
    }
    
}
