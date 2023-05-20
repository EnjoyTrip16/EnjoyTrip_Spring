package com.enjoytrip.dto.hotplace;

import java.time.LocalDateTime;

// 핫 플레이스 목록에 보일 간단한 정보 DTO
public class HotplaceSimpleInfo {

	// 핫 플레이스 번호 (PK)
	private Long hotplaceId;

	// 관광지 종류명
	private String attractionType;

	// 사진
	private String image;

	// 제목
	private String title;

	// 사용자 이름
	private Long username;

	// 조회수
	private Integer readCount;

	// 북마크 수
	private Integer bookmarkCount;

	// 좋아요 수
	private Integer favorCount;

	// 댓글 수
	private Integer commentCount;

	// 최초 등록 시간
	private LocalDateTime createdAt;

	// 마지막 변경 시간
	private LocalDateTime updatedAt;

	public Long getHotplaceId() {
		return hotplaceId;
	}

	public void setHotplaceId(Long hotplaceId) {
		this.hotplaceId = hotplaceId;
	}

	public String getAttractionType() {
		return attractionType;
	}

	public void setAttractionType(String attractionType) {
		this.attractionType = attractionType;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getUsername() {
		return username;
	}

	public void setUsername(Long username) {
		this.username = username;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Integer getBookmarkCount() {
		return bookmarkCount;
	}

	public void setBookmarkCount(Integer bookmarkCount) {
		this.bookmarkCount = bookmarkCount;
	}

	public Integer getFavorCount() {
		return favorCount;
	}

	public void setFavorCount(Integer favorCount) {
		this.favorCount = favorCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
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

	@Override
	public String toString() {
		return "HotplaceSimpleInfo [hotplaceId=" + hotplaceId + ", attractionType=" + attractionType + ", image="
				+ image + ", title=" + title + ", username=" + username + ", readCount=" + readCount
				+ ", bookmarkCount=" + bookmarkCount + ", favorCount=" + favorCount + ", commentCount=" + commentCount
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
