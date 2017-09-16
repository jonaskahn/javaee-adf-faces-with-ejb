package com.tuyendev.dto;

import java.io.Serializable;

import java.util.*;

public class DepartmentsDTO implements Serializable {

    //VARIABLES
    private String departmentName;
    private List<JobHistoryDTO> jobHistoryList;
    private List<EmployeesDTO> employeesList;
    private LocationsDTO locationId;
    private Short departmentId;
    private EmployeesDTO managerId;

    //GETTER-SETTER
    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public LocationsDTO getLocationId() {
        return this.locationId;
    }

    public void setLocationId(LocationsDTO locationId) {
        this.locationId = locationId;
    }

    public Short getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Short departmentId) {
        this.departmentId = departmentId;
    }

    public EmployeesDTO getManagerId() {
        return this.managerId;
    }

    public void setManagerId(EmployeesDTO managerId) {
        this.managerId = managerId;
    }

}
