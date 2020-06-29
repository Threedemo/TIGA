package com.three.web2.pojo;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Score {

	@Id
	int scoreId;
	
	
	HashMap<String, Double> score;
	
	@DBRef
	Class claId;
	
	@DBRef
	Student stuId;
	
	@DBRef
	Semester semesterId;

	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int scoreId) {
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
	
	
	
	
	
	
}
