/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.remote;

import com.tuyendev.base.BaseService;
import com.tuyendev.dto.JobsDTO;
import com.tuyendev.entities.Jobs;

import java.util.List;

import javax.ejb.Remote;

/**
 *
 * @author tuyendev
 */
@Remote
public interface JobsFacadeRemote extends BaseService<Jobs, JobsDTO> {
}
