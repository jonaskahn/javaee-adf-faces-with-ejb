/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.inf;

import com.tuyendev.entities.JobHistory;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Tuyen Nguyen
 */
@Remote
public interface JobHistoryFacadeRemote {

    void create(JobHistory jobHistory);

    void edit(JobHistory jobHistory);

    void remove(JobHistory jobHistory);

    JobHistory find(Object id);

    List<JobHistory> findAll();

    List<JobHistory> findRange(int[] range);

    int count();
    
}
