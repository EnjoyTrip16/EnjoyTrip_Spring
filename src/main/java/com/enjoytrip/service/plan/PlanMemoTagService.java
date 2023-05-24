package com.enjoytrip.service.plan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.plan.PlanAttractionDao;
import com.enjoytrip.dao.plan.PlanDao;
import com.enjoytrip.dao.plan.PlanMemoTagDao;
import com.enjoytrip.dto.plan.Plan;
import com.enjoytrip.dto.plan.PlanAttraction;
import com.enjoytrip.dto.plan.PlanMemoTag;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.request.PlanTotalRequest;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;

@Service
public class PlanMemoTagService {

	private PlanDao planDao;
	private PlanMemoTagDao planMemoTagDao;
	
	
	@Autowired
	public PlanMemoTagService(PlanDao planDao, PlanMemoTagDao planMemoTagDao) {
		super();
		this.planDao = planDao;
		this.planMemoTagDao = planMemoTagDao;
	}
	
	@Transactional
	public Long createPlanMemoTag(PlanMemoTag planMemoTag) throws PlanException,BadParameterException {
		if(planMemoTag.getTagName()==null) {
			throw new BadParameterException("태그명이 필요합니다.");
		}
		Long resultRow = planMemoTagDao.createPlanMemoTag(planMemoTag);
		if(resultRow!=1L) {
			throw new PlanException("잘못된 계획-메모 태그 생성");
		}
		return planMemoTag.getTagId();
	}
	@Transactional
	public List<PlanMemoTag> retrievePlanMemoTag(PlanTotalRequest planTotalRequest) throws PlanException,BadParameterException {
		if(planTotalRequest.getTagId()!=null && planTotalRequest.getTagName()!=null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		
		planSearchCondition.setTagName(planTotalRequest.getTagName());
		planSearchCondition.setTagId(planTotalRequest.getTagId());
		List<PlanMemoTag> planMemoTag = planMemoTagDao.retrievePlanMemoTag(planSearchCondition);
		if(planMemoTag==null) {
			throw new PlanException("잘못된 계획-관광지 생성");
		}
		return planMemoTag;
	}	
	
	@Transactional
	public void updatePlanMemoTag(PlanMemoTag planMemoTag) throws PlanException,BadParameterException {
		if(planMemoTag.getTagId()==null) {
			throw new BadParameterException("tagId가 필요합니다.");
		}
		Long resultRow = planMemoTagDao.updatePlanMemoTag(planMemoTag);
		if(resultRow!=1L) {
			throw new PlanException("수정된 정보가 없습니다.");
		}
	}

	@Transactional
	public void deletePlanMemoTag(PlanTotalRequest planTotalRequest) throws PlanException,BadParameterException {
		if(planTotalRequest.getTagId()==null) {
			throw new BadParameterException("PlanId혹은 AttractionId가 필요합니다.");
		}
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setTagId(planTotalRequest.getTagId());
		Long resultRow = planMemoTagDao.deletePlanMemoTag(planSearchCondition);
		if(resultRow == 0L) {
			throw new PlanException("잘못된 계획-메모-태그 삭제");
		}
	}	

	
}
