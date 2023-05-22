package com.enjoytrip.dto.plan;

import java.time.LocalDateTime;

//여행 계획에 대한 댓글 정보 DTO
public class PlanComment {

	//plan_comment table PK
	private Long commentId;
	
	//plan table PK plan_comment table FK
	private Long planId;
	
	//user table PK plan_comment table FK
	private Long userId;
	
	//plan_comment table 댓글 내용
	private String content;
	
	//plan_comment PK plan_comment FK (recursive relationship)
	//답글대상의 ID
	private Long replyId;
	
	private LocalDateTime createdAt;
	
	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

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

	public Long getReplyId() {
		return replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "PlanComment [commentId=" + commentId + ", planId=" + planId + ", userId=" + userId + ", content="
				+ content + ", replyId=" + replyId + ", createdAt=" + createdAt + "]";
	}
	
	

	
}
