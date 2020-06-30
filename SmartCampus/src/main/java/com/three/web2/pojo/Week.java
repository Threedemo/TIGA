package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 星期表
 */
@Document
public class Week {

	/**
	 * 星期几id(主键)
	 */
	@Id
	private String weekId;
	
	/**
	 * 星期几
	 */
	private String WeekName;

	
	public String getWeekId() {
		return weekId;
	}

	public void setWeekId(String weekId) {
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
