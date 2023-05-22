package com.enjoytrip.dto.attraction;

import java.time.LocalDateTime;

//attraction table에 대한 DTO
public class Attraction {
	
	//attraction table PK
	private Long attractionId;
	
	//attraction table 조회수
	private Integer readCount;
	
	//attraction table 생성시간 
	private LocalDateTime createdAt;
	
	//attraction table 수정시간
	private LocalDateTime updatedAt;
	
	//attraction table 관광지명
	private String title;
	
	//attraction_type table PK 관광지 종류 ID
	private Long attractionTypeId;

	public Long getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(Long attractionId) {
		this.attractionId = attractionId;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getattractionTypeId() {
		return attractionTypeId;
	}

	public void setattractionTypeId(Long attractionTypeId) {
		this.attractionTypeId = attractionTypeId;
	}

	@Override
	public String toString() {
		return "Attraction [attractionId=" + attractionId + ", readCount=" + readCount + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", title=" + title + ", attractionTypeId=" + attractionTypeId + "]";
	}

}
