package com.enjoytrip.service.attraction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.attraction.AttractionDescriptionDao;
import com.enjoytrip.dao.attraction.AttractionSimpleInfoDao;
import com.enjoytrip.dto.attraction.AttractionDescription;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionSimpleInfo;
import com.enjoytrip.dto.plan.response.AttractionTotalInfo;
import com.enjoytrip.exception.AttractionException;
@Service
public class AttractionRetrieveService {

	AttractionSimpleInfoDao attractionSimpleInfoDao;
	AttractionDescriptionDao attractionDescriptionDao;
	
	@Autowired
	public AttractionRetrieveService(AttractionSimpleInfoDao attractionSimpleInfoDao,
			AttractionDescriptionDao attractionDescriptionDao) {
		super();
		this.attractionSimpleInfoDao = attractionSimpleInfoDao;
		this.attractionDescriptionDao = attractionDescriptionDao;
	}
	
	@Transactional
	public List<AttractionSimpleInfo> retrieveSimpleInfo(
			AttractionSearchCondition attractionSearchCondition
	) {
		List<AttractionSimpleInfo> attractionSimpleInfos = 
				attractionSimpleInfoDao.retrieveAttractionSimpleInfo(attractionSearchCondition);
		return attractionSimpleInfos;
	}

	@Transactional
	public AttractionTotalInfo retrieveTotalInfo(
			AttractionSearchCondition attractionSearchCondition
	) throws AttractionException{
		AttractionTotalInfo attractionTotalInfo = new AttractionTotalInfo();
		
		List<AttractionSimpleInfo> attractionSimpleInfos = attractionSimpleInfoDao
				.retrieveAttractionSimpleInfo(attractionSearchCondition);
		
		List<AttractionDescription> attractionDescriptions = attractionDescriptionDao.
				retrieveAttractionDescription(attractionSearchCondition);
		if(attractionSimpleInfos.size()!=1) {
			throw new AttractionException("잘못된 관광지 상세검색");
		}
		if(attractionDescriptions.isEmpty()) {
			AttractionDescription attractionDescription = new AttractionDescription();
			attractionDescription.setAttractionId(attractionSearchCondition.getAttractionId());
			attractionDescription.setHomepage("");
			attractionDescription.setOverview("");
			attractionDescriptions.add(attractionDescription);
		}
		attractionTotalInfo.setAttractionDescription(attractionDescriptions.get(0));
		attractionTotalInfo.setAttractionSimpleInfo(attractionSimpleInfos.get(0));
		return attractionTotalInfo;
	}
	
}
