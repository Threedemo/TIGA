package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 院系表
 */
@Document
public class Department {

	@Id
	int depID;
	
	//院系名称
	String depName;
	
	//是否开启选课状态
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

	@Override
	public String toString() {
		return "Department [depID=" + depID + ", depName=" + depName + ", depEnabled=" + depEnabled + "]";
	}
	
	
}
