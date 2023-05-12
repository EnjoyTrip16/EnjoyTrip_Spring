package com.enjoytrip.dto.plan;

import java.sql.Timestamp;

//여행계획에 대한 간단한 정보 DTO
public class PlanSimpleInfo {
	
	//plan table PK
	private long plan_id;
	
	//plan table 여행 계획 생성 시간
	private Timestamp created_at;
	
	//user table FK user_id 
	private long author;
	
	//해당 여행 계획 공개 범위 ex)익명 전체 비공개
	private String visibility;

	public long getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(long plan_id) {
		this.plan_id = plan_id;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
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
		return "PlanSimpleInfo 간단한 여행계획 정보 [plan_id=" + plan_id + ", created_at=" + created_at + ", author=" + author
				+ ", visibility=" + visibility + "]";
	}
	
}
