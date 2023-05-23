package com.enjoytrip.service.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.plan.PlanAttractionDao;
import com.enjoytrip.dao.plan.PlanCommentDao;
import com.enjoytrip.dao.plan.PlanDao;
import com.enjoytrip.dao.plan.PlanMemberDao;
import com.enjoytrip.dao.plan.PlanMemoDao;
import com.enjoytrip.dao.plan.PlanMemoTagDao;
import com.enjoytrip.dao.plan.PlanUserBookmarkFavorDao;
import com.enjoytrip.dto.plan.Plan;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;

@Service
public class PlanService {
	
	private PlanDao planDao;
	
	private PlanUserBookmarkFavorDao planUserBookmarkFavorDao;
	
	private PlanMemberDao planMemberDao;
	
	private PlanAttractionDao planAttractionDao;
	
	private PlanCommentDao planCommentDao;
	
	private PlanMemoDao planMemoDao;

	
	@Autowired
	public PlanService(PlanDao planDao, PlanUserBookmarkFavorDao planUserBookmarkFavorDao, PlanMemberDao planMemberDao,
			PlanAttractionDao planAttractionDao, PlanCommentDao planCommentDao, PlanMemoDao planMemoDao,
			PlanMemoTagDao planMemoTagDao) {
		super();
		this.planDao = planDao;
		this.planUserBookmarkFavorDao = planUserBookmarkFavorDao;
		this.planMemberDao = planMemberDao;
		this.planAttractionDao = planAttractionDao;
		this.planCommentDao = planCommentDao;
		this.planMemoDao = planMemoDao;
	}
	
	@Transactional
	public Long createPlan(Plan plan) throws BadParameterException,PlanException {
		if(plan.getUserId()==null ||
				plan.getPlanName()==null || plan.getVisibility()==null) {
			throw new BadParameterException("userId planId planName이 필요합니다.");
		}
		Long resultRow = planDao.createPlan(plan);
		if(resultRow!=1L) {
			throw new PlanException("계획 생성 실패");
		}
		return plan.getPlanId();
	}
	
	@Transactional
	public Long updataePlan(Plan plan) {
		if(plan.getPlanId()==null) {
			throw new BadParameterException("planId가 필요합니다.");
		}
		return planDao.updatePlan(plan);
	}
	
	@Transactional
	public void deletePlan(Plan plan) throws BadParameterException{
		
		if(plan.getPlanId()==null) 
			throw new BadParameterException("plan값의 planId가 잘못됨");
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(plan.getPlanId());
		try {
			planDao.deletePlan(planSearchCondition);
			planMemberDao.deletePlanMember(planSearchCondition);
			planMemoDao.deletePlanMemo(planSearchCondition);
			planAttractionDao.deletePlanAttraction(planSearchCondition);
			planUserBookmarkFavorDao.deletePlanUserBookmarkFavor(planSearchCondition);
			planCommentDao.deletePlanComment(planSearchCondition);
		}
		catch(RuntimeException e) {
			throw(e);
		}
	}	
	
}
