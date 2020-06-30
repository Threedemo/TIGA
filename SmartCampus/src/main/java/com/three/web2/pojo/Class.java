package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 教室表
 */
@Document
public class Class {

	@Id
	private String claID;
	
	//班级表
	private String claName;
	
	//所属院系
	@DBRef
	private Department depid;



	public String getClaID() {
		return claID;
	}

	public void setClaID(String claID) {
		this.claID = claID;
	}

	public String getClaName() {
		return claName;
	}

	public void setClaName(String claName) {
		this.claName = claName;
	}

	public Department getDepid() {
		return depid;
	}

	public void setDepid(Department depid) {
		this.depid = depid;
	}

	
	@Override
	public String toString() {
		return "Calss [claID=" + claID + ", claName=" + claName + ", depid=" + depid + "]";
	}
	
	
	
	
}
