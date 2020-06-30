package com.three.web2.pojo;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 排课表
 */
@Document
public class ClassCourse {

	String classCourseId;
	
	//班级
	@DBRef
	Class claId;
	
	//老师
	@DBRef
	Teacher teaId;
	
	//授课时间段
	@DBRef
	ClassHours classHoursId;
	
	//第几周
	@DBRef
	Week weekId;
	
	//星期几
	@DBRef
	Zhou zhouId;
	
	//教室
	@DBRef
	ClassRoom classHomeId;

	

	public String getClassCourseId() {
		return classCourseId;
	}

	public void setClassCourseId(String classCourseId) {
		this.classCourseId = classCourseId;
	}

	public Class getClaId() {
		return claId;
	}

	public void setClaId(Class claId) {
		this.claId = claId;
	}

	public Teacher getTeaId() {
		return teaId;
	}

	public void setTeaId(Teacher teaId) {
		this.teaId = teaId;
	}

	public ClassHours getClassHoursId() {
		return classHoursId;
	}

	public void setClassHoursId(ClassHours classHoursId) {
		this.classHoursId = classHoursId;
	}

	public Week getWeekId() {
		return weekId;
	}

	public void setWeekId(Week weekId) {
		this.weekId = weekId;
	}

	public Zhou getZhouId() {
		return zhouId;
	}

	public void setZhouId(Zhou zhouId) {
		this.zhouId = zhouId;
	}

	public ClassRoom getClassHomeId() {
		return classHomeId;
	}

	public void setClassHomeId(ClassRoom classHomeId) {
		this.classHomeId = classHomeId;
	}

	@Override
	public String toString() {
		return "ClassCourse [classCourseId=" + classCourseId + ", claId=" + claId + ", teaId=" + teaId
				+ ", classHoursId=" + classHoursId + ", weekId=" + weekId + ", zhouId=" + zhouId + ", classHomeId="
				+ classHomeId + "]";
	}
}
