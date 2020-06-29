package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Collegecourse {

	@Id
	int depXkId;
	
	@DBRef
	XuanKe xkId;
	
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
	
	
}
