package com.enjoytrip.dto.attraction;

//관광지 상세 설명에 관한 DTO
public class AttractionDescription {
	
	//attraction table PK
	private long attractionId;
	
	//attraction_description table 관광지 홈페이지
	private String homepage;
	
	//attraction_description table 관광지 상세 설명(10000자 제한)
	private String overview;
	
	//attraction_description table 관광지 전화 번호
	private String telname;

	public long getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(long attractionId) {
		this.attractionId = attractionId;
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

	@Override
	public String toString() {
		return "AttractionDescription [attractionId=" + attractionId + ", homepage=" + homepage + ", overview="
				+ overview + ", telname=" + telname + "]";
	}
	
	
}
