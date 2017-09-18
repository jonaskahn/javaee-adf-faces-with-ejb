package com.tuyendev.dto;

import java.io.Serializable;

import com.tuyendev.fw.BaseDTO;

import java.util.*;

public class JobHistoryDTO extends BaseDTO implements Serializable {

    //VARIABLES
    private JobsDTO jobId;
    private JobHistoryPKDTO jobHistoryPK;
    private Date endDate;
    private DepartmentsDTO departmentId;
    private EmployeesDTO employees;

    //GETTER-SETTER
    public JobsDTO getJobId() {
        return this.jobId;
    }

    public void setJobId(JobsDTO jobId) {
        this.jobId = jobId;
    }

    public JobHistoryPKDTO getJobHistoryPK() {
        return this.jobHistoryPK;
    }

    public void setJobHistoryPK(JobHistoryPKDTO jobHistoryPK) {
        this.jobHistoryPK = jobHistoryPK;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public DepartmentsDTO getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(DepartmentsDTO departmentId) {
        this.departmentId = departmentId;
    }

    public EmployeesDTO getEmployees() {
        return this.employees;
    }

    public void setEmployees(EmployeesDTO employees) {
        this.employees = employees;
    }

}
