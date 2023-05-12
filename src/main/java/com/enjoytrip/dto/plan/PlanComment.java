package com.enjoytrip.dto.plan;

//여행 계획에 대한 댓글 정보 DTO
public class PlanComment {

	//plan_comment table PK
	private long comment_id;
	
	//plan table PK plan_comment table FK
	private long planId;
	
	//user table PK plan_comment table FK
	private long userId;
	
	//plan_comment table 댓글 내용
	private String content;
	
	//plan_comment PK plan_comment FK (recursive relationship)
	//답글대상의 ID
	private long reply_id;

	public long getComment_id() {
		return comment_id;
	}

	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
	}

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

	public long getReply_id() {
		return reply_id;
	}

	public void setReply_id(long reply_id) {
		this.reply_id = reply_id;
	}

	@Override
	public String toString() {
		return "PlanComment 여행계획 댓글 [comment_id=" + comment_id + ", planId=" + planId + ", userId=" + userId + ", content="
				+ content + ", reply_id=" + reply_id + "]";
	}
	
	
}
