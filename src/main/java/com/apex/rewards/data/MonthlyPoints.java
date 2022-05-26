package com.apex.rewards.data;

import java.time.Month;

public class MonthlyPoints {

	private Month month;
	private Integer points;
	
	public MonthlyPoints(Month month, int points) {
		this.month = month;
		this.points = points;
	}
	 
	public Month getMonth() {
		return month;
	}
	public void setMonth(Month month) {
		this.month = month;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
}
