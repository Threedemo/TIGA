package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 周表
 * @author Sqi
 * @version 2020年6月29日 下午9:41:07
 */
@Document
public class Zhou {

	@Id
	int zhouId;
	
	//第几周
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
