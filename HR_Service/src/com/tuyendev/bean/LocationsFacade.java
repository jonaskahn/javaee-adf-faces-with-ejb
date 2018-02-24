/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.base.BaseFacade;
import com.tuyendev.common.Constant;
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
@Stateless(name = com.tuyendev
                     .common
                     .Constant
                     .EJB_NAME
                     .LOCATIONS_FACADE,mappedName = com.tuyendev
                                                        .common
                                                        .Constant
                                                        .EJB_MAPPED_NAME
                                                        .LOCATIONS_FACADE)
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

    @Override
    public void create(Locations entity) throws Exception {
        // TODO Implement this method
    }

    @Override
    public void save(LocationsDTO dto) throws Exception {
        // TODO Implement this method
    }

    @Override
    public String getSequenceName() {
        // TODO Implement this method
        return null;
    }
}
