package com.apex.rewards.data;

import java.util.List;

public class RewardsData {


	private List<MonthlyPoints> rewardPoints;
	private int totalPoints;
	 
	public RewardsData(List<MonthlyPoints> rewardPoints, int totalPoints) {
		this.rewardPoints = rewardPoints;
		this.totalPoints = totalPoints;
	}
	
	public List<MonthlyPoints> getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(List<MonthlyPoints> rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public int getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	
}
