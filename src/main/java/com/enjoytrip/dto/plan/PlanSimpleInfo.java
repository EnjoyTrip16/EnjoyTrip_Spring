package com.enjoytrip.dto.plan;

import java.sql.Timestamp;

//여행계획에 대한 간단한 정보 DTO
public class PlanSimpleInfo {
	
	//plan table PK
	private Long planId;
	
	//plan table 여행 계획 생성 시간
	private Timestamp createdAt;
	
	//user table FK user_id 
	private Long author;
	
	//해당 여행 계획 공개 범위 ex)익명 전체 비공개
	private String visibility;

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(Long author) {
		this.author = author;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	@Override
	public String toString() {
		return "PlanSimpleInfo [planId=" + planId + ", createdAt=" + createdAt + ", author=" + author + ", visibility="
				+ visibility + "]";
	}

}
