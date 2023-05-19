package com.enjoytrip.dto.attraction;

//사용자가 관광지에 대해 점수로 평가한 것에 관한 DTO
public class AttractionUserRating {

	//attraction table PK attraciton_user_rating FK
	private Long attractionId;
	
	//user table PK attraction_user_rating FK
	private Long userId;
	
	//attraction_user_rating table
	//유저가 관광지에 매긴 평점 점수 (0~5) 소수점 1자리수
	private String rating;

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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "AttractionUserRating [attractionId=" + attractionId + ", userId=" + userId + ", rating=" + rating + "]";
	}

	
}
