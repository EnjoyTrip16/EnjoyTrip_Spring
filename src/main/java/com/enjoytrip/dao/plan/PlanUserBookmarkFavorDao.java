package com.enjoytrip.dao.plan;

import java.util.List;

import com.enjoytrip.dto.plan.PlanUserBookmarkFavor;
import com.enjoytrip.dto.plan.PlanSearchCondition;

public interface PlanUserBookmarkFavorDao {
	
	public List<PlanUserBookmarkFavor> retrievePlanUserBookmarkFavor(PlanSearchCondition aUserSearchCondition);
	
	public Long updatePlanUserBookmarkFavor(PlanUserBookmarkFavor PlanUserBookmarkFavor);
	
	public Long deletePlanUserBookmarkFavor(PlanSearchCondition aUserSearchCondition);
	
	public Long createPlanUserBookmarkFavor(PlanUserBookmarkFavor PlanUserBookmarkFavor);
	
}
