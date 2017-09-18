/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.base.BaseFacade;
import com.tuyendev.common.ServiceName;
import com.tuyendev.dto.LocationsDTO;
import com.tuyendev.local.LocationsFacadeLocal;
import com.tuyendev.entities.Locations;
import com.tuyendev.mapper.AdvanceMapper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tuyendev
 */
@Stateless(name = ServiceName.EJB_NAME.LOCATIONS_FACADE,mappedName = ServiceName.EJB_MAPPED_NAME.LOCATIONS_FACADE)
public class LocationsFacade extends BaseFacade<Locations,LocationsDTO> implements LocationsFacadeLocal, com.tuyendev.remote.LocationsFacadeRemote {

    @PersistenceContext(unitName = "HR_Service")
    private EntityManager em;
    
    private final AdvanceMapper mapper = new AdvanceMapper<Locations,LocationsDTO>(Locations.class, LocationsDTO.class);

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocationsFacade() {
        super(Locations.class,LocationsDTO.class);
    }

    @Override
    protected AdvanceMapper getMapper() {
        return mapper;
    }
}
