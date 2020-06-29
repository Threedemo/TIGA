package com.three.web2.pojo;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClassCourse {

	int stuCourseId;
	
	@DBRef
	Class claId;
	
	@DBRef
	Teacher teaId;
	
	@DBRef
	ClassHours classHoursId;
	
	@DBRef
	Week weekId;
	
	@DBRef
	Zhou zhouId;
	
	@DBRef
	ClassRoom classHomeId;

	public int getStuCourseId() {
		return stuCourseId;
	}

	public void setStuCourseId(int stuCourseId) {
		this.stuCourseId = stuCourseId;
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
	
	
	
	
}
