package com.tuyendev.dto;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

public class EmployeesDTO implements Serializable {

	//VARIABLES
	private String lastName;
	private Date hireDate;
	private List<EmployeesDTO> employeesList;
	private DepartmentsDTO departmentId;
	private Integer employeeId;
	private EmployeesDTO managerId;
	private BigDecimal salary;
	private BigDecimal commissionPct;
	private String firstName;
	private JobsDTO jobId;
	private List<JobHistoryDTO> jobHistoryList;
	private String phoneNumber;
	private List<DepartmentsDTO> departmentsList;
	private String email;

	//GETTER-SETTER
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public List<EmployeesDTO> getEmployeesList() {
		return this.employeesList;
	}

	public void setEmployeesList(List<EmployeesDTO> employeesList) {
		this.employeesList = employeesList;
	}

	public DepartmentsDTO getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(DepartmentsDTO departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeesDTO getManagerId() {
		return this.managerId;
	}

	public void setManagerId(EmployeesDTO managerId) {
		this.managerId = managerId;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public JobsDTO getJobId() {
		return this.jobId;
	}

	public void setJobId(JobsDTO jobId) {
		this.jobId = jobId;
	}

	public List<JobHistoryDTO> getJobHistoryList() {
		return this.jobHistoryList;
	}

	public void setJobHistoryList(List<JobHistoryDTO> jobHistoryList) {
		this.jobHistoryList = jobHistoryList;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<DepartmentsDTO> getDepartmentsList() {
		return this.departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsDTO> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
