/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.local;

import com.tuyendev.entities.JobHistory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tuyen Nguyen
 */
@Local
public interface JobHistoryFacadeLocal {

    void create(JobHistory jobHistory);

    void edit(JobHistory jobHistory);

    void remove(JobHistory jobHistory);

    JobHistory find(Object id);

    List<JobHistory> findAll();

    List<JobHistory> findRange(int[] range);

    int count();
    
}
