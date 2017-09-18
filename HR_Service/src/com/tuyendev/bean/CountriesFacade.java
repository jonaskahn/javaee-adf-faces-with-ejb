/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.tuyendev.base.BaseFacade;
import com.tuyendev.common.ServiceName;
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
@Stateless(name = ServiceName.EJB_NAME.COUNTRIES_FACADE,mappedName = ServiceName.EJB_MAPPED_NAME.COUNTRIES_FACADE)
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
}
