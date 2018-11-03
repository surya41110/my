package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dev_tab")
public class Developer {
	@Id
	@GeneratedValue
	@Column(name="dev_id")
	private Integer devId;
	@Column(name="dev_name")
	private String devName;
	@Column(name="dev_code")
	private String devCode;
	@Column(name="dev_salary")
	private double salary;
	@ManyToOne
	@JoinColumn(name="projidfk")
	private Project project;
	public Developer() {
		super();
	}
	public Developer(Integer devId) {
		super();
		this.devId = devId;
	}
	public Developer(Integer devId, String devName, String devCode, double salary, Project project) {
		super();
		this.devId = devId;
		this.devName = devName;
		this.devCode = devCode;
		this.salary = salary;
		this.project = project;
	}
	@Override
	public String toString() {
		return "Developer [devId=" + devId + ", devName=" + devName + ", devCode=" + devCode + ", salary=" + salary
				+ ", project=" + project + "]";
	}
	public Integer getDevId() {
		return devId;
	}
	public void setDevId(Integer devId) {
		this.devId = devId;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getDevCode() {
		return devCode;
	}
	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	

}
