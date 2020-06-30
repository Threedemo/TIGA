package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 星期表
 */
@Document
public class Week {

	@Id
	int weekId;
	
	//星期几
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
