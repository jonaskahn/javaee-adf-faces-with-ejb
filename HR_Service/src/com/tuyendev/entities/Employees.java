/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tuyendev
 */
@Entity
@Table(name = "EMPLOYEES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findByEmployeeId", query = "SELECT e FROM Employees e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employees.findByFirstName", query = "SELECT e FROM Employees e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email")
    , @NamedQuery(name = "Employees.findByPhoneNumber", query = "SELECT e FROM Employees e WHERE e.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Employees.findByHireDate", query = "SELECT e FROM Employees e WHERE e.hireDate = :hireDate")
    , @NamedQuery(name = "Employees.findBySalary", query = "SELECT e FROM Employees e WHERE e.salary = :salary")
    , @NamedQuery(name = "Employees.findByCommissionPct", query = "SELECT e FROM Employees e WHERE e.commissionPct = :commissionPct")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARY")
    private BigDecimal salary;
    @Column(name = "COMMISSION_PCT")
    private BigDecimal commissionPct;
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    @ManyToOne
    private Departments departmentId;
    @OneToMany(mappedBy = "managerId")
    private List<Employees> employeesList;
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employees managerId;
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")
    @ManyToOne(optional = false)
    private Jobs jobId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    private List<JobHistory> jobHistoryList;
    @OneToMany(mappedBy = "managerId")
    private List<Departments> departmentsList;

    public Employees() {
    }

    public Employees(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Employees(Integer employeeId, String lastName, String email, Date hireDate) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
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

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        this.departmentId = departmentId;
    }

    @XmlTransient
    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    public Employees getManagerId() {
        return managerId;
    }

    public void setManagerId(Employees managerId) {
        this.managerId = managerId;
    }

    public Jobs getJobId() {
        return jobId;
    }

    public void setJobId(Jobs jobId) {
        this.jobId = jobId;
    }

    @XmlTransient
    public List<JobHistory> getJobHistoryList() {
        return jobHistoryList;
    }

    public void setJobHistoryList(List<JobHistory> jobHistoryList) {
        this.jobHistoryList = jobHistoryList;
    }

    @XmlTransient
    public List<Departments> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Departments> departmentsList) {
        this.departmentsList = departmentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tuyendev.entities.Employees[ employeeId=" + employeeId + " ]";
    }
    
}
