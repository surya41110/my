package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project_tab")
public class Project {
	@Id
	@GeneratedValue
	@Column(name="proj_id")
	private Integer projId;
	@Column(name="proj_code")
	private String projCode;
	@Column(name="proj_name")
	private String projName;
	@Column(name="proj_dept")
	private String projDept;
	@Column(name="proj_note")
	private String projNote;
	
	
	
	public Project(Integer projId) {
		super();
		this.projId = projId;
	}



	public Project() {
	}



	public Project(Integer projId, String projCode, String projName, String projDept, String projNote) {
		super();
		this.projId = projId;
		this.projCode = projCode;
		this.projName = projName;
		this.projDept = projDept;
		this.projNote = projNote;
	}



	public Integer getProjId() {
		return projId;
	}



	public void setProjId(Integer projId) {
		this.projId = projId;
	}



	public String getProjCode() {
		return projCode;
	}



	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}



	public String getProjName() {
		return projName;
	}



	public void setProjName(String projName) {
		this.projName = projName;
	}



	public String getProjDept() {
		return projDept;
	}



	public void setProjDept(String projDept) {
		this.projDept = projDept;
	}



	public String getProjNote() {
		return projNote;
	}



	public void setProjNote(String projNote) {
		this.projNote = projNote;
	}
	

}
