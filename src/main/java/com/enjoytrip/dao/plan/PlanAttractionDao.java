package com.enjoytrip.dao.plan;

import java.util.List;

import com.enjoytrip.dto.plan.PlanAttraction;
import com.enjoytrip.dto.plan.PlanSearchCondition;

public interface PlanAttractionDao {
	
	public List<PlanAttraction> retrievePlanAttraction(PlanSearchCondition planSearchCondition);
	
	public Long createPlanAttraction(PlanAttraction planAttraction);
	
	public Long updatePlanAttraction(PlanAttraction planAttraction);
	
	public Long deletePlanAttraction(PlanSearchCondition planSearchCondition);
	
}
