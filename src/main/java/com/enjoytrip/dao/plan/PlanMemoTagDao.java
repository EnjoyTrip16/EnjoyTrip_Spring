package com.enjoytrip.dao.plan;

import java.util.List;

import com.enjoytrip.dto.plan.PlanMemoTag;
import com.enjoytrip.dto.plan.PlanSearchCondition;

public interface PlanMemoTagDao {
	
	public List<PlanMemoTag> retrievePlanMemoTag(PlanSearchCondition planSearchCondition);
	
	public Long createPlanMemoTag(PlanMemoTag planMemoTag);	
	
	public Long updatePlanMemoTag(PlanMemoTag planMemoTag);	
	
	public Long deletePlanMemoTag(PlanSearchCondition planSearchCondition);
}
