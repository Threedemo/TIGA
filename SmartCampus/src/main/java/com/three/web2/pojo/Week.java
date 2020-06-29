package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Week {

	@Id
	int weekId;
	
	String WeekName;

	public int getWeekId() {
		return weekId;
	}

	public void setWeekId(int weekId) {
		this.weekId = weekId;
	}

	public String getWeekName() {
		return WeekName;
	}

	public void setWeekName(String weekName) {
		WeekName = weekName;
	}

	@Override
	public String toString() {
		return "Week [weekId=" + weekId + ", WeekName=" + WeekName + "]";
	}
	
	
}
