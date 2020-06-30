package com.three.web2.pojo;

import java.sql.Date;

/**
 * 学生信息表
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 学生基本信息
 */
@Document
public class Student {

	@Id
	String stuid;
	
	//账号(学号)
	@DBRef
	Login loginName;
	
	//学生姓名
	String stuName;
	
	//学生性别
	String stuSex;
	
	//学生年龄
	int stuAge;
	
	//学生身份证号
	String stuIdNum;
	
	//学生名族
	String stuNation;
	
	//家庭地址
	String stuAddress;
	
	//联系电话
	String stuPhone;
	
	//入学时间
	String stuStart;
	
	//毕业时间
	String stuStop;
	
	//班级
	@DBRef
	Class claId;

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

	public Class getClaId() {
		return claId;
	}

	public void setSlaId(Class claId) {
		this.claId = claId;
	}

	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", loginName=" + loginName + ", stuName=" + stuName + ", stuSex=" + stuSex
				+ ", stuAge=" + stuAge + ", stuIdNum=" + stuIdNum + ", stuNation=" + stuNation + ", stuAddress="
				+ stuAddress + ", stuPhone=" + stuPhone + ", stuStart=" + stuStart + ", stuStop=" + stuStop + ", claId="
				+ claId + "]";
	}
	
	
	
}
