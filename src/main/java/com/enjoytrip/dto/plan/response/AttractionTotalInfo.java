package com.enjoytrip.dto.plan.response;

import java.time.LocalDateTime;

import com.enjoytrip.dto.attraction.AttractionDescription;
import com.enjoytrip.dto.attraction.AttractionSimpleInfo;

//관광지 정보 전체에 대한 DTO
public class AttractionTotalInfo {
	
	private AttractionSimpleInfo attractionSimpleInfo;
	
	private AttractionDescription attractionDescription;

	public AttractionSimpleInfo getAttractionSimpleInfo() {
		return attractionSimpleInfo;
	}

	public void setAttractionSimpleInfo(AttractionSimpleInfo attractionSimpleInfo) {
		this.attractionSimpleInfo = attractionSimpleInfo;
	}

	public AttractionDescription getAttractionDescription() {
		return attractionDescription;
	}

	public void setAttractionDescription(AttractionDescription attractionDescription) {
		this.attractionDescription = attractionDescription;
	}

	public AttractionTotalInfo(AttractionSimpleInfo attractionSimpleInfo, AttractionDescription attractionDescription) {
		super();
		this.attractionSimpleInfo = attractionSimpleInfo;
		this.attractionDescription = attractionDescription;
	}
	
	
	
}
