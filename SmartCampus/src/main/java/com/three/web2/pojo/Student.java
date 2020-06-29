package com.three.web2.pojo;

import java.sql.Date;

/**
 * 学生信息表
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {

	@Id
	String stuid;
	
	@DBRef
	Login loginName;
	
	String stuName;
	
	String stuSex;
	
	int stuAge;
	
	String stuIdNum;
	
	String stuNation;
	
	String stuAddress;
	
	String stuPhone;
	
	//入学时间
	String stuStart;
	
	//毕业时间
	String stuStop;
	
	@DBRef
	Calss claId;

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public Login getLoginName() {
		return loginName;
	}

	public void setLoginName(Login loginName) {
		this.loginName = loginName;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getStuIdNum() {
		return stuIdNum;
	}

	public void setStuIdNum(String stuIdNum) {
		this.stuIdNum = stuIdNum;
	}

	public String getStuNation() {
		return stuNation;
	}

	public void setStuNation(String stuNation) {
		this.stuNation = stuNation;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public String getStuPhone() {
		return stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuStart() {
		return stuStart;
	}

	public void setStuStart(String stuStart) {
		this.stuStart = stuStart;
	}

	public String getStuStop() {
		return stuStop;
	}

	public void setStuStop(String stuStop) {
		this.stuStop = stuStop;
	}

	public Calss getClaId() {
		return claId;
	}

	public void setSlaId(Calss claId) {
		this.claId = claId;
	}
	
	
	
}
