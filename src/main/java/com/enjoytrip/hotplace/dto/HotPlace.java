package com.enjoytrip.hotplace.dto;

import java.time.LocalDateTime;

//핫 플레이스 DTO
public class HotPlace {

	// 핫 플레이스 번호 (PK)
	private Long hotPlaceId;

	// 사용자 번호 (FK)
	private Long userId;

	// 제목
	private String title;

	// 내용
	private String content;

	// 사진
	private String image;

	// 등록 시간
	private LocalDateTime createdAt;

	// 변경 시간
	private LocalDateTime updatedAt;

	// 조회수
	private Integer readCount;

	public Long getHotPlaceId() {
		return hotPlaceId;
	}

	public void setHotPlaceId(Long hotPlaceId) {
		this.hotPlaceId = hotPlaceId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "HotPlace [hotPlaceId=" + hotPlaceId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", image=" + image + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", readCount="
				+ readCount + "]";
	}

}
