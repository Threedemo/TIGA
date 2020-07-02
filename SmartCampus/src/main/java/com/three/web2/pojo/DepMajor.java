package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DepMajor {

	@Id
	private String id;
	
	@DBRef
	private Department depId;
	
	@DBRef
	private Major mId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Department getDepId() {
		return depId;
	}

	public void setDepId(Department depId) {
		this.depId = depId;
	}

	public Major getmId() {
		return mId;
	}

	public void setmId(Major mId) {
		this.mId = mId;
	}

	@Override
	public String toString() {
		return "DepMajor [id=" + id + ", depId=" + depId + ", mId=" + mId + "]";
	}
}
