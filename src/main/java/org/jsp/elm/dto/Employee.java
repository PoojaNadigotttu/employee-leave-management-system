package org.jsp.elm.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private String department;
	private String role;
	private int leaveBalance;
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(mappedBy="employee")
	@JsonIgnore
	private List<Leave> leaveRequest;
	public List<Leave> getLeaveRequest() {
		return leaveRequest;
	}
	public void setLeaveRequest(List<Leave> leaveRequest) {
		this.leaveRequest = leaveRequest;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getLeaveBalance() {
		return leaveBalance;
	}
	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", role=" + role
				+ ", leaveBalance=" + leaveBalance + ", email=" + email + ", password=" + password + ", leaveRequest="
				+ leaveRequest + "]";
	}
	
	

}
