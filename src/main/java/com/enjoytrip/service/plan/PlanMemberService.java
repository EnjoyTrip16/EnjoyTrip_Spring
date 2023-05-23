package com.enjoytrip.service.plan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.plan.PlanAttractionDao;
import com.enjoytrip.dao.plan.PlanDao;
import com.enjoytrip.dao.plan.PlanMemberDao;
import com.enjoytrip.dto.plan.Plan;
import com.enjoytrip.dto.plan.PlanAttraction;
import com.enjoytrip.dto.plan.PlanMember;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.request.PlanTotalRequest;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;

@Service
public class PlanMemberService {

	private PlanDao planDao;
	private PlanMemberDao planMemberDao;
	
	public PlanMemberService(PlanDao planDao, PlanMemberDao planMemberDao) {
		super();
		this.planDao = planDao;
		this.planMemberDao = planMemberDao;
	}
	
	@Transactional
	public void createPlanMember(PlanMember planMember) throws PlanException,BadParameterException {
		if(planMember.getPlanId()==null || planMember.getUserId()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(planMember.getPlanId());
		List<Plan> planList = planDao.retrievePlan(planSearchCondition);
		if(planList.isEmpty()) {
			throw new BadParameterException("존재하지 않는 planId");
		}
		Long resultRow = planMemberDao.createPlanMember(planMember);
		if(resultRow!=1L) {
			throw new PlanException("잘못된 계획-멤버 생성");
		}
	}
	@Transactional
	public List<PlanMember> retrievePlanMember(PlanTotalRequest planTotalRequest) throws PlanException,BadParameterException {
		if(planTotalRequest.getPlanId()==null && planTotalRequest.getMemberUserId()==null) {
			throw new BadParameterException("PlanId혹은 memberUserId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setMemberUserId(planTotalRequest.getMemberUserId());
		planSearchCondition.setPlanId(planTotalRequest.getPlanId());
		List<PlanMember> planAttractions = planMemberDao.retrievePlanMember(planSearchCondition);
		if(planAttractions==null) {
			throw new PlanException("잘못된 계획-멤버 생성");
		}
		return planAttractions;
	}	
	
	@Transactional
	public void updatePlanMember(PlanMember planMember) throws PlanException,BadParameterException {
		if(planMember.getPlanId()==null || planMember.getUserId()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		Long resultRow = planMemberDao.updatePlanMember(planMember);
		if(resultRow!=1L) {
			throw new PlanException("수정된 정보가 없습니다.");
		}
	}

	@Transactional
	public void deletePlanMember(PlanTotalRequest planTotalRequest) throws PlanException,BadParameterException {
		if(planTotalRequest.getPlanId()==null && planTotalRequest.getMemberUserId()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		
		planSearchCondition.setMemberUserId(planTotalRequest.getMemberUserId());
		planSearchCondition.setPlanId(planTotalRequest.getPlanId());
		Long resultRow = planMemberDao.deletePlanMember(planSearchCondition);
		if(resultRow == 0L) {
			throw new PlanException("잘못된 계획-멤버 삭제");
		}
	}	

	
}
