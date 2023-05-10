package com.enjoytrip.hotplace.dto;

//핫 플레이스 북마크 좋아요 DTO
public class HotPlaceBookmarkLike {

	// 핫 플레이스 번호 (FK)
	private long hotPlaceId;

	// 사용자 번호 (FK)
	private long userId;

	// 북마크
	private int bookmark;

	// 좋아요
	private int like;

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

	public int getBookmark() {
		return bookmark;
	}

	public void setBookmark(int bookmark) {
		this.bookmark = bookmark;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	@Override
	public String toString() {
		return "HotPlaceBookmarkLike [hotPlaceId=" + hotPlaceId + ", userId=" + userId + ", bookmark=" + bookmark
				+ ", like=" + like + "]";
	}

}
