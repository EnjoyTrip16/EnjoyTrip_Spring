package com.enjoytrip.service.plan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.plan.PlanAttractionDao;
import com.enjoytrip.dao.plan.PlanDao;
import com.enjoytrip.dto.plan.Plan;
import com.enjoytrip.dto.plan.PlanAttraction;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.request.PlanTotalRequest;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;

@Service
public class PlanAttractionService {

	private PlanDao planDao;
	private PlanAttractionDao planAttractionDao;
	
	@Autowired
	public PlanAttractionService(PlanDao planDao, PlanAttractionDao planAttractionDao) {
		super();
		this.planDao = planDao;
		this.planAttractionDao = planAttractionDao;
	}

	@Transactional
	public void createPlanAttraction(PlanAttraction planAttraction) throws PlanException,BadParameterException {
		if(planAttraction.getPlanId()==null || planAttraction.getAttractionId()==null || planAttraction.getAddedAt()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(planAttraction.getPlanId());
		List<Plan> planList = planDao.retrievePlan(planSearchCondition);
		if(planList.isEmpty()) {
			throw new BadParameterException("존재하지 않는 planId");
		}
		Long resultRow = planAttractionDao.createPlanAttraction(planAttraction);
		if(resultRow!=1L) {
			throw new PlanException("잘못된 계획-관광지 생성");
		}
	}
	@Transactional
	public List<PlanAttraction> retrievePlanAttraction(PlanTotalRequest planTotalRequest) throws PlanException,BadParameterException {
		if(planTotalRequest.getPlanId()==null && planTotalRequest.getAttractionIdList()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		
		planSearchCondition.setAttractionIdList(planTotalRequest.getAttractionIdList());
		planSearchCondition.setPlanId(planTotalRequest.getPlanId());
		List<PlanAttraction> planAttractions = planAttractionDao.retrievePlanAttraction(planSearchCondition);
		if(planAttractions==null) {
			throw new PlanException("잘못된 계획-관광지 생성");
		}
		return planAttractions;
	}	
	
	@Transactional
	public void updatePlanAttraction(PlanAttraction planAttraction) throws PlanException,BadParameterException {
		if(planAttraction.getPlanId()==null || planAttraction.getAttractionId()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		Long resultRow = planAttractionDao.updatePlanAttraction(planAttraction);
		if(resultRow!=1L) {
			throw new PlanException("수정된 정보가 없습니다.");
		}
	}

	@Transactional
	public void deletePlanAttraction(PlanTotalRequest planTotalRequest) throws PlanException,BadParameterException {
		if(planTotalRequest.getPlanId()==null && planTotalRequest.getAttractionIdList()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		
		planSearchCondition.setAttractionIdList(planTotalRequest.getAttractionIdList());
		planSearchCondition.setPlanId(planTotalRequest.getPlanId());
		Long resultRow = planAttractionDao.deletePlanAttraction(planSearchCondition);
		if(resultRow == 0L) {
			throw new PlanException("잘못된 계획-관광지 삭제");
		}
	}	

	
}
