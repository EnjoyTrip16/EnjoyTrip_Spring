package com.enjoytrip.dto.attraction;

public class AttractionUserBookmarkFavor {
	
	//user table Pk
	private Long userId;
	
	//attraction table PK
	private Long attractionId;
	
	//attraction_user_bookmark_favor table 북마크
	private Boolean bookmark;
	
	//attraction_user_bookmark_favor table 좋아요
	private Boolean favor;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(Long attractionId) {
		this.attractionId = attractionId;
	}

	public Boolean getBookmark() {
		return bookmark;
	}

	public void setBookmark(Boolean bookmark) {
		this.bookmark = bookmark;
	}

	public Boolean getFavor() {
		return favor;
	}

	public void setFavor(Boolean favor) {
		this.favor = favor;
	}

	@Override
	public String toString() {
		return "AttractionUserBookmarkFavor [userId=" + userId + ", attractionId=" + attractionId + ", bookmark="
				+ bookmark + ", favor=" + favor + "]";
	}
	
}
