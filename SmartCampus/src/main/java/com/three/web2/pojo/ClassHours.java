package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClassHours {

	@Id
	int classHouesId;
	
	String classHoursName;

	public int getClassHouesId() {
		return classHouesId;
	}

	public void setClassHouesId(int classHouesId) {
		this.classHouesId = classHouesId;
	}

	public String getClassHoursName() {
		return classHoursName;
	}

	public void setClassHoursName(String classHoursName) {
		this.classHoursName = classHoursName;
	}
	
	
}
