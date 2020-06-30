package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 院系表
 */
@Document
public class Department {

	/**
	 * 院系表
	 */
	@Id
	private String depId;
	
	/**
	 * 院系名称
	 */
	private String depName;
	
	/**
	 * 是否开启选课状态
	 */
	private String  depEnabled;
	
	

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
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
		return "Department [depId=" + depId + ", depName=" + depName + ", depEnabled=" + depEnabled + "]";
	}
	
	
}
