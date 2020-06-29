package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Department {

	@Id
	int depID;
	
	String depName;
	
	String  depEnabled;

	public int getDepID() {
		return depID;
	}

	public void setDepID(int depID) {
		this.depID = depID;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepEnabled() {
		return depEnabled;
	}

	public void setDepEnabled(String depEnabled) {
		this.depEnabled = depEnabled;
	}
	
	
}
