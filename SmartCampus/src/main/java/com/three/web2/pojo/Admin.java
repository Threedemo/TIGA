package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 教务信息表
 */
@Document
public class Admin {

	@Id
	int adminId;
	
	//教务账号
	@DBRef
	Login loginName;
	
	//姓名
	String admName;
	
	//性别
	String admSex;
	
	//年龄
	int Age;
	
	//身份证
	String admIdNum;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public Login getLoginName() {
		return loginName;
	}

	public void setLoginName(Login loginName) {
		this.loginName = loginName;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public String getAdmSex() {
		return admSex;
	}

	public void setAdmSex(String admSex) {
		this.admSex = admSex;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getAdmIdNum() {
		return admIdNum;
	}

	public void setAdmIdNum(String admIdNum) {
		this.admIdNum = admIdNum;
	}
	
	//toString 
	
	
}
