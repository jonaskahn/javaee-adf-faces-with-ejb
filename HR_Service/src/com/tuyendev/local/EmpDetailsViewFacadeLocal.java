/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.local;

import com.tuyendev.dto.EmpDetailsViewDTO;
import com.tuyendev.entities.EmpDetailsView;
import com.tuyendev.base.BaseService;
import javax.ejb.Local;

/**
 *
 * @author tuyendev
 */
@Local
public interface EmpDetailsViewFacadeLocal extends BaseService<EmpDetailsView,EmpDetailsViewDTO>{    
}
