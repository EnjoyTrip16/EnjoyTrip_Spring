package com.enjoytrip.dto.plan;

import java.sql.Timestamp;

//여행 계획에 해당하는 멤버를 설명하는 DTO
public class PlanMember {
	
	//plan table PK
	private Long planId;
	
	//user PK plan_user FK
	private Long userId;
	
	//plan_user 유저 역할 (작성자/참여자)
	private String role;
	
	//plan_user 참여시간
	private Timestamp joinedAt;

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(Timestamp joinedAt) {
		this.joinedAt = joinedAt;
	}

	@Override
	public String toString() {
		return "PlanMember [planId=" + planId + ", userId=" + userId + ", role=" + role + ", joinedAt=" + joinedAt
				+ "]";
	}
	
}
