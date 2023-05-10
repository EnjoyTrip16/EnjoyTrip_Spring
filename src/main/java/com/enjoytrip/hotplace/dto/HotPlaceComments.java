package com.enjoytrip.hotplace.dto;

//핫 플레이스 댓글 DTO
public class HotPlaceComments {

	// 핫 플레이스 댓글 번호 (PK)
	private long hotPlaceCommentId;

	// 핫 플레이스 번호 (FK)
	private long hotPlaceId;

	// 댓글 작성자 번호 (FK)
	private long userId;

	// 댓글 내용
	private String content;

	public long getHotPlaceCommentId() {
		return hotPlaceCommentId;
	}

	public void setHotPlaceCommentId(long hotPlaceCommentId) {
		this.hotPlaceCommentId = hotPlaceCommentId;
	}

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
