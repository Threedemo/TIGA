package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TeaClass {

	@Id
	int teaClassId;
	
	@DBRef
	Teacher teaId;
	
	@DBRef
	Class claId;

	public int getTeaClassId() {
		return teaClassId;
	}

	public void setTeaClassId(int teaClassId) {
		this.teaClassId = teaClassId;
	}

	public Teacher getTeaId() {
		return teaId;
	}

	public void setTeaId(Teacher teaId) {
		this.teaId = teaId;
	}

	public Class getClaId() {
		return claId;
	}

	public void setClaId(Class claId) {
		this.claId = claId;
	}

	@Override
	public String toString() {
		return "TeaClass [teaClassId=" + teaClassId + ", teaId=" + teaId + ", claId=" + claId + "]";
	}
	
	
	
	
	
}
