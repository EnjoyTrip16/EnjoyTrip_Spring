package com.enjoytrip.dto.plan;

import java.util.List;

public class PlanSearchCondition {
	
	private Long authorUserId;
	
	private Long planId;
	
	private List<String> tagNameList;
	
	private List<Long> tagIdList;
	
	private Long memberUserId;
	
	private String planName;
	
	private List<Long> attractionIdList;
	
	private PlanVisibility visibility;
	
	private Integer index=0;
	
	private Integer pageSize=10;
	
	private PlanSearchOrder planSearchOrder = PlanSearchOrder.DICTIONARY_ASC;

	public Long getAuthorUserId() {
		return authorUserId;
	}

	public void setAuthorUserId(Long authorUserId) {
		this.authorUserId = authorUserId;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public List<String> getTagNameList() {
		return tagNameList;
	}

	public void setTagNameList(List<String> tagNameList) {
		this.tagNameList = tagNameList;
	}

	public List<Long> getTagIdList() {
		return tagIdList;
	}

	public void setTagIdList(List<Long> tagIdList) {
		this.tagIdList = tagIdList;
	}

	public Long getMemberUserId() {
		return memberUserId;
	}

	public void setMemberUserId(Long memberUserId) {
		this.memberUserId = memberUserId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public List<Long> getAttractionIdList() {
		return attractionIdList;
	}

	public void setAttractionIdList(List<Long> attractionIdList) {
		this.attractionIdList = attractionIdList;
	}

	public PlanVisibility getVisibility() {
		return visibility;
	}

	public void setVisibility(PlanVisibility visibility) {
		this.visibility = visibility;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public PlanSearchOrder getPlanSearchOrder() {
		return planSearchOrder;
	}

	public void setPlanSearchOrder(PlanSearchOrder planSearchOrder) {
		this.planSearchOrder = planSearchOrder;
	}

	@Override
	public String toString() {
		return "PlanSearchCondition [authorUserId=" + authorUserId + ", planId=" + planId + ", tagNameList="
				+ tagNameList + ", tagIdList=" + tagIdList + ", memberUserId=" + memberUserId + ", planName=" + planName
				+ ", attractionIdList=" + attractionIdList + ","
				+ ", visibility=" + visibility + ", index=" + index + ", pageSize=" + pageSize + ", planSearchOrder="
				+ planSearchOrder + "]";
	}
	
	
}
