package com.enjoytrip.service.plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.attraction.AttractionDao;
import com.enjoytrip.dao.attraction.AttractionInfoDao;
import com.enjoytrip.dao.attraction.AttractionTypeDao;
import com.enjoytrip.dao.plan.PlanAttractionDao;
import com.enjoytrip.dao.plan.PlanCommentDao;
import com.enjoytrip.dao.plan.PlanDao;
import com.enjoytrip.dao.plan.PlanMemberDao;
import com.enjoytrip.dao.plan.PlanMemoDao;
import com.enjoytrip.dao.plan.PlanSimpleInfoDao;
import com.enjoytrip.dao.plan.PlanUserBookmarkFavorDao;
import com.enjoytrip.dto.attraction.Attraction;
import com.enjoytrip.dto.attraction.AttractionInfo;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionType;
import com.enjoytrip.dto.plan.PlanAttraction;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.PlanSimpleInfo;
import com.enjoytrip.dto.plan.request.PlanThumbnailRequest;
import com.enjoytrip.dto.plan.response.PlanThumbnail;

@Service
public class PlanRetrieveService {

	private AttractionDao attractionDao;
	
	private PlanAttractionDao planAttractionDao;
	
	private PlanSimpleInfoDao planSimpleInfoDao;
	
	private AttractionTypeDao attractionTypeDao;
	
	private AttractionInfoDao attractionInfoDao;
	
	public PlanRetrieveService(AttractionDao attractionDao, PlanAttractionDao planAttractionDao, PlanCommentDao planCommentDao,
			PlanDao planDao, PlanMemberDao planMemberDao, PlanMemoDao planMemoDao, PlanSimpleInfoDao planSimpleInfoDao,
			PlanUserBookmarkFavorDao planUserBookmarkFavorDao, AttractionTypeDao attractionTypeDao,
			AttractionInfoDao attractionInfoDao) {
		super();
		this.attractionDao = attractionDao;
		this.planAttractionDao = planAttractionDao;
		this.planSimpleInfoDao = planSimpleInfoDao;
		this.attractionTypeDao = attractionTypeDao;
		this.attractionInfoDao = attractionInfoDao;
	}



	@Transactional
	public List<PlanThumbnail> getPlanThumbnail(PlanThumbnailRequest planThumbnailRequest) {
		List<PlanThumbnail> planThumbnails = new ArrayList<>();

		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		
		if(planThumbnailRequest.getAuthorUserId()!=null) {
			planSearchCondition.setAuthorUserId(
						planThumbnailRequest.getAuthorUserId()
					);
		}
		
		if(planThumbnailRequest.getAttractionIdList()!=null) {
			planSearchCondition.setAttractionIdList(
					planThumbnailRequest.getAttractionIdList()
			);
		}
		
		if(planThumbnailRequest.getMemberUserId()!=null) {
			planSearchCondition.setMemberUserId(
					planThumbnailRequest.getMemberUserId()
			);
		}
		
		if(planThumbnailRequest.getPlanName()!=null) {
			planSearchCondition.setPlanName(
					planThumbnailRequest.getPlanName()
			);
		}
		
		if(planThumbnailRequest.getIndex()!=null) {
			planSearchCondition.setIndex(
					planThumbnailRequest.getIndex()
			);
		}
		
		if(planThumbnailRequest.getPageSize()!=null) {
			planSearchCondition.setPageSize(
					planThumbnailRequest.getPageSize()
			);
		}
		
		if(planThumbnailRequest.getPlanSearchOrder()!=null) {
			planSearchCondition.setPlanSearchOrder(
					planThumbnailRequest.getPlanSearchOrder()
			);
		}		
		
		//관광지 ID 관광지 타입 매핑
		Map<Long,String> attractionTypeIdMap = new HashMap<>();
		
		AttractionSearchCondition emptyCondition = new AttractionSearchCondition();
		
		List<AttractionType> attractionTypeList = attractionTypeDao.retrieveAttractionType(emptyCondition);
		
		for(AttractionType attractionType : attractionTypeList) {
			attractionTypeIdMap.put(
					attractionType.getAttractionTypeId(), attractionType.getAttractionType()
			);
		}
		
		//관광지 간단 정보
		List<PlanSimpleInfo> planSimpleInfos = planSimpleInfoDao.retrievePlanSimpleInfo(planSearchCondition);
		
		for(PlanSimpleInfo planSimpleInfo : planSimpleInfos) {
			
			PlanSearchCondition planAttractionSearchCondition = new PlanSearchCondition();
			planAttractionSearchCondition.setPlanId(planSimpleInfo.getPlanId());
			List<PlanAttraction> planAttractionList = 
					planAttractionDao.retrievePlanAttraction(planAttractionSearchCondition);
			Set<Long> attractionTypeIdList = new HashSet<>(); 
			
			String planImage = "";
			
			for(PlanAttraction planAttraction : planAttractionList) {
				AttractionSearchCondition attractionIdCondition = new AttractionSearchCondition();
				attractionIdCondition.setAttractionId(planAttraction.getAttractionId());
				List<Attraction> attractionList = attractionDao.retrieveAttraction(attractionIdCondition);
				
				List<AttractionInfo> attractionInfoList = attractionInfoDao.retrieveAttractionInfo(attractionIdCondition);
				
				if(!attractionList.isEmpty()) {
					Attraction attraction = attractionList.get(0);
					
					attractionTypeIdList.add(attraction.getattractionTypeId());
				}
				
				if(!attractionInfoList.isEmpty()) {
					AttractionInfo attractionInfo = attractionInfoList.get(0);
				
					String firstImage = attractionInfo.getFirstImage();
					if(firstImage != null && firstImage !="") {
						planImage = firstImage;
					}
				}
				
			}
			
			
			
			PlanThumbnail planThumbnail = new PlanThumbnail();
			planThumbnail.setPlanSimpleInfo(planSimpleInfo);
			List<String> planTagList = new ArrayList<>();
			
			for(Long attractionTypeId : attractionTypeIdList) {
				if(!attractionTypeIdMap.containsKey(attractionTypeId)) continue;
				planTagList.add(attractionTypeIdMap.get(attractionTypeId));
			}
			planThumbnail.setPlanTagList(planTagList);
			
			planThumbnail.setPlanImage(planImage);
			
			planThumbnails.add(planThumbnail);
		}
		
		return planThumbnails;
	}
	
	
	
}
