package com.enjoytrip.dto.attraction;

//관광지 종류에 관한 DTO
public class AttractionType {
	
	//attraction_type table PK 
	private Long attractionTypeId;
	
	//attraction_type 관광지 종류명
	private String attractionType;

	public Long getAttractionTypeId() {
		return attractionTypeId;
	}

	public String getAttractionType() {
		return attractionType;
	}

	public void setAttractionType(String attractionType) {
		this.attractionType = attractionType;
	}

	public void setAttractionTypeId(Long attractionTypeId) {
		this.attractionTypeId = attractionTypeId;
	}

	@Override
	public String toString() {
		return "AttractionType [attractionTypeId=" + attractionTypeId + ", attractionType=" + attractionType + "]";
	}
	
	
	
}
