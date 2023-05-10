package com.enjoytrip.dto.attraction;

//관광지 정보 수정 요청 테이블(attraction_modify_request)에 관한 DTO
public class AttractionModifyRequest {
	
	//attraction table PK attraction_modify_request FK
	private Long attractionId;
	
	//user table PK attraction_modify_request FK
	private Long userId;
	
	//attraction_modify_request table
	//관광지 정보 수청을 요청한 신청한 시간
	private String requestAt;
	
	//attraction_modify_request table
	//관광지 정보 수정 요청에서 수정을 원하는 내용
	private String requestContent;
	
	//attraction_modify_request table
	//관광지 정보 수정 요청에 대해 관리자가 요청을 검토한 내용
	private String requestComment;
	
	//attraction_modify_request table
	//관광지 정보 수정 요청에 대한 검토상태
	private String requestStatus;

	public Long getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(Long attractionId) {
		this.attractionId = attractionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRequestAt() {
		return requestAt;
	}

	public void setRequestAt(String requestAt) {
		this.requestAt = requestAt;
	}

	public String getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	public String getRequestComment() {
		return requestComment;
	}

	public void setRequestComment(String requestComment) {
		this.requestComment = requestComment;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	@Override
	public String toString() {
		return "AttractionModifyRequest 관광지수정요청 [attractionId=" + attractionId + ", userId=" + userId + ", requestAt="
				+ requestAt + ", requestContent=" + requestContent + ", requestComment=" + requestComment
				+ ", requestStatus=" + requestStatus + "]";
	}
	
}
