package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Zhou {

	@Id
	int zhouId;
	
	
	String zhouName;

	public int getZhouId() {
		return zhouId;
	}

	public void setZhouId(int zhouId) {
		this.zhouId = zhouId;
	}

	public String getZhouName() {
		return zhouName;
	}

	public void setZhouName(String zhouName) {
		this.zhouName = zhouName;
	}

	@Override
	public String toString() {
		return "Zhou [zhouId=" + zhouId + ", zhouName=" + zhouName + "]";
	}
	
	
}
