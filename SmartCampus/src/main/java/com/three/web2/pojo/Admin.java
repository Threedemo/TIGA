package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 教务信息表
 */
@Document
public class Admin {
	/**
	 * 教务账号
	 * 教务表id(主键)
	 */
    @Id
	private	String loginName;
	
	/**
	 * 姓名
	 */
	private String admName;
	
	/**
	 * 性别
	 */
	private String admSex;
	
	/**
	 * 年龄
	 */
	private int admAge;
	
	/**
	 * 身份证
	 */
	private String admIdNum;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public String getAdmSex() {
		return admSex;
	}

	public void setAdmSex(String admSex) {
		this.admSex = admSex;
	}

	public int getAdmAge() {
		return admAge;
	}

	public void setAdmAge(int admAge) {
		this.admAge = admAge;
	}

	public String getAdmIdNum() {
		return admIdNum;
	}

	public void setAdmIdNum(String admIdNum) {
		this.admIdNum = admIdNum;
	}

	@Override
	public String toString() {
		return "Admin [loginName=" + loginName + ", admName=" + admName + ", admSex=" + admSex + ", admAge=" + admAge
				+ ", admIdNum=" + admIdNum + "]";
	}
}
