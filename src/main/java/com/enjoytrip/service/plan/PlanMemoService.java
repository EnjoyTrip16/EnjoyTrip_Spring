package com.enjoytrip.service.plan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.plan.PlanMemoDao;
import com.enjoytrip.dao.plan.PlanDao;
import com.enjoytrip.dto.plan.Plan;
import com.enjoytrip.dto.plan.PlanMemo;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.request.PlanTotalRequest;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;

@Service
public class PlanMemoService {

	private PlanDao planDao;
	private PlanMemoDao planMemoDao;
	
	@Autowired	
	public PlanMemoService(PlanDao planDao, PlanMemoDao PlanMemoDao) {
		super();
		this.planDao = planDao;
		this.planMemoDao = PlanMemoDao;
	}
	

	@Transactional
	public Long createPlanMemo(PlanMemo planMemo) throws PlanException,BadParameterException {
		if(planMemo.getPlanId()==null || planMemo.getUserId()==null
				|| planMemo.getTagId() ==null|| planMemo.getContent()==null) {
			throw new BadParameterException("PlanId혹은 userId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(planMemo.getPlanId());
		List<Plan> planList = planDao.retrievePlan(planSearchCondition);
		if(planList.isEmpty()) {
			throw new BadParameterException("존재하지 않는 planId");
		}
		Long resultRow = planMemoDao.createPlanMemo(planMemo);
		if(resultRow!=1L) {
			throw new PlanException("잘못된 계획-관광지 생성");
		}
		return planMemo.getPlanMemoId();
	}
	@Transactional
	public List<PlanMemo> retrievePlanMemo(PlanTotalRequest planTotalRequest) throws PlanException,BadParameterException {
		if(planTotalRequest.getPlanId()==null) {
			throw new BadParameterException("PlanId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(planTotalRequest.getPlanId());
		planSearchCondition.setAuthorUserId(planTotalRequest.getAuthorUserId());
		planSearchCondition.setPlanMemoId(planTotalRequest.getPlanMemoId());
		List<PlanMemo> PlanMemos = planMemoDao.retrievePlanMemo(planSearchCondition);
		if(PlanMemos==null) {
			throw new PlanException("잘못된 계획-관광지 생성");
		}
		return PlanMemos;
	}	
	
	@Transactional
	public void updatePlanMemo(PlanMemo planMemo) throws PlanException,BadParameterException {
		if(planMemo.getPlanMemoId()==null) {
			throw new BadParameterException("planMemoId가 필요합니다.");
		}
		Long resultRow = planMemoDao.updatePlanMemo(planMemo);
		if(resultRow!=1L) {
			throw new PlanException("수정된 정보가 없습니다.");
		}
	}

	@Transactional
	public void deletePlanMemo(PlanTotalRequest planTotalRequest) throws PlanException,BadParameterException {
		if(planTotalRequest.getPlanMemoId()!=null) {
			throw new BadParameterException("planMemoId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		
		planSearchCondition.setAttractionIdList(planTotalRequest.getAttractionIdList());
		planSearchCondition.setPlanMemoId(planTotalRequest.getPlanMemoId());
		Long resultRow = planMemoDao.deletePlanMemo(planSearchCondition);
		if(resultRow == 0L || resultRow==null) {
			throw new PlanException("잘못된 계획-관광지 삭제");
		}
	}	

	
}
