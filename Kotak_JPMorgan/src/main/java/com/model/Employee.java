package com.model;
/*
 * CREATE TABLE employees (
	emp_id INT,
	name VARCHAR(16),
	email_id VARCHAR(16),
	DOB DATE,
	gender ENUM('M','F'),
	designation VARCHAR(16),
	level VARCHAR(16),
	intervention VARCHAR(32),
	DOJ DATE,
	status ENUM('Active', 'Resigned'),
	PRIMARY KEY (emp_id)
);
 */
public class Employee {
	private int emp_id;
	private String name;
	private String email;
	private String DOB;
	private String gender;
	private String designation;
	private String level;
	private String intervention;
	private String DOJ;
	private String status;
	public Employee(int emp_id, String name, String email, String dOB, String gender, String designation, String level,
			String intervention, String dOJ, String status) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.email = email;
		DOB = dOB;
		this.gender = gender;
		this.designation = designation;
		this.level = level;
		this.intervention = intervention;
		DOJ = dOJ;
		this.status = status;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getIntervention() {
		return intervention;
	}
	public void setIntervention(String intervention) {
		this.intervention = intervention;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
