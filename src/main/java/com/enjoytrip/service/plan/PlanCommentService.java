package com.enjoytrip.service.plan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.plan.PlanCommentDao;
import com.enjoytrip.dao.plan.PlanDao;
import com.enjoytrip.dto.plan.Plan;
import com.enjoytrip.dto.plan.PlanComment;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.request.PlanTotalRequest;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;

@Service
public class PlanCommentService {

	private PlanDao planDao;
	private PlanCommentDao planCommentDao;
	
	@Autowired	
	public PlanCommentService(PlanDao planDao, PlanCommentDao planCommentDao) {
		super();
		this.planDao = planDao;
		this.planCommentDao = planCommentDao;
	}
	

	@Transactional
	public Long createPlanComment(PlanComment planComment) throws PlanException,BadParameterException {
		if(planComment.getPlanId()==null || planComment.getCommentId()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(planComment.getPlanId());
		List<Plan> planList = planDao.retrievePlan(planSearchCondition);
		if(planList.isEmpty()) {
			throw new BadParameterException("존재하지 않는 planId");
		}
		Long resultRow = planCommentDao.createPlanComment(planComment);
		if(resultRow!=1L) {
			throw new PlanException("잘못된 계획-관광지 생성");
		}
		return planComment.getCommentId();
	}
	@Transactional
	public List<PlanComment> retrieveplanComment(PlanTotalRequest planTotalRequest) throws PlanException,BadParameterException {
		if(planTotalRequest.getPlanId()==null && planTotalRequest.getAttractionIdList()==null && planTotalRequest.getCommentId()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(planTotalRequest.getPlanId());
		planSearchCondition.setAuthorUserId(planTotalRequest.getAuthorUserId());
		planSearchCondition.setCommentId(planTotalRequest.getCommentId());
		List<PlanComment> planComments = planCommentDao.retrievePlanComment(planSearchCondition);
		if(planComments==null) {
			throw new PlanException("잘못된 계획-관광지 생성");
		}
		return planComments;
	}	
	
	@Transactional
	public void updateplanComment(PlanComment planComment) throws PlanException,BadParameterException {
		if(planComment.getCommentId()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		Long resultRow = planCommentDao.updatePlanComment(planComment);
		if(resultRow!=1L) {
			throw new PlanException("수정된 정보가 없습니다.");
		}
	}

	@Transactional
	public void deleteplanComment(PlanTotalRequest planTotalRequest) throws PlanException,BadParameterException {
		if(planTotalRequest.getCommentId()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		
		planSearchCondition.setAttractionIdList(planTotalRequest.getAttractionIdList());
		planSearchCondition.setCommentId(planTotalRequest.getCommentId());
		Long resultRow = planCommentDao.deletePlanComment(planSearchCondition);
		if(resultRow == 0L) {
			throw new PlanException("잘못된 계획-관광지 삭제");
		}
	}	

	
}
