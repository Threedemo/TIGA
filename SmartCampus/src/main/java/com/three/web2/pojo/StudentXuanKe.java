package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 学生选课表
 */
@Document
public class StudentXuanKe {

	@Id
	private String stuXkId;
	
	//学生id
	@DBRef
	private Student stuId;
	 
	//选课课程
	@DBRef
	private XuanKe xkId;

	

	public String getStuXkId() {
		return stuXkId;
	}

	public void setStuXkId(String stuXkId) {
		this.stuXkId = stuXkId;
	}

	public Student getStuId() {
		return stuId;
	}

	public void setStuId(Student stuId) {
		this.stuId = stuId;
	}

	public XuanKe getXkId() {
		return xkId;
	}

	public void setXkId(XuanKe xkId) {
		this.xkId = xkId;
	}

	@Override
	public String toString() {
		return "StudentXuanKe [stuXkId=" + stuXkId + ", stuId=" + stuId + ", xkId=" + xkId + "]";
	}
	
	
}
