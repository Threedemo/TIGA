package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 学期表
 */
@Document
public class Semester {

	/**
	 * 学期表id(主键)
	 */
	@Id
	private String semesterId;
	
	/**
	 * 第几学期
	 */
	private String semesterName;

	

	public String getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(String semesterId) {
		this.semesterId = semesterId;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	@Override
	public String toString() {
		return "Semester [semesterId=" + semesterId + ", semesterName=" + semesterName + "]";
	}
	
	
}
