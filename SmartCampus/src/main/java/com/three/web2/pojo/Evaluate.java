package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Evaluate {

	@Id
	int evaluateId;
	
	String teald;
	
	String evaluateContent;

	public int getEvaluateId() {
		return evaluateId;
	}

	public void setEvaluateId(int evaluateId) {
		this.evaluateId = evaluateId;
	}

	public String getTeald() {
		return teald;
	}

	public void setTeald(String teald) {
		this.teald = teald;
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
