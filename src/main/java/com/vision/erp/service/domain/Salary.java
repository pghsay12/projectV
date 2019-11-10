package com.vision.erp.service.domain;

public class Salary {

	public Salary() {
		super();
	}
	
	private String salaryNumbering;
	private String salaryDate;
	private String employeeNo;
	private String employeeName;
	private String individualTotalSalary;
	private String salaryStatusCodeNo;
	private String salaryStatusCodeName;
	private String wage;
	private String totalRegularWorkTime;
	private String totalExtendWorkTime;
	private String employeeEmail;
	private String rankCodeName;
	private String departCodeName;
	
	public String getSalaryNumbering() {
		return salaryNumbering;
	}
	public void setSalaryNumbering(String salaryNumbering) {
		this.salaryNumbering = salaryNumbering;
	}
	public String getSalaryDate() {
		return salaryDate;
	}
	public void setSalaryDate(String salaryDate) {
		this.salaryDate = salaryDate;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getIndividualTotalSalary() {
		return individualTotalSalary;
	}
	public void setIndividualTotalSalary(String individualTotalSalary) {
		this.individualTotalSalary = individualTotalSalary;
	}
	public String getSalaryStatusCodeNo() {
		return salaryStatusCodeNo;
	}
	public void setSalaryStatusCodeNo(String salaryStatusCodeNo) {
		this.salaryStatusCodeNo = salaryStatusCodeNo;
	}
	public String getSalaryStatusCodeName() {
		return salaryStatusCodeName;
	}
	public void setSalaryStatusCodeName(String salaryStatusCodeName) {
		this.salaryStatusCodeName = salaryStatusCodeName;
	}
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
	}
	public String getTotalRegularWorkTime() {
		return totalRegularWorkTime;
	}
	public void setTotalRegularWorkTime(String totalRegularWorkTime) {
		this.totalRegularWorkTime = totalRegularWorkTime;
	}
	public String getTotalExtendWorkTime() {
		return totalExtendWorkTime;
	}
	public void setTotalExtendWorkTime(String totalExtendWorkTime) {
		this.totalExtendWorkTime = totalExtendWorkTime;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getRankCodeName() {
		return rankCodeName;
	}
	public void setRankCodeName(String rankCodeName) {
		this.rankCodeName = rankCodeName;
	}
	public String getDepartCodeName() {
		return departCodeName;
	}
	public void setDepartCodeName(String departCodeName) {
		this.departCodeName = departCodeName;
	}
	
	@Override
	public String toString() {
		return "Salary [salaryNumbering=" + salaryNumbering + ", salaryDate=" + salaryDate + ", employeeNo="
				+ employeeNo + ", employeeName=" + employeeName + ", individualTotalSalary=" + individualTotalSalary
				+ ", salaryStatusCodeNo=" + salaryStatusCodeNo + ", salaryStatusCodeName=" + salaryStatusCodeName
				+ ", wage=" + wage + ", totalRegularWorkTime=" + totalRegularWorkTime + ", totalExtendWorkTime="
				+ totalExtendWorkTime + ", employeeEmail=" + employeeEmail + ", rankCodeName=" + rankCodeName
				+ ", departCodeName=" + departCodeName + "]";
	}

}
