package com.enjoytrip.service.attraction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.attraction.AttractionDao;
import com.enjoytrip.dao.attraction.AttractionDescriptionDao;
import com.enjoytrip.dao.attraction.AttractionInfoDao;
import com.enjoytrip.dao.attraction.AttractionModifyRequestDao;
import com.enjoytrip.dao.attraction.SidoGugunDao;
import com.enjoytrip.dto.attraction.Attraction;
import com.enjoytrip.dto.attraction.AttractionDescription;
import com.enjoytrip.dto.attraction.AttractionInfo;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionSimpleInfo;
import com.enjoytrip.dto.attraction.Gugun;
import com.enjoytrip.dto.attraction.Sido;
import com.enjoytrip.dto.plan.response.AttractionTotalInfo;
import com.enjoytrip.exception.AttractionException;
import com.enjoytrip.exception.BadParameterException;

@Service
public class AttractionService {
	
	private AttractionDao attractionDao;
	private AttractionDescriptionDao attractionDescriptionDao;
	private AttractionInfoDao attractionInfoDao;
	private SidoGugunDao sidoGugunDao;
	
	
	
	@Autowired
	public AttractionService(AttractionDao attractionDao, AttractionDescriptionDao attractionDescriptionDao,
			AttractionInfoDao attractionInfoDao, SidoGugunDao sidoGugunDao) {
		super();
		this.attractionDao = attractionDao;
		this.attractionDescriptionDao = attractionDescriptionDao;
		this.attractionInfoDao = attractionInfoDao;
		this.sidoGugunDao = sidoGugunDao;
	}

	@Transactional
	public Long createAttraction(AttractionTotalInfo attractionTotalInfo) throws AttractionException,BadParameterException{
		
		if(attractionTotalInfo.getAttractionDescription()==null || attractionTotalInfo.getAttractionSimpleInfo()==null) {
			throw new BadParameterException("관광지 생성에 필요한 정보가 존재하지 않습니다");
		}
		
		AttractionSimpleInfo attractionSimpleInfo = attractionTotalInfo.getAttractionSimpleInfo();
		Attraction attraction = new Attraction();
		attraction.setattractionTypeId(
				attractionSimpleInfo.getAttractionTypeId()
		);
		attraction.setTitle(
				attractionSimpleInfo.getTitle()
		);
		attractionDao.createAttraction(attraction);
		Long attractionId = attraction.getAttractionId();
		
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(attractionId);
		List<Attraction> attractions = attractionDao.retrieveAttraction(attractionSearchCondition);
		
		if(attractions.size()!=1) {
			throw new AttractionException("관광지 생성 실패");
		}
		
		AttractionDescription attractionDescription = attractionTotalInfo.getAttractionDescription();
		attractionDescription.setAttractionId(attractionId);
		attractionDescriptionDao.createAttractionDescription(attractionDescription);
		
		AttractionInfo attractionInfo = new AttractionInfo();
		
		attractionInfo.setAddr1(
				attractionSimpleInfo.getAddr1()
		);
		
		attractionInfo.setAttractionId(
				attractionId
		);
		
		attractionInfo.setFirstImage(
				attractionSimpleInfo.getFirstImage()
		);
		
		attractionInfo.setGugunCode(
				attractionSimpleInfo.getGugunCode()
		);
		
		attractionInfo.setSidoCode(
				attractionSimpleInfo.getSidoCode()
		);
		
		attractionInfo.setLatitude(
				attractionSimpleInfo.getLatitude()
		);

		attractionInfo.setLongitude(
				attractionSimpleInfo.getLongitude()
		);

		attractionInfo.setTel(
				attractionSimpleInfo.getTel()
		);

		attractionInfo.setZipcode(
				attractionSimpleInfo.getZipcode()
		);
		
		attractionInfoDao.createAttractionInfo(attractionInfo);
		
		List<AttractionInfo> attractionInfos = attractionInfoDao.retrieveAttractionInfo(attractionSearchCondition);
		
		if(attractionInfos.size()!=1) {
			throw new AttractionException("관광지 정보 생성 실패");
		}
		
		return attractionId;
	}
	
	@Transactional
	public List<Sido> retrieveSido(){
		return sidoGugunDao.retrieveSido();
	}
	
	@Transactional
	public List<Gugun> retrieveSidoGugun(Long sidoCode,Long gugunCode){
		return sidoGugunDao.retrieveGugun(sidoCode, gugunCode);
	}
}
