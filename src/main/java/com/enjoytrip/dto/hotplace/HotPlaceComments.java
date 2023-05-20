package com.enjoytrip.dto.hotplace;

//핫 플레이스 댓글 DTO
public class HotPlaceComments {

	// 핫 플레이스 댓글 번호 (PK)
	private Long hotPlaceCommentId;

	// 핫 플레이스 번호 (FK)
	private Long hotPlaceId;

	// 댓글 작성자 번호 (FK)
	private Long userId;

	// 댓글 내용
	private String content;

	public Long getHotPlaceCommentId() {
		return hotPlaceCommentId;
	}

	public void setHotPlaceCommentId(Long hotPlaceCommentId) {
		this.hotPlaceCommentId = hotPlaceCommentId;
	}

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
