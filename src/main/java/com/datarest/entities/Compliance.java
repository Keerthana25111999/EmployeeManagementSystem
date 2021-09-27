package com.datarest.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="compliance")
public class Compliance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="compliance_id")
	private int complianceId;
	@Column(name="rl_type")
	private String rlType;
	private String details;
	@Column(name="create_date")
	private LocalDate createDate;
	@Column(name="emp_count")
	private int empCount;
	@Column(name="sts_count")
	private int stsCount;
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="depart_id")
	private Department department;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="status_id")
	private StatusReport statusreport;
	

	public Compliance(int complianceId, String rlType, String details, String string, int empCount, int ststCount, String status) {
	
		this.complianceId=complianceId;
		this.rlType=rlType;
		this.details=details;
		this.createDate=createDate;
		this.empCount=empCount;
		this.stsCount=stsCount;
		this.status=status;	
		
	}
	
	public int getComplianceId() {
		return complianceId;
	}
	public void setComplianceId(int complianceId) {
		this.complianceId = complianceId;
	}
	public String getRlType() {
		return rlType;
	}
	public void setRlType(String rlType) {
		this.rlType = rlType;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getEmpCount() {
		return empCount;
	}
	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}
	public int getStsCount() {
		return stsCount;
	}
	public void setStsCount(int stsCount) {
		this.stsCount = stsCount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
