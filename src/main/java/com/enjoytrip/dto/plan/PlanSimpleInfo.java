package com.enjoytrip.dto.plan;

import java.sql.Timestamp;

//여행계획에 대한 간단한 정보 DTO
public class PlanSimpleInfo {
	
	//plan table PK
	private long planId;
	
	//plan table 여행 계획 생성 시간
	private Timestamp createdAt;
	
	//user table FK user_id 
	private long author;
	
	//해당 여행 계획 공개 범위 ex)익명 전체 비공개
	private String visibility;

	public long getplanId() {
		return planId;
	}

	public void setplanId(long planId) {
		this.planId = planId;
	}

	public Timestamp getcreatedAt() {
		return createdAt;
	}

	public void setcreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public long getAuthor() {
		return author;
	}

	public void setAuthor(long author) {
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
		return "PlanSimpleInfo 간단한 여행계획 정보 [planId=" + planId + ", createdAt=" + createdAt + ", author=" + author
				+ ", visibility=" + visibility + "]";
	}
	
}
