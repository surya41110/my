package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="employeetab")
public class Employee {
	@Id
	@Column(name="empId")
	@GeneratedValue
	private Integer empId;
	@Column(name="Name")
	private String empName;
	@Column(name="Gender")
	private String empGen;
	@Column(name="Addrs")
	private String empAddr;
	@Column(name="cntry")
	private String empCntry;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="emplangs",joinColumns=@JoinColumn(name="empId"))
	@OrderColumn(name="pos")
	@Column(name="data")
	private List<String> empLangs;
	
	
	//1 param constructor
	public Employee(Integer empId) {
		super();
		this.empId = empId;
	}


	//0 param constructor
	public Employee() {
		super();
	}

	
	//all parameter constructor
	public Employee(Integer empId, String empName, String empGen, String empAddr, String empCntry,
			List<String> empLangs) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empGen = empGen;
		this.empAddr = empAddr;
		this.empCntry = empCntry;
		this.empLangs = empLangs;
	}


	//setters & getters
	
	public Integer getEmpId() {
		return empId;
	}


	public void setEmpId(Integer empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpGen() {
		return empGen;
	}


	public void setEmpGen(String empGen) {
		this.empGen = empGen;
	}


	public String getEmpAddr() {
		return empAddr;
	}


	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}


	public String getEmpCntry() {
		return empCntry;
	}


	public void setEmpCntry(String empCntry) {
		this.empCntry = empCntry;
	}


	public List<String> getEmpLangs() {
		return empLangs;
	}


	public void setEmpLangs(List<String> empLangs) {
		this.empLangs = empLangs;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empGen=" + empGen + ", empAddr=" + empAddr
				+ ", empCntry=" + empCntry + ", empLangs=" + empLangs + "]";
	}
	
	

}//class
