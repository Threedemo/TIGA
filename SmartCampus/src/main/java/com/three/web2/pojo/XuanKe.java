package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 *选课表
 */
@Document
public class XuanKe {

	@Id
	int xkId;
	
	//选修课名
	String xkName;
	
	//第几学期
	@DBRef
	Semester semesterId;
	
	//教务是否启用选课
	String enabled;

	public int getXkId() {
		return xkId;
	}

	public void setXkId(int xkId) {
		this.xkId = xkId;
	}

	public String getXkName() {
		return xkName;
	}

	public void setXkName(String xkName) {
		this.xkName = xkName;
	}

	public Semester getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(Semester semesterId) {
		this.semesterId = semesterId;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "XuanKe [xkId=" + xkId + ", xkName=" + xkName + ", semesterId=" + semesterId + ", enabled=" + enabled
				+ "]";
	}
	
	
}
