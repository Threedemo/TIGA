package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 授课时间表
 */
@Document
public class ClassHours {

	@Id
	int classHouesId;
	
	//授课时间段
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

	@Override
	public String toString() {
		return "ClassHours [classHouesId=" + classHouesId + ", classHoursName=" + classHoursName + "]";
	}
	
	
}
