package com.cg.furniture.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name ="my_admin_seq",sequenceName = "ADMIN_SEQ",initialValue = 7001,allocationSize = 1)
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_admin_seq")
	private Integer adminId;
	private String adminName;
	private String adminEmail;
	private String password;

	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
