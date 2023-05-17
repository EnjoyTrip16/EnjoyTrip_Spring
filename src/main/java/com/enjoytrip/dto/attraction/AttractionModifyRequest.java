package com.enjoytrip.dto.attraction;

import java.sql.Timestamp;

//관광지 정보 수정 요청 테이블(attraction_modify_request)에 관한 DTO
public class AttractionModifyRequest {
	
	//attraction_modify_request table requestStatus에 들어갈값
	//처리됨을 나타내는 상태 
	public static final String STATUS_PROCESSED = "Processed";
	
	//attraction_modify_request table requestStatus에 들어갈값
	//처리중임을 나타내는 상태
	public static final String STATUS_PROCESSING = "Processing";	
	
	//attraction_modify_request table requestStatus에 들어갈값
	//처리전임을 나타내는 상태
	public static final String STATUS_READY = "Ready";
	
	//attraction_modify_request table request_type에 들어갈값들
	
	//해당 요청이 관광지 사진에 대한 수정요청
	public static final String TYPE_PHOTO = "photo";

	//해당 요청이 관광지명에 대한 수정요청
	public static final String TYPE_NAME = "name";
	
	//해당 요청이 관광지 주소에 대한 수정요청
	public static final String TYPE_ADDRESS = "address";
	
	//해당 요청이 관광지 내용에 대한 수정요청
	public static final String TYPE_CONTENT = "content";	
	
	//해당 요청이 관광지 위치에 대한 수정요청
	public static final String TYPE_LOCATION = "location";
	
	//해당 요청이 관광지 연락처에 대한 수정요청
	public static final String TYPE_TEL = "tel";
	
	//해당 요청이 관광지  홈페이지에 대한 수정요청
	public static final String TYPE_HOMEPAGE = "homepage";
	
	//해당 요청이 위와 다른 정보에 대한 수정요청일 경우
	public static final String TYPE_ETC = "etc";
	
	private Long requestId;
	
	//attraction table PK attraction_modify_request FK
	private Long attractionId;
	
	//user table PK attraction_modify_request FK
	private Long userId;
	
	//attraction_modify_request table
	//관광지 정보 수청을 요청한 신청한 시간
	private Timestamp requestedAt;
	
	//attraction_modify_request table
	//관광지 정보 수정 요청에서 수정을 원하는 내용
	private String requestContent;
	
	//attraction_modify_request table
	//관광지 정보 수정 요청에 대해 관리자가 요청을 검토한 내용
	private String requestComment;
	
	//attraction_modify_request table
	//관광지 정보 수정 요청에 대한 검토상태
	private String requestStatus;

	//attraction_modify_request table
	//관광지 정보 수정 요청이 어떤 정보를 수정하는지에 대해 ex)내용,관광지명,위치
	private String requestType;
	
	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

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
	
	

	public Timestamp getRequestedAt() {
		return requestedAt;
	}

	public void setRequestedAt(Timestamp requestedAt) {
		this.requestedAt = requestedAt;
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

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@Override
	public String toString() {
		return "AttractionModifyRequest [requestId=" + requestId + ", attractionId=" + attractionId + ", userId="
				+ userId + ", requestedAt=" + requestedAt + ", requestContent=" + requestContent + ", requestComment="
				+ requestComment + ", requestStatus=" + requestStatus + ", requestType=" + requestType + "]";
	}

	
}
