package com.datarest.entities;

import java.io.Serializable;
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
@Table(name="employee")
//@NamedQuery(name="Employee.findByUser", query="select distinct emp from Employee emp join fetch emp.user")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private LocalDate dob;
	private String email;
		
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="depart_id")
	private Department department;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Employee(int userId, String firstName, String lastName, String string, String email, String string1) {
		
		this.userId=userId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=dob;
		this.email=email;
		this.department=department;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	/*@JsonIgnore
	public Set<User> getUser() {
		return user;
	}
	
	public void setUser(Set<User> user) {
		
		this.user = user;
		for(User users : user)
		{
			users.setEmployee(this);
		}
	}*/
	

	

}
