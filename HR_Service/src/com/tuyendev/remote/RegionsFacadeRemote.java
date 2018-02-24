/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.remote;

import com.tuyendev.base.BaseService;
import com.tuyendev.dto.RegionsDTO;
import com.tuyendev.entities.Regions;

import java.util.List;

import javax.ejb.Remote;

/**
 *
 * @author tuyendev
 */
@Remote
public interface RegionsFacadeRemote extends BaseService<Regions, RegionsDTO> {
    public List<RegionsDTO> findByCondition(RegionsDTO searchDTO) throws Exception;
    
    public void doCreateOrUpdate(RegionsDTO searchDTO) throws Exception;
    
    public String doDelete(List<RegionsDTO> dtos) throws Exception;
}
