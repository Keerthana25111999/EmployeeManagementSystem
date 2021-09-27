package com.datarest.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="depart_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int departId;
	@Column(name="dept_name")
	private String departName;
	
	public Department(int departId, String departName) {

		this.departId=departId;
		this.departName=departName;
	}
	
	@OneToOne(mappedBy="department")
	public int getDepartId() {
		return departId;
	}
	public void setDepartId(int departId) {
		this.departId = departId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	
	

}
