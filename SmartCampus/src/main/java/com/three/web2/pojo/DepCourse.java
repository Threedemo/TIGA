package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * 院系课程表
 */
@Document
public class DepCourse {

	@Id
	int depCourseId;
	
	@DBRef
	Department depId;
	
	@DBRef
	Course courseId;

	public int getDepCourseId() {
		return depCourseId;
	}

	public void setDepCourseId(int depCourseId) {
		this.depCourseId = depCourseId;
	}

	public Department getDepId() {
		return depId;
	}

	public void setDepId(Department depId) {
		this.depId = depId;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "DepCourse [depCourseId=" + depCourseId + ", depId=" + depId + ", courseId=" + courseId + "]";
	}
	
	
	
}
