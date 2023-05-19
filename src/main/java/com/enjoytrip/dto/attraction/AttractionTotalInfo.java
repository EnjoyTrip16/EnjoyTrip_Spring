package com.enjoytrip.dto.attraction;

import java.time.LocalDateTime;

//관광지 정보 전체에 대한 DTO
public class AttractionTotalInfo {
	
	//attraction table의 PK 관광지 ID
	private Long attractionId;
	
	//attraction table 관광지의 최종 수정일
	//다른테이블에 있는 관광지 정보를 포함하여 모든 관광지 정보에 대한 수정 시간
	private LocalDateTime updatedAt;
	
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
	
	//attraction_info table 우편번호 
	private String zipcode;
		
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
	
	//attraction_description table 관광지 홈페이지
	private String homepage;
	
	//attraction_description table 관광지 상세 설명(10000자 제한)
	private String overview;
	
	//attraction_description table 관광지 전화 번호
	private String telname;
	
	//attraction_user_rating table
	//유저가 관광지에 매긴 평점 점수의 평균 (0~5) 소수점 1자리수
	private Double rating;
	
	private Integer bookmark;
	
	private Integer like;
	
	public Long getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(Long attractionId) {
		this.attractionId = attractionId;
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

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getTelname() {
		return telname;
	}

	public void setTelname(String telname) {
		this.telname = telname;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getBookmark() {
		return bookmark;
	}

	public void setBookmark(Integer bookmark) {
		this.bookmark = bookmark;
	}

	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	@Override
	public String toString() {
		return "AttractionTotalInfo [attractionId=" + attractionId + ", updatedAt=" + updatedAt + ", title=" + title
				+ ", attractionTypeId=" + attractionTypeId + ", attractionType=" + attractionType + ", readCount="
				+ readCount + ", addr1=" + addr1 + ", tel=" + tel + ", first_image=" + first_image + ", latitude="
				+ latitude + ", longitude=" + longitude + ", homepage=" + homepage + ", overview=" + overview
				+ ", telname=" + telname + ", rating=" + rating + "]";
	}
	
	
	
}
