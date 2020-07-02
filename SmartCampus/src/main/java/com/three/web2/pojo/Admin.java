package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 教务信息表
 */
@Document
public class Admin {


	
	/**
	 * 教务账号
	 * 教务表id(主键)
	 */
    @Id
	private	String loginName;
	
	/**
	 * 姓名
	 */
	private String admName;
	
	/**
	 * 性别
	 */
	private String admSex;
	
	/**
	 * 年龄
	 */
	private int Age;
	
	/**
	 * 身份证
	 */
	private String admIdNum;

	



	

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
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
	@Override
	public String toString() {
		return "Admin [loginName=" + loginName + ", admName=" + admName + ", admSex=" + admSex
				+ ", Age=" + Age + ", admIdNum=" + admIdNum + "]";
	}
	
	
	
}
