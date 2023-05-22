package com.enjoytrip.dao.plan;

import java.util.List;

import com.enjoytrip.dto.plan.PlanComment;
import com.enjoytrip.dto.plan.PlanSearchCondition;

public interface PlanCommentDao {
	
	public List<PlanComment> retrievePlanComment(PlanSearchCondition planSearchCondition);
	
	public Long deletePlanComment(PlanSearchCondition planSearchCondition);
	
	public Long updatePlanComment(PlanComment planComment);
	
	public Long createPlanComment(PlanComment planComment);
}
