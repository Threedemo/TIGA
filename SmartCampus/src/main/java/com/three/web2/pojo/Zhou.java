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

	/**
	 * 周表id(主键)
	 */
	@Id
	private String zhouId;
	
	/**
	 * 第几周
	 */
	private String zhouName;


	public String getZhouId() {
		return zhouId;
	}

	public void setZhouId(String zhouId) {
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
