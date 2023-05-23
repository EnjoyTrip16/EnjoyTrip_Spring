package com.enjoytrip.dto.plan.response;

import java.util.List;

import com.enjoytrip.dto.attraction.AttractionType;
import com.enjoytrip.dto.plan.PlanSimpleInfo;

public class PlanThumbnail {
	
	private PlanSimpleInfo planSimpleInfo;
	
	private String planImage;
	
	private List<String> planTagList;

	public PlanSimpleInfo getPlanSimpleInfo() {
		return planSimpleInfo;
	}

	public void setPlanSimpleInfo(PlanSimpleInfo planSimpleInfo) {
		this.planSimpleInfo = planSimpleInfo;
	}

	public String getPlanImage() {
		return planImage;
	}

	public void setPlanImage(String planImage) {
		this.planImage = planImage;
	}

	public List<String> getPlanTagList() {
		return planTagList;
	}

	public void setPlanTagList(List<String> planTagList) {
		this.planTagList = planTagList;
	}

	@Override
	public String toString() {
		return "PlanThumbnail [planSimpleInfo=" + planSimpleInfo + ", planImage=" + planImage + ", planTagList="
				+ planTagList + "]";
	}
	
	
}
