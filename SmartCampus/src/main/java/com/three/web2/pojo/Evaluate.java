package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Evaluate {

	@Id
	private String evaluateId;
	
	//教师
	@DBRef
	private Teacher teald;
	
	//学生
	@DBRef
	private Student stuId;
	
	//评价内容
	private String evaluateContent;

	

	public String getEvaluateId() {
		return evaluateId;
	}

	public void setEvaluateId(String evaluateId) {
		this.evaluateId = evaluateId;
	}

	public Teacher getTeald() {
		return teald;
	}

	public void setTeald(Teacher teald) {
		this.teald = teald;
	}

	public Student getStuId() {
		return stuId;
	}

	public void setStuId(Student stuId) {
		this.stuId = stuId;
	}

	public String getEvaluateContent() {
	
		return evaluateContent;
	}

	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}

	@Override
	public String toString() {
		return "Evaluate [evaluateId=" + evaluateId + ", teald=" + teald + ", evaluateContent=" + evaluateContent + "]";
	}
	
	
}
