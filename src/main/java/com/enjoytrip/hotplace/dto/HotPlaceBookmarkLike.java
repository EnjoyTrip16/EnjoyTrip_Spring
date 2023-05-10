package com.enjoytrip.hotplace.dto;

import java.math.BigInteger;
import java.sql.Timestamp;

public class HotPlaceBookmarkLike { // 핫 플레이스 북마크 좋아요 DTO

	private BigInteger hotPlaceId; // 핫 플레이스 번호 (외래키)
	private BigInteger userId; // 사용자 번호 (외래키)
	private int bookmark; // 북마크
	private int like; // 좋아요

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
