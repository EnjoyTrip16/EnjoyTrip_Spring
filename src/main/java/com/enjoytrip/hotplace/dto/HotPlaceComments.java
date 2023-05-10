package com.enjoytrip.hotplace.dto;

import java.math.BigInteger;
import java.sql.Timestamp;

public class HotPlaceComments { // 핫 플레이스 댓글 DTO

	private BigInteger hotPlaceCommentId; // 핫 플레이스 댓글 번호 (기본키)
	private BigInteger hotPlaceId; // 핫 플레이스 번호 (외래키)
	private BigInteger userId; // 댓글 작성자 번호 (외래키)
	private String content; // 댓글 내용

	public BigInteger getHotPlaceCommentId() {
		return hotPlaceCommentId;
	}

	public void setHotPlaceCommentId(BigInteger hotPlaceCommentId) {
		this.hotPlaceCommentId = hotPlaceCommentId;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "HotPlaceComments [hotPlaceCommentId=" + hotPlaceCommentId + ", hotPlaceId=" + hotPlaceId + ", userId="
				+ userId + ", content=" + content + "]";
	}

}
