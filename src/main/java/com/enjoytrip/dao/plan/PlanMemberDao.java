package com.enjoytrip.dao.plan;

import java.util.List;

import com.enjoytrip.dto.plan.PlanMember;
import com.enjoytrip.dto.plan.PlanSearchCondition;

public interface PlanMemberDao {
	
	public List<PlanMember> retrievePlanMember(PlanSearchCondition planSearchCondition);
	
	public Long createPlanMember(PlanMember planMember);
	
	public Long updatePlanMember(PlanMember planMember);
	
	public Long deletePlanMember(PlanSearchCondition planSearchCondition);
}
