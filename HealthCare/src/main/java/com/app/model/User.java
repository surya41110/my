package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usertab")
public class User implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="userid")
	private Integer userId;
	@Column(name="userName")
	private String userName;
	@Column(name="userEmail")
	private String userEmail;
	@Column(name="userContact")
	private String userContact;
	@Column(name="userpassword")
	private String userPwd;
	@Column(name="userAddress")
	private String userAddr;

	public User(Integer userId) {
		this.userId = userId;
	}

	public User() {
		//no ops
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public User(Integer userId, String userName, String userEmail, String userContact, String userPwd,
			String userAddr) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userPwd = userPwd;
		this.userAddr = userAddr;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userContact="
				+ userContact + ", userPwd=" + userPwd + ", userAddr=" + userAddr + "]";
	}
	
	

}
