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

	/**
	 * 学生信息表id(主键)
	 */
	@Id
	private String stuid;
	
	/**
	 * 账号(学号)
	 */
	private String loginName;
	
	/**
	 * 学生姓名
	 */
	private String stuName;
	
	/**
	 * 学生性别
	 */
	private String stuSex;
	
	/**
	 * 学生年龄
	 */
	private int stuAge;
	
	/**
	 * 学生身份证号
	 */
	private String stuIdNum;
	
	/**
	 * 学生名族
	 */
	private String stuNation;
	
	/**
	 * 家庭地址
	 */
	private String stuAddress;
	
	/**
	 * 联系电话
	 */
	private String stuPhone;
	
	/**
	 * 入学时间
	 */
	private String stuStart;
	
	/**
	 * 毕业时间
	 */
	private String stuStop;
	
	/**
	 * 班级
	 */
	@DBRef
	private Class claId;

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setClaId(Class claId) {
		this.claId = claId;
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
