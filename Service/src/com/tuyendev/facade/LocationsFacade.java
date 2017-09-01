/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.facade;

import com.tuyendev.remote.LocationsFacadeRemote;
import com.tuyendev.local.LocationsFacadeLocal;
import com.tuyendev.entities.Locations;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tuyen Nguyen
 */
@Stateless(name = "EJB-Name-LocationsFacade", mappedName="EJB-Mapped-Name-LocationsFacade")
public class LocationsFacade extends AbstractFacade<Locations> implements LocationsFacadeLocal, LocationsFacadeRemote {

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
