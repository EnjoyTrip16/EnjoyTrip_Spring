package com.enjoytrip.dto.plan;

import java.sql.Timestamp;
import java.time.LocalDateTime;

//여행계획에 해당하는 관광지에 대한 정보를 담는 DTO
public class PlanAttraction {
	
	//plan table PK plan_attraction FK
	private Long planId;
	
	//attraction table PK plan_attraction FK
	private Long attractionId;
	
	//plan_attraction 여행계획에서의 관광지 방문 순서
	private Integer order;
	
	//plan_attraction 여행계획에서 해당 관광지를 추가한 시간
	private LocalDateTime addedAt;

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public Long getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(Long attractionId) {
		this.attractionId = attractionId;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	
	public LocalDateTime getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(LocalDateTime addedAt) {
		this.addedAt = addedAt;
	}

	@Override
	public String toString() {
		return "PlanAttraction [planId=" + planId + ", attractionId=" + attractionId + ", order=" + order + ", addedAt="
				+ addedAt + "]";
	}
	
}
