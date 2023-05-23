package com.enjoytrip.dto.hotplace;

//핫 플레이스 북마크 좋아요 DTO
public class HotplaceBookmarkFavor {

	// 핫 플레이스 번호 (FK)
	private Long hotplaceId;

	// 사용자 번호 (FK)
	private Long userId;

	// 북마크
	private Integer bookmark;

	// 좋아요
	private Integer favor;

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
		return "HotplaceBookmarkFavor [hotplaceId=" + hotplaceId + ", userId=" + userId + ", bookmark=" + bookmark
				+ ", favor=" + favor + "]";
	}

}
