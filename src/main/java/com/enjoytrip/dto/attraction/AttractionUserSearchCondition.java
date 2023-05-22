package com.enjoytrip.dto.attraction;

import java.util.List;

public class AttractionUserSearchCondition {
	
	private Long userId;
	
	private List<Long> attractionIdList;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getAttractionIdList() {
		return attractionIdList;
	}

	public void setAttractionIdList(List<Long> attractionIdList) {
		this.attractionIdList = attractionIdList;
	}

	@Override
	public String toString() {
		return "AttractionUserSearchCondition [userId=" + userId + ", attractionIdList=" + attractionIdList + "]";
	}
	
	
}
