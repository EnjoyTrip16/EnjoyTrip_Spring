package com.enjoytrip.hotplace.dto;

//핫 플레이스 북마크 좋아요 DTO
public class HotPlaceBookmarkFavor {

	// 핫 플레이스 번호 (FK)
	private Long hotPlaceId;

	// 사용자 번호 (FK)
	private Long userId;

	// 북마크
	private Integer bookmark;

	// 좋아요
	private Integer favor;

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

	public Integer getFavor() {
		return favor;
	}

	public void setFavor(Integer favor) {
		this.favor = favor;
	}

	@Override
	public String toString() {
		return "HotPlaceBookmarkFavor [hotPlaceId=" + hotPlaceId + ", userId=" + userId + ", bookmark=" + bookmark
				+ ", favor=" + favor + "]";
	}

}
