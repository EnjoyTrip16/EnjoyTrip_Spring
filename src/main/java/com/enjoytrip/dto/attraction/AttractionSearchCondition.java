package com.enjoytrip.dto.attraction;

public class AttractionSearchCondition {
	
	//관광지에 해당하는 PK
	private Long attractionId;
	
	//관광지에 해당하는 시도 코드
	private Integer sidoCode;
	
	//관광지에 해당하는 구군 코드
	private Integer gugunCode;
	
	//관광지 종류에 해당하는 코드
	private Long attractionTypeId;
	
	//관광지명을 통한 검색 키워드
	private String keywordTitle;
	
	//관광지 종류명을 통한 검색 키워드
	private String keywordAttractionType;
	
	private AttractionSortOrder sortOrder;
	
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

	public Long getAttractionTypeId() {
		return attractionTypeId;
	}

	public void setAttractionTypeId(Long attractionTypeId) {
		this.attractionTypeId = attractionTypeId;
	}

	public String getKeywordTitle() {
		return keywordTitle;
	}

	public void setKeywordTitle(String keywordTitle) {
		this.keywordTitle = keywordTitle;
	}

	public String getKeywordAttractionType() {
		return keywordAttractionType;
	}

	public void setKeywordAttractionType(String keywordAttractionType) {
		this.keywordAttractionType = keywordAttractionType;
	}

	public AttractionSortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(AttractionSortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	public Long getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(Long attractionId) {
		this.attractionId = attractionId;
	}

	@Override
	public String toString() {
		return "AttractionSearchCondition [sidoCode=" + sidoCode + ", gugunCode=" + gugunCode + ", attractionTypeId="
				+ attractionTypeId + ", keywordTitle=" + keywordTitle + ", keywordAttractionType="
				+ keywordAttractionType + ", sortOrder=" + sortOrder + "]";
	}
	
}
