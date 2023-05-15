package com.enjoytrip.dto.plan;

//여행 계획에 대한 댓글 정보 DTO
public class PlanComment {

	//plan_comment table PK
	private Long comment_id;
	
	//plan table PK plan_comment table FK
	private Long planId;
	
	//user table PK plan_comment table FK
	private Long userId;
	
	//plan_comment table 댓글 내용
	private String content;
	
	//plan_comment PK plan_comment FK (recursive relationship)
	//답글대상의 ID
	private Long reply_id;

	public Long getComment_id() {
		return comment_id;
	}

	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
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

	public Long getReply_id() {
		return reply_id;
	}

	public void setReply_id(Long reply_id) {
		this.reply_id = reply_id;
	}

	@Override
	public String toString() {
		return "PlanComment [comment_id=" + comment_id + ", planId=" + planId + ", userId=" + userId + ", content="
				+ content + ", reply_id=" + reply_id + "]";
	}

	
}
