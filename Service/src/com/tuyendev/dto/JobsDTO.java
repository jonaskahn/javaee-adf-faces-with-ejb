package com.tuyendev.dto;

import java.io.Serializable;

import java.util.*;

public class JobsDTO implements Serializable {

    //VARIABLES
    private String jobId;
    private Integer maxSalary;
    private List<JobHistoryDTO> jobHistoryList;
    private List<EmployeesDTO> employeesList;
    private String jobTitle;
    private Integer minSalary;

    //GETTER-SETTER
    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Integer getMaxSalary() {
        return this.maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    public List<JobHistoryDTO> getJobHistoryList() {
        return this.jobHistoryList;
    }

    public void setJobHistoryList(List<JobHistoryDTO> jobHistoryList) {
        this.jobHistoryList = jobHistoryList;
    }

    public List<EmployeesDTO> getEmployeesList() {
        return this.employeesList;
    }

    public void setEmployeesList(List<EmployeesDTO> employeesList) {
        this.employeesList = employeesList;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getMinSalary() {
        return this.minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

}
