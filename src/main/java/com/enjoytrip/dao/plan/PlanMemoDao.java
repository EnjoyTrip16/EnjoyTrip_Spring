package com.enjoytrip.dao.plan;

import java.util.List;

import com.enjoytrip.dto.plan.PlanMemo;
import com.enjoytrip.dto.plan.PlanSearchCondition;

public interface PlanMemoDao {
	
	public List<PlanMemo> retrievePlanMemo(PlanSearchCondition planSearchCondition);
	
	public Long updatePlanMemo(PlanMemo planMemo);
	
	public Long deletePlanMemo(PlanSearchCondition planSearchCondition);
	
	public Long createPlanMemo(PlanMemo planMemo);
}
