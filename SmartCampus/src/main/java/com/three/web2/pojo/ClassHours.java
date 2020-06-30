package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 授课时间表
 */
@Document
public class ClassHours {

	/**
	 * 授课时间段id(主键)
	 */
	@Id
	private String classHouesId;
	
	/**
	 * 授课时间段
	 */
	private String classHoursName;

	

	public String getClassHouesId() {
		return classHouesId;
	}

	public void setClassHouesId(String classHouesId) {
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
