/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.bean;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.tuyendev.base.BaseFacade;
import com.tuyendev.common.Constant;
import com.tuyendev.dto.RegionsDTO;
import com.tuyendev.local.RegionsFacadeLocal;
import com.tuyendev.entities.Regions;

import com.tuyendev.fw.DataUtil;
import com.tuyendev.mapper.AdvanceMapper;

import java.math.BigDecimal;

import java.util.Collections;
import java.util.List;

import java.util.Map;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tuyendev
 */
@Stateless(name = com.tuyendev
                     .common
                     .Constant
                     .EJB_NAME
                     .REGIONS_FACADE, mappedName = com.tuyendev
                                                      .common
                                                      .Constant
                                                      .EJB_MAPPED_NAME
                                                      .REGIONS_FACADE)
public class RegionsFacade extends BaseFacade<Regions, RegionsDTO> implements RegionsFacadeLocal,
                                                                              com.tuyendev.remote.RegionsFacadeRemote {

    @PersistenceContext(unitName = "HR_Service")
    private EntityManager em;

    private final AdvanceMapper<Regions, RegionsDTO> mapper = new AdvanceMapper<Regions, RegionsDTO>(Regions.class, RegionsDTO.class);

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegionsFacade() {
        super(Regions.class, RegionsDTO.class);
    }

    @Override
    protected AdvanceMapper getMapper() {
        return mapper;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RegionsDTO> findByCondition(RegionsDTO searchDTO) throws Exception {

        StringBuilder sql = new StringBuilder().append("SELECT re FROM Regions re WHERE 1 = 1 ");
        Map<String, Object> params = Maps.newHashMap();
        if (!DataUtil.isNullObject(searchDTO.getRegionId())) {
            sql.append(" AND re.regionId = :regionId ");
            params.put("regionId", searchDTO.getRegionId());
        }
        if (!DataUtil.isNullObject(searchDTO.getRegionName())) {
            sql.append(" AND UPPER(re.regionName) LIKE :regionName ");
            params.put("regionName", "%" + searchDTO.getRegionName().toUpperCase() + "%");
        }
        Query query = em.createQuery(sql.toString(), Regions.class);
        params.forEach(query::setParameter);
        List lst = query.getResultList();
        return lst == null ? Lists.newArrayList() : getMapper().entityToDTO(lst);
    }


    @Override
    public void doCreateOrUpdate(RegionsDTO searchDTO) throws Exception {
        // TODO Implement this method
        if(DataUtil.isNullOrZero(searchDTO.getRegionId())){
            save(searchDTO);
        }else {
            update(searchDTO);
        }
    }

    @Override
    public void create(Regions entity) throws Exception {
        // TODO Implement this method
        BigDecimal id = (BigDecimal)getNextId();
        entity.setRegionId(id);
        em.persist(entity);
    }

    @Override
    public void save(RegionsDTO dto) throws Exception {
        create(mapper.dtoToEntity(dto));
    }

    @Override
    public String getSequenceName() {
        return Constant.SEQUENCE_NAME.REGIONS_SEQ;
    }

    @Override
    public String doDelete(List<RegionsDTO> dtos) throws Exception {
        List<String> regName = Lists.newArrayList();
        for(RegionsDTO dto :dtos) {
            delete(dto);
            regName.add(dto.getRegionName());
        } 
        return Joiner.on(", ").join(regName);
    }
}
