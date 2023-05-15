package com.enjoytrip.dto.attraction;

import java.sql.Timestamp;

public class AttractionSimpleInfo {
	
	//attraction table의 PK 관광지 ID
	private Long attractionId;
	
	//attraction table 관광지의 최종 수정일
	//다른테이블에 있는 관광지 정보를 포함하여 모든 관광지 정보에 대한 수정 시간
	private Timestamp updatedAt;
	
	//attraction table 관광지명
	private String title;
	
	//attraction type의 PK attraction table의 FK
	//관광지 종류에 대한 ID
	private Long attractionTypeId;	
	
	//attraction type 관광지 종류명
	//관광지 종류명
	private String attractionType;
	
	//attraction table 조회수
	//관광지에 대한 상세정보를 조회했을때의 조회수
	private Integer readCount;
	
	//attraction_user_rating table
	//해당 관광지에 대한 유저들의 평점 평균(소수점 한자리수)
	private Double rating;
	
	//attraction_info table 관광지에 대한 간략한 주소
	private String addr1;
	
	//attraction_info table 관광지에 대한 전화번호
	private String tel;
	
	//attraction_info table 관광지 사진
	//사진에 해당하는 URL
	private String first_image;
	
	//attraction_info table 위도
	private String latitude;
	
	//attraction_info table 경도
	private String longitude;

	public Long getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(Long attractionId) {
		this.attractionId = attractionId;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getAttractionTypeId() {
		return attractionTypeId;
	}

	public void setAttractionTypeId(Long attractionTypeId) {
		this.attractionTypeId = attractionTypeId;
	}

	public String getAttractionType() {
		return attractionType;
	}

	public void setAttractionType(String attractionType) {
		this.attractionType = attractionType;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFirst_image() {
		return first_image;
	}

	public void setFirst_image(String first_image) {
		this.first_image = first_image;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "AttractionSimpleInfo [attractionId=" + attractionId + ", updatedAt=" + updatedAt + ", title=" + title
				+ ", attractionTypeId=" + attractionTypeId + ", attractionType=" + attractionType + ", readCount="
				+ readCount + ", rating=" + rating + ", addr1=" + addr1 + ", tel=" + tel + ", first_image="
				+ first_image + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}


	
}
