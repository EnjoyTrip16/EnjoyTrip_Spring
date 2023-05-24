package com.enjoytrip.dto.attraction;

public class AttractionInfo {
	
	//attraction PK 관광지 ID
	private Long attractionId;
	
	//attraction_info table addr1 도로명 주소
	private String addr1;
	
	//attraction_info table addr2 대체주소
	private String addr2;
	
	//attraction_info table zipcode 우편번호
	private String zipcode;
	
	//attraction_info table tel 전화번호
	private String tel;
	
	//attraction_info table first_image 관광지 사진 (url)
	private String firstImage;
	
	//attraction_info table first_imagde2 관광지 사진2 (url)
	private String firstImage2;
	
	//attraction_info table latitude 경도
	private String latitude;
	
	//attraction_info table longitude 위도
	private String longitude;
	
	//sido table PK 시도 코드
	private Integer sidoCode;
	
	//gugun table 구군코드
	private Integer gugunCode;

	public Long getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(Long attractionId) {
		this.attractionId = attractionId;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFirstImage() {
		return firstImage;
	}

	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}

	public String getFirstImage2() {
		return firstImage2;
	}

	public void setFirstImage2(String firstImage2) {
		this.firstImage2 = firstImage2;
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
		return "AttractionInfo [attractionId=" + attractionId + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode="
				+ zipcode + ", tel=" + tel + ", firstImage=" + firstImage + ", firstImage2=" + firstImage2
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", sidoCode=" + sidoCode + ", gugunCode="
				+ gugunCode + "]";
	}
	
}
