package com.enjoytrip.dto.plan;

import java.sql.Timestamp;

//여행 계획에 멤버들이 작성할 메모를 저장할 객체
public class PlanMemo {

	//plan table PK
	private long planId;
	
	//user table PK
	private long userId;
	
	//plan_memo table 메모에 대한 내용
	private String content;
	
	//plan_memo_tag PK plan_memo FK
	private long tagId;
	
	//메모 생성시간
	private Timestamp createdAt;
	
	//메모 수정시간
	private Timestamp updatedAt;

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
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

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "PlanMemo [planId=" + planId + ", userId=" + userId + ", content=" + content + ", tagId=" + tagId
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
