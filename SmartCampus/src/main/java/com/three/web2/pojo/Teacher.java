package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 教师信息表
 
 */
@Document
public class Teacher {

	@Id
	int teaId;
	
	//职工号
	@DBRef
	Login loginName;
	
	//老师姓名
	String teaName;
	
	//老师性别
	String teaSex;
	
	//老师年龄
	int teaAge;
	
	//老师身份证号
	String teaIdNum;
	
	//老师名族
	String teaNation;
	
	//入职时间
	String teaDate;
	
	//授课课程
	@DBRef
	Course courseId;
	
	//所属院系
	@DBRef
	Department depId;

	public int getTeaId() {
		return teaId;
	}

	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}

	public Login getLoginName() {
		return loginName;
	}

	public void setLoginName(Login loginName) {
		this.loginName = loginName;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaSex() {
		return teaSex;
	}

	public void setTeaSex(String teaSex) {
		this.teaSex = teaSex;
	}

	public int getTeaAge() {
		return teaAge;
	}

	public void setTeaAge(int teaAge) {
		this.teaAge = teaAge;
	}

	public String getTeaIdNum() {
		return teaIdNum;
	}

	public void setTeaIdNum(String teaIdNum) {
		this.teaIdNum = teaIdNum;
	}

	public String getTeaNation() {
		return teaNation;
	}

	public void setTeaNation(String teaNation) {
		this.teaNation = teaNation;
	}

	public String getTeaDate() {
		return teaDate;
	}

	public void setTeaDate(String teaDate) {
		this.teaDate = teaDate;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	public Department getDepId() {
		return depId;
	}

	public void setDepId(Department depId) {
		this.depId = depId;
	}

	@Override
	public String toString() {
		return "Teacher [teaId=" + teaId + ", loginName=" + loginName + ", teaName=" + teaName + ", teaSex=" + teaSex
				+ ", teaAge=" + teaAge + ", teaIdNum=" + teaIdNum + ", teaNation=" + teaNation + ", teaDate=" + teaDate
				+ ", courseId=" + courseId + ", depId=" + depId + "]";
	}
	
	
	
}
