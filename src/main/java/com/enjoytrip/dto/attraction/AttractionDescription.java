package com.enjoytrip.dto.attraction;

//관광지 상세 설명에 관한 DTO
public class AttractionDescription {
	
	//attraction table PK
	private Long attractionId;
	
	//attraction_description table 관광지 홈페이지
	private String homepage;
	
	//attraction_description table 관광지 상세 설명(10000자 제한)
	private String overview;
	public Long getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(Long attractionId) {
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
	
	@Override
	public String toString() {
		return "AttractionDescription [attractionId=" + attractionId + ", homepage=" + homepage + ", overview="
				+ overview + "]";
	}
	
	
	
}
