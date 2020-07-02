package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 班级表
 */
@Document
public class Classes {

	/**
	 * 班级表id(主键)
	 */
	@Id
	private String claId;
	
	/**
	 * 班级表
	 */
	private String claName;
	
	/**
	 * 所属专业
	 */
	@DBRef
	private Major mId;

	public String getClaId() {
		return claId;
	}

	public void setClaId(String claId) {
		this.claId = claId;
	}

	public String getClaName() {
		return claName;
	}

	public void setClaName(String claName) {
		this.claName = claName;
	}
	

	public Major getmId() {
		return mId;
	}

	public void setmId(Major mId) {
		this.mId = mId;
	}

	@Override
	public String toString() {
		return "Classes [claId=" + claId + ", claName=" + claName + ", mId=" + mId + "]";
	}
}
