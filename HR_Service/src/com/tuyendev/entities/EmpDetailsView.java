/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tuyendev
 */
@Entity
@Table(name = "EMP_DETAILS_VIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpDetailsView.findAll", query = "SELECT e FROM EmpDetailsView e")
    , @NamedQuery(name = "EmpDetailsView.findByEmployeeId", query = "SELECT e FROM EmpDetailsView e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "EmpDetailsView.findByJobId", query = "SELECT e FROM EmpDetailsView e WHERE e.jobId = :jobId")
    , @NamedQuery(name = "EmpDetailsView.findByManagerId", query = "SELECT e FROM EmpDetailsView e WHERE e.managerId = :managerId")
    , @NamedQuery(name = "EmpDetailsView.findByDepartmentId", query = "SELECT e FROM EmpDetailsView e WHERE e.departmentId = :departmentId")
    , @NamedQuery(name = "EmpDetailsView.findByLocationId", query = "SELECT e FROM EmpDetailsView e WHERE e.locationId = :locationId")
    , @NamedQuery(name = "EmpDetailsView.findByCountryId", query = "SELECT e FROM EmpDetailsView e WHERE e.countryId = :countryId")
    , @NamedQuery(name = "EmpDetailsView.findByFirstName", query = "SELECT e FROM EmpDetailsView e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "EmpDetailsView.findByLastName", query = "SELECT e FROM EmpDetailsView e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "EmpDetailsView.findBySalary", query = "SELECT e FROM EmpDetailsView e WHERE e.salary = :salary")
    , @NamedQuery(name = "EmpDetailsView.findByCommissionPct", query = "SELECT e FROM EmpDetailsView e WHERE e.commissionPct = :commissionPct")
    , @NamedQuery(name = "EmpDetailsView.findByDepartmentName", query = "SELECT e FROM EmpDetailsView e WHERE e.departmentName = :departmentName")
    , @NamedQuery(name = "EmpDetailsView.findByJobTitle", query = "SELECT e FROM EmpDetailsView e WHERE e.jobTitle = :jobTitle")
    , @NamedQuery(name = "EmpDetailsView.findByCity", query = "SELECT e FROM EmpDetailsView e WHERE e.city = :city")
    , @NamedQuery(name = "EmpDetailsView.findByStateProvince", query = "SELECT e FROM EmpDetailsView e WHERE e.stateProvince = :stateProvince")
    , @NamedQuery(name = "EmpDetailsView.findByCountryName", query = "SELECT e FROM EmpDetailsView e WHERE e.countryName = :countryName")
    , @NamedQuery(name = "EmpDetailsView.findByRegionName", query = "SELECT e FROM EmpDetailsView e WHERE e.regionName = :regionName")})
public class EmpDetailsView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;
    @Id
    @Basic(optional = false)
    @Column(name = "JOB_ID")
    private String jobId;
    @Id
    @Column(name = "MANAGER_ID")
    private Integer managerId;
    @Id
    @Column(name = "DEPARTMENT_ID")
    private Short departmentId;
    @Id
    @Column(name = "LOCATION_ID")
    private Short locationId;
    @Id
    @Column(name = "COUNTRY_ID")
    private String countryId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARY")
    private BigDecimal salary;
    @Column(name = "COMMISSION_PCT")
    private BigDecimal commissionPct;
    @Basic(optional = false)
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Basic(optional = false)
    @Column(name = "JOB_TITLE")
    private String jobTitle;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE_PROVINCE")
    private String stateProvince;
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @Column(name = "REGION_NAME")
    private String regionName;

    public EmpDetailsView() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Short departmentId) {
        this.departmentId = departmentId;
    }

    public Short getLocationId() {
        return locationId;
    }

    public void setLocationId(Short locationId) {
        this.locationId = locationId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    
}
