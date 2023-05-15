package com.enjoytrip.dto.plan;

public class PlanTag {
	
	//plan_memo_tag PK
	private Long tagId;
	
	//plan_memo_tag tag_name
	private String tagName;

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "PlanTag [tagId=" + tagId + ", tagName=" + tagName + "]";
	}
	
}
