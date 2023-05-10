package com.enjoytrip.hotplace.dto;

import java.math.BigInteger;
import java.sql.Timestamp;

public class HotPlace { // 핫 플레이스 DTO

	private BigInteger hotPlaceId; // 핫 플레이스 번호 (기본키)
	private BigInteger userId; // 사용자 번호 (외래키)
	private String title; // 제목
	private String content; // 내용
	private String image; // 사진
	private Timestamp createdAt; // 등록 시간
	private Timestamp updatedAt; // 변경 시간
	private int readCount; // 조회수

	public BigInteger getHotPlaceId() {
		return hotPlaceId;
	}

	public void setHotPlaceId(BigInteger hotPlaceId) {
		this.hotPlaceId = hotPlaceId;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
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
