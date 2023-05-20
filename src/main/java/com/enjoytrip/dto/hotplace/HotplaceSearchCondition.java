package com.enjoytrip.dto.hotplace;

import java.time.LocalDateTime;

// 핫 플레이스 검색 조건 DTO
public class HotplaceSearchCondition {

	// 핫 플레이스 번호 (PK)
	private Long hotplaceId;

	// 사용자 번호 (FK)
	private Long userId;

	// 제목 검색 키워드
	private String keywordTitle;

	// 관광지에 해당하는 시도 코드
	private Integer sidoCode;

	// 관광지에 해당하는 구군 코드
	private Integer gugunCode;

	// 관광지 종류에 해당하는 코드
	private Long attractionTypeId;

	// 관광지 종류명 검색 키워드
	private String keywordAttractionType;

	// 관광지명 검색 키워드
	private String keywordAttractionTitle;

	private HotplaceSortOrder sortOrder;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getKeywordTitle() {
		return keywordTitle;
	}

	public void setKeywordTitle(String keywordTitle) {
		this.keywordTitle = keywordTitle;
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

	public Long getAttractionTypeId() {
		return attractionTypeId;
	}

	public void setAttractionTypeId(Long attractionTypeId) {
		this.attractionTypeId = attractionTypeId;
	}

	public String getKeywordAttractionType() {
		return keywordAttractionType;
	}

	public void setKeywordAttractionType(String keywordAttractionType) {
		this.keywordAttractionType = keywordAttractionType;
	}

	public String getKeywordAttractionTitle() {
		return keywordAttractionTitle;
	}

	public void setKeywordAttractionTitle(String keywordAttractionTitle) {
		this.keywordAttractionTitle = keywordAttractionTitle;
	}

	public HotplaceSortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(HotplaceSortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public String toString() {
		return "HotplaceSearchCondition [hotplaceId=" + hotplaceId + ", userId=" + userId + ", keywordTitle="
				+ keywordTitle + ", sidoCode=" + sidoCode + ", gugunCode=" + gugunCode + ", attractionTypeId="
				+ attractionTypeId + ", keywordAttractionType=" + keywordAttractionType + ", keywordAttractionTitle="
				+ keywordAttractionTitle + ", sortOrder=" + sortOrder + "]";
	}

}
