package com.enjoytrip.dto.plan;

import java.time.LocalDateTime;

//여행계획에 대한 간단한 정보 DTO
//tag는 서비스레이어에서 넣어줘야할듯
public class PlanSimpleInfo {
	
	//plan table PK
	private Long planId;
	
	private String planName;
	
	private String planImage;
	
	//plan table 여행 계획 생성 시간
	private LocalDateTime createdAt;
	
	private Long userId;
	
	//user table FK user_id 
	private String author;
	
	//해당 여행 계획 공개 범위 ex)익명 전체 비공개
	private String visibility;

	private Long bookmark;
	
	private Long favor;
	
	private Long comment;

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanImage() {
		return planImage;
	}

	public void setPlanImage(String planImage) {
		this.planImage = planImage;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public Long getBookmark() {
		return bookmark;
	}

	public void setBookmark(Long bookmark) {
		this.bookmark = bookmark;
	}

	public Long getFavor() {
		return favor;
	}

	public void setFavor(Long favor) {
		this.favor = favor;
	}

	public Long getComment() {
		return comment;
	}

	public void setComment(Long comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "PlanSimpleInfo [planId=" + planId + ", planName=" + planName + ", planImage=" + planImage
				+ ", createdAt=" + createdAt + ", userId=" + userId + ", author=" + author + ", visibility="
				+ visibility + ", bookmark=" + bookmark + ", favor=" + favor + ", comment=" + comment + "]";
	}
	
}
