package com.three.web2.pojo;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 成绩表
 */
@Document
public class Score {

	/**
	 * 成绩表id(主键)
	 */
	@Id
	private String scoreId;
	
	/**
	 * 学生成绩集合
	 */
	private HashMap<String, Double> score;
	
	
	/**
	 * 班级
	 */
	@DBRef
	private Class claId;
	
	/**
	 * 学生
	 */
	@DBRef
	private Student stuId;
	
	/**
	 * 第几学期
	 */
	@DBRef
	private Semester semesterId;

	

	public String getScoreId() {
		return scoreId;
	}

	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}

	public HashMap<String, Double> getScore() {
		return score;
	}

	public void setScore(HashMap<String, Double> score) {
		this.score = score;
	}

	public Class getClaId() {
		return claId;
	}

	public void setClaId(Class claId) {
		this.claId = claId;
	}

	public Student getStuId() {
		return stuId;
	}

	public void setStuId(Student stuId) {
		this.stuId = stuId;
	}

	public Semester getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(Semester semesterId) {
		this.semesterId = semesterId;
	}

	@Override
	public String toString() {
		return "Score [scoreId=" + scoreId + ", score=" + score + ", claId=" + claId + ", stuId=" + stuId
				+ ", semesterId=" + semesterId + "]";
	}
	
	
	
	
	
	
}
