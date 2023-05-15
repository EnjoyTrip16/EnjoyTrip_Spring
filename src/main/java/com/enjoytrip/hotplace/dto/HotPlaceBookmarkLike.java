package com.enjoytrip.hotplace.dto;

//핫 플레이스 북마크 좋아요 DTO
public class HotPlaceBookmarkLike {

	// 핫 플레이스 번호 (FK)
	private Long hotPlaceId;

	// 사용자 번호 (FK)
	private Long userId;

	// 북마크
	private Integer bookmark;

	// 좋아요
	private Integer like;

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

	public Integer getBookmark() {
		return bookmark;
	}

	public void setBookmark(Integer bookmark) {
		this.bookmark = bookmark;
	}

	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	@Override
	public String toString() {
		return "HotPlaceBookmarkLike [hotPlaceId=" + hotPlaceId + ", userId=" + userId + ", bookmark=" + bookmark
				+ ", like=" + like + "]";
	}

}
