package com.enjoytrip.dto.plan;

import java.time.LocalDateTime;

public class Plan {
	
	private Long planId;
	
	private LocalDateTime createdAt;

	private Long userId;
	
	private PlanVisibility visibility;
	
	private String planName;

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public PlanVisibility getVisibility() {
		return visibility;
	}

	public void setVisibility(PlanVisibility visibility) {
		this.visibility = visibility;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", createdAt=" + createdAt + ", userId=" + userId + ", visibility="
				+ visibility + ", planName=" + planName + "]";
	}
	
}
