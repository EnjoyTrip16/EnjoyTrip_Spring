package com.enjoytrip.dto.attraction;

public class AttractionSimpleInfo {
	
	//attraction table의 PK 관광지 ID
	private Long attractionId;
	
	//attraction table 관광지명
	private String title;
	
	//attraction type의 PK attraction table의 FK
	//관광지 종류에 대한 ID
	private Long attractionTypeId;	
	
	//attraction type 관광지 종류명
	//관광지 종류명
	private String attractionType;

	//attraction_user_rating table
	//해당 관광지에 대한 유저들의 평점 평균(소수점 한자리수)
	private Double ratingAvg;
	
	//attraction_user_rating table
	//해당 관광지에 대한 유저들의 평가 수
	private Integer ratingCount;
	
	//attraction_info table 관광지에 대한 간략한 주소
	private String addr1;
	
	//attraction_info table 관광지에 대한 우편번호
	private String zipcode;
	
	//attraction_info table 관광지에 대한 전화번호
	private String tel;
	
	//attraction_info table 관광지 사진
	//사진에 해당하는 URL
	private String firstImage;
	
	//attraction_info table 위도
	private String latitude;
	
	//attraction_info table 경도
	private String longitude;

	private Integer bookmark;
	
	private Integer favor;
	
	private Integer sidoCode;
	
	private Integer gugunCode;
	
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

	public Double getRating() {
		return ratingAvg;
	}

	public void setRating(Double rating) {
		this.ratingAvg = rating;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getFirstImage() {
		return firstImage;
	}

	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}

	public int getBookmark() {
		return bookmark;
	}

	public void setBookmark(int bookmark) {
		this.bookmark = bookmark;
	}

	public Integer getFavor() {
		return favor;
	}

	public void setFavor(Integer favor) {
		this.favor = favor;
	}

	public void setBookmark(Integer bookmark) {
		this.bookmark = bookmark;
	}
	
	public Double getRatingAvg() {
		return ratingAvg;
	}

	public void setRatingAvg(Double ratingAvg) {
		this.ratingAvg = ratingAvg;
	}

	public Integer getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(Integer ratingCount) {
		this.ratingCount = ratingCount;
	}

	public Integer getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(Integer sidoCode) {
		this.sidoCode = sidoCode;
	}

	public Integer getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(Integer gugunCode) {
		this.gugunCode = gugunCode;
	}
	@Override
	public String toString() {
		return "AttractionSimpleInfo [attractionId=" + attractionId + ", title=" + title + ", attractionTypeId="
				+ attractionTypeId + ", attractionType=" + attractionType + ", ratingAvg=" + ratingAvg
				+ ", ratingCount=" + ratingCount + ", addr1=" + addr1 + ", zipcode=" + zipcode + ", tel=" + tel
				+ ", firstImage=" + firstImage + ", latitude=" + latitude + ", longitude=" + longitude + ", bookmark="
				+ bookmark + ", favor=" + favor + ", sidoCode=" + sidoCode + ", gugunCode=" + gugunCode + "]";
	}
	
}
