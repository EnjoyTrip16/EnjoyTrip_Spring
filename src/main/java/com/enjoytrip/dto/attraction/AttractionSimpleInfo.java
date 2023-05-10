package com.enjoytrip.dto.attraction;

public class AttractionSimpleInfo {
	
	//attraction table의 PK 관광지 ID
	private long attractionId;
	
	//attraction table 관광지의 최종 수정일
	//다른테이블에 있는 관광지 정보를 포함하여 모든 관광지 정보에 대한 수정 시간
	private String updatedAt;
	
	//attraction table 관광지명
	private String title;
	
	//attraction type의 PK attraction table의 FK
	//관광지 종류에 대한 ID
	private long attractionTypeId;	
	
	//attraction type 관광지 종류명
	//관광지 종류명
	private String attractionType;
	
	//attraction table 조회수
	//관광지에 대한 상세정보를 조회했을때의 조회수
	private int readCount;
	
	//attraction_user_rating table
	//해당 관광지에 대한 유저들의 평점 평균(소수점 한자리수)
	private double rating;
	
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

	public long getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(long attractionId) {
		this.attractionId = attractionId;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getAttractionTypeId() {
		return attractionTypeId;
	}

	public void setAttractionTypeId(long attractionTypeId) {
		this.attractionTypeId = attractionTypeId;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
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

	public String getlongitude() {
		return longitude;
	}

	public void setlongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAttractionType() {
		return attractionType;
	}

	public void setAttractionType(String attractionType) {
		this.attractionType = attractionType;
	}

	@Override
	public String toString() {
		return "AttractionSimpleInfo [attractionId=" + attractionId + ", updatedAt=" + updatedAt + ", title=" + title
				+ ", attractionTypeId=" + attractionTypeId + ", attractionType=" + attractionType + ", readCount="
				+ readCount + ", rating=" + rating + ", addr1=" + addr1 + ", tel=" + tel + ", first_image="
				+ first_image + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
}
