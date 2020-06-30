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

	/**
	 * 院系课程表id(主键)
	 */
	@Id
	private String  depCourseId;
	
	/**
	 * 院系id
	 */
	@DBRef
	private Department depId;
	
	
	/**
	 * 课程id
	 */
	@DBRef
	private Course courseId;

	
	public String getDepCourseId() {
		return depCourseId;
	}

	public void setDepCourseId(String depCourseId) {
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
