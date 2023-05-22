package com.enjoytrip.dao.plan;

import java.util.List;

import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.PlanSimpleInfo;

public interface PlanSimpleInfoDao {
	public List<PlanSimpleInfo> retrievePlanSimpleInfo(PlanSearchCondition planSearchCondition);
}
