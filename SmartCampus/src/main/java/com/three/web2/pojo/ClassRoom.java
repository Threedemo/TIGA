package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClassRoom {

	@Id
	int classHomeId;
	
	String classHomeName;

	public int getClassHomeId() {
		return classHomeId;
	}

	public void setClassHomeId(int classHomeId) {
		this.classHomeId = classHomeId;
	}

	public String getClassHomeName() {
		return classHomeName;
	}

	public void setClassHomeName(String classHomeName) {
		this.classHomeName = classHomeName;
	}

	@Override
	public String toString() {
		return "ClassRoom [classHomeId=" + classHomeId + ", classHomeName=" + classHomeName + "]";
	}
	
	
	
}
