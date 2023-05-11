package com.enjoytrip.dto.attraction;

//관광지 종류에 관한 DTO
public class AttractionType {
	
	//attraction_type table PK 
	private long attractionTypeId;
	
	//attraction_type 관광지 종류명
	private String attractionType;

	public long getAttractionTypeId() {
		return attractionTypeId;
	}

	public void setAttractionTypeId(long attractionTypeId) {
		this.attractionTypeId = attractionTypeId;
	}

	public String getAttractionType() {
		return attractionType;
	}

	public void setAttractionType(String attractionType) {
		this.attractionType = attractionType;
	}

	@Override
	public String toString() {
		return "AttractionType [attractionTypeId=" + attractionTypeId + ", attractionType=" + attractionType + "]";
	}
	
}
