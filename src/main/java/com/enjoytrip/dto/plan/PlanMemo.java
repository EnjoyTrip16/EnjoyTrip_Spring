package com.enjoytrip.dto.plan;

import java.sql.Timestamp;
import java.time.LocalDateTime;

//여행 계획에 멤버들이 작성할 메모를 저장할 객체
public class PlanMemo {

	private Long planMemoId;
	
	//plan table PK
	private Long planId;
	
	//user table PK
	private Long userId;
	
	//plan_memo table 메모에 대한 내용
	private String content;
	
	//plan_memo_tag PK plan_memo FK
	private Long tagId;
	
	//메모 생성시간
	private LocalDateTime createdAt;
	
	//메모 수정시간
	private LocalDateTime updatedAt;

	private String tagName;
	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getPlanMemoId() {
		return planMemoId;
	}

	public void setPlanMemoId(Long planMemoId) {
		this.planMemoId = planMemoId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "PlanMemo [planMemoId=" + planMemoId + ", planId=" + planId + ", userId=" + userId + ", content="
				+ content + ", tagId=" + tagId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", tagName="
				+ tagName + "]";
	}
	
}
