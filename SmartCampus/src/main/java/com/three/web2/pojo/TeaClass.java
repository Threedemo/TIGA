package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 教室班级表
 */
@Document
public class TeaClass {

	/**
	 * 教室班级表id(主键)
	 */
	@Id
	private String teaClassId;
	
	/**
	 * 老师id
	 */
	@DBRef
	private Teacher teaId;
	
	/**
	 * 班级id
	 */
	@DBRef
	private Classes claId;

	
	public String getTeaClassId() {
		return teaClassId;
	}

	public void setTeaClassId(String teaClassId) {
		this.teaClassId = teaClassId;
	}

	public Teacher getTeaId() {
		return teaId;
	}

	public void setTeaId(Teacher teaId) {
		this.teaId = teaId;
	}

	public Classes getClaId() {
		return claId;
	}

	public void setClaId(Classes claId) {
		this.claId = claId;
	}

	@Override
	public String toString() {
		return "TeaClass [teaClassId=" + teaClassId + ", teaId=" + teaId + ", claId=" + claId + "]";
	}
	
	
	
	
	
}
