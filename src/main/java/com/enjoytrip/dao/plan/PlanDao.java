package com.enjoytrip.dao.plan;

import java.util.List;

import com.enjoytrip.dto.plan.Plan;
import com.enjoytrip.dto.plan.PlanSearchCondition;

public interface PlanDao {
	
	public List<Plan> retrievePlan(PlanSearchCondition planSearchCondition);
	
	public Long createPlan(Plan plan);
	
	public Long updatePlan(Plan plan);
	
	public Long deletePlan(PlanSearchCondition planSearchCondition);
}
