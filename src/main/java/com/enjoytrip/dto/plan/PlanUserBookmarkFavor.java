package com.enjoytrip.dto.plan;

//여행계획에 대해 유저가 좋아요나 북마크를 누른 여부
public class PlanUserBookmarkFavor {
	
	//plan PK plan_user_bookmark_like FK
	private Long planId;
	
	//user PK plan_user_bookmark_like FK
	private Long userId;
	
	//plan_user_bookmark_like 북마크 여부
	private Boolean bookmark;
	
	//plan_user_bookmark_like 좋아요 여부
	private Boolean favor;

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
		return "PlanUserBookmarkLike [planId=" + planId + ", userId=" + userId + ", bookmark=" + bookmark + ", like="
				+ favor + "]";
	}
	
}
