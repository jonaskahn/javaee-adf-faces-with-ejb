/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.local;

import com.tuyendev.base.BaseService;
import com.tuyendev.dto.CountriesDTO;
import com.tuyendev.entities.Countries;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyendev
 */
@Local
public interface CountriesFacadeLocal extends BaseService<Countries,CountriesDTO> {

}
