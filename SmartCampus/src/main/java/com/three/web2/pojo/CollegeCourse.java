package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 院系选课表(每个院系的选课)
 */
@Document
public class CollegeCourse {

	@Id
	int depXkId;
	
	//选课表外键
	@DBRef
	XuanKe xkId;
	
	//院系
	@DBRef
	Department depId;

	public int getDepXkId() {
		return depXkId;
	}

	public void setDepXkId(int depXkId) {
		this.depXkId = depXkId;
	}

	public XuanKe getXkId() {
		return xkId;
	}

	public void setXkId(XuanKe xkId) {
		this.xkId = xkId;
	}

	public Department getDepId() {
		return depId;
	}

	public void setDepId(Department depId) {
		this.depId = depId;
	}

	@Override
	public String toString() {
		return "Collegecourse [depXkId=" + depXkId + ", xkId=" + xkId + ", depId=" + depId + "]";
	}
	
	
}
