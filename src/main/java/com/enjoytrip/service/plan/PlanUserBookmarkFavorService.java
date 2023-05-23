package com.enjoytrip.service.plan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.plan.PlanDao;
import com.enjoytrip.dao.plan.PlanUserBookmarkFavorDao;
import com.enjoytrip.dto.plan.Plan;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.PlanUserBookmarkFavor;
import com.enjoytrip.dto.plan.request.PlanTotalRequest;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;

@Service
public class PlanUserBookmarkFavorService {

	private PlanDao planDao;
	private PlanUserBookmarkFavorDao planUserBookmarkFavorDao;
	
	@Autowired
	public PlanUserBookmarkFavorService(PlanDao planDao, PlanUserBookmarkFavorDao planUserBookmarkFavorDao) {
		super();
		this.planDao = planDao;
		this.planUserBookmarkFavorDao = planUserBookmarkFavorDao;
	}
	
	@Transactional
	public void createPlanUserBookmarkFavorDao(PlanUserBookmarkFavor planUserBookmarkFavor) throws PlanException,BadParameterException {
		if(planUserBookmarkFavor.getPlanId()==null || planUserBookmarkFavor.getUserId()==null) {
			throw new BadParameterException("PlanId와 userId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(planUserBookmarkFavor.getPlanId());
		List<Plan> planList = planDao.retrievePlan(planSearchCondition);
		if(planList.isEmpty()) {
			throw new BadParameterException("존재하지 않는 planId");
		}
		Long resultRow = planUserBookmarkFavorDao
				.createPlanUserBookmarkFavor(planUserBookmarkFavor);
		if(resultRow!=1L) {
			throw new PlanException("잘못된 계획-관광지 생성");
		} 
	}
	@Transactional
	public List<PlanUserBookmarkFavor> retrievePlanUserBookmarkFavor(PlanTotalRequest planTotalRequest) throws PlanException,BadParameterException {
		if(planTotalRequest.getPlanId()==null && planTotalRequest.getAuthorUserId()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(planTotalRequest.getPlanId());
		planSearchCondition.setAuthorUserId(planTotalRequest.getAuthorUserId());
		List<PlanUserBookmarkFavor> planUserBookmarkFavors= planUserBookmarkFavorDao
				.retrievePlanUserBookmarkFavor(planSearchCondition);
		if(planUserBookmarkFavors==null) {
			throw new PlanException("잘못된 계획-관광지 생성");
		}
		return planUserBookmarkFavors;
	}	
	
	@Transactional
	public void updatePlanUserBookmarkFavor(PlanUserBookmarkFavor planUserBookmarkFavor) throws PlanException,BadParameterException {
		if(planUserBookmarkFavor.getPlanId()==null || planUserBookmarkFavor.getUserId()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		Long resultRow = planUserBookmarkFavorDao
				.updatePlanUserBookmarkFavor(planUserBookmarkFavor);
		if(resultRow!=1L) {
			throw new PlanException("수정된 정보가 없습니다.");
		}
	}

	@Transactional
	public void deletePlanUserBookmarkFavor(PlanTotalRequest planTotalRequest) throws PlanException,BadParameterException {
		if(planTotalRequest.getPlanId()==null || planTotalRequest.getAuthorUserId()!=null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setAuthorUserId(planTotalRequest.getAuthorUserId());
		planSearchCondition.setPlanId(planTotalRequest.getPlanId());
		Long resultRow = planUserBookmarkFavorDao
				.deletePlanUserBookmarkFavor(planSearchCondition);
		if(resultRow == 0L) {
			throw new PlanException("잘못된 계획-관광지 삭제");
		}
	}	
}
