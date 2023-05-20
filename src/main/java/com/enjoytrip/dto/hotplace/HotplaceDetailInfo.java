package com.enjoytrip.dto.hotplace;

import java.time.LocalDateTime;
import java.util.List;

import com.enjoytrip.dto.attraction.AttractionSimpleInfo;

//핫 플레이스에 대한 세부 정보 DTO
public class HotplaceDetailInfo {

	// 핫 플레이스 번호 (PK)
	private Long hotplaceId;

	// 제목
	private String title;

	// 사용자 이름
	private Long username;

	// 북마크 수
	private Integer bookmarkCount;

	// 좋아요 수
	private Integer favorCount;

	// 조회수
	private Integer readCount;

	// 사진
	private String image;

	// 최초 등록 시간
	private LocalDateTime createdAt;

	// 마지막 변경 시간
	private LocalDateTime updatedAt;

	// 핫 플레이스 내용
	private String content;

	// 관광지 위도
	private String latitude;

	// 관광지 경도
	private String longitude;

	// 관광지 간단 정보
	private AttractionSimpleInfo attractionSimpleInfo;

	// 댓글 수
	private Integer commentCount;

	// 댓글 리스트
	private List<HotplaceComments> commentsList;

	public Long getHotplaceId() {
		return hotplaceId;
	}

	public void setHotplaceId(Long hotplaceId) {
		this.hotplaceId = hotplaceId;
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

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public AttractionSimpleInfo getAttractionSimpleInfo() {
		return attractionSimpleInfo;
	}

	public void setAttractionSimpleInfo(AttractionSimpleInfo attractionSimpleInfo) {
		this.attractionSimpleInfo = attractionSimpleInfo;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public List<HotplaceComments> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<HotplaceComments> commentsList) {
		this.commentsList = commentsList;
	}

	@Override
	public String toString() {
		return "HotplaceDetailInfo [hotplaceId=" + hotplaceId + ", title=" + title + ", username=" + username
				+ ", bookmarkCount=" + bookmarkCount + ", favorCount=" + favorCount + ", readCount=" + readCount
				+ ", image=" + image + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", content=" + content
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", attractionSimpleInfo="
				+ attractionSimpleInfo + ", commentCount=" + commentCount + ", commentsList=" + commentsList + "]";
	}

}
