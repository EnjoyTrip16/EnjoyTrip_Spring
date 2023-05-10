package com.enjoytrip.hotplace.dto;

import java.sql.Timestamp;

//핫 플레이스 DTO
public class HotPlace {

	// 핫 플레이스 번호 (PK)
	private long hotPlaceId;

	// 사용자 번호 (FK)
	private long userId;

	// 제목
	private String title;

	// 내용
	private String content;

	// 사진
	private String image;

	// 등록 시간
	private Timestamp createdAt;

	// 변경 시간
	private Timestamp updatedAt;

	// 조회수
	private int readCount;

	public long getHotPlaceId() {
		return hotPlaceId;
	}

	public void setHotPlaceId(long hotPlaceId) {
		this.hotPlaceId = hotPlaceId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "HotPlace [hotPlaceId=" + hotPlaceId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", image=" + image + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", readCount="
				+ readCount + "]";
	}

}
