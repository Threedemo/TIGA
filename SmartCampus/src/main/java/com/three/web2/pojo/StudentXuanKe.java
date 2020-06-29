package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StudentXuanKe {

	@Id
	int stuXkId;
	
	@DBRef
	Student stuId;
	 
	@DBRef
	XuanKe xkId;

	public int getStuXkId() {
		return stuXkId;
	}

	public void setStuXkId(int stuXkId) {
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
