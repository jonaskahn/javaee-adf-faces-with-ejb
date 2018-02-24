/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.base.BaseFacade;
import com.tuyendev.common.Constant;
import com.tuyendev.dto.CountriesDTO;
import com.tuyendev.mapper.AdvanceMapper;
import com.tuyendev.remote.CountriesFacadeRemote;
import com.tuyendev.local.CountriesFacadeLocal;
import com.tuyendev.entities.Countries;
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
                     .COUNTRIES_FACADE,mappedName = com.tuyendev
                                                        .common
                                                        .Constant
                                                        .EJB_MAPPED_NAME
                                                        .COUNTRIES_FACADE)
public class CountriesFacade extends BaseFacade<Countries,CountriesDTO> implements CountriesFacadeLocal, CountriesFacadeRemote {

    @PersistenceContext(unitName = "HR_Service")
    private EntityManager em;
    
    private final AdvanceMapper mapper = new AdvanceMapper<Countries,CountriesDTO>(Countries.class, CountriesDTO.class);

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountriesFacade() {
        super(Countries.class,CountriesDTO.class);
    }

    @Override
    protected AdvanceMapper getMapper() {
        return mapper;
    }

    @Override
    public void create(Countries entity) throws Exception {
        // TODO Implement this method
    }

    @Override
    public void save(CountriesDTO dto) throws Exception {
        // TODO Implement this method
    }

    @Override
    public String getSequenceName() {
        // TODO Implement this method
        return null;
    }
}
