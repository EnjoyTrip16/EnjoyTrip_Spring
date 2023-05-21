package com.enjoytrip.dto.hotplace;

//핫 플레이스 댓글 DTO
public class HotplaceComment {

	// 핫 플레이스 댓글 번호 (PK)
	private Long hotplaceCommentId;

	// 핫 플레이스 번호 (FK)
	private Long hotplaceId;

	// 댓글 작성자 번호 (FK)
	private Long userId;

	// 댓글 내용
	private String content;

	public Long getHotplaceCommentId() {
		return hotplaceCommentId;
	}

	public void setHotplaceCommentId(Long hotplaceCommentId) {
		this.hotplaceCommentId = hotplaceCommentId;
	}

	public Long getHotplaceId() {
		return hotplaceId;
	}

	public void setHotplaceId(Long hotplaceId) {
		this.hotplaceId = hotplaceId;
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
		return "HotplaceComments [hotplaceCommentId=" + hotplaceCommentId + ", hotplaceId=" + hotplaceId + ", userId="
				+ userId + ", content=" + content + "]";
	}

}
