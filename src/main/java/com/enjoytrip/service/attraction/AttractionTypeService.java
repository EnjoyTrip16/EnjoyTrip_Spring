package com.enjoytrip.service.attraction;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.attraction.AttractionDao;
import com.enjoytrip.dao.attraction.AttractionTypeDao;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionType;
import com.enjoytrip.exception.BadParameterException;

@Service
public class AttractionTypeService {
	
	private AttractionTypeDao attractionTypeDao;
	private AttractionDao attractonDao;
	
	
	public AttractionTypeService(AttractionTypeDao attractionTypeDao, AttractionDao attractonDao) {
		super();
		this.attractionTypeDao = attractionTypeDao;
		this.attractonDao = attractonDao;
	}
	
	@Transactional
	public Long createAttractionType(AttractionType attractionType) throws BadParameterException{
		if(attractionType.getAttractionType()==null) {
			throw new BadParameterException("attractionType이 필요합니다");
		}
		attractionTypeDao.createAttractionType(attractionType);
		return attractionType.getAttractionTypeId();
	}
	
	@Transactional
	public void updateAttractionType(AttractionType attractionType) throws BadParameterException{
		if(attractionType.getAttractionType()==null || attractionType.getAttractionTypeId()==null) {
			throw new BadParameterException("attractionType 과 attractionTypeId가 필요합니다");
		}
		attractionTypeDao.updateAttractionType(attractionType);
	}
	
	@Transactional
	public void deleteAttractionType(AttractionSearchCondition attractionSearchCondition) throws BadParameterException{
		if(attractionSearchCondition.getAttractionTypeId()==null) {
			throw new BadParameterException("attractionTypeId가 필요합니다");
		}
		attractionTypeDao.deleteAttractionType(attractionSearchCondition);
	}
	
	@Transactional
	public List<AttractionType> retrieveAttractionType(AttractionSearchCondition attractionSearchCondition) throws BadParameterException{
		return attractionTypeDao.retrieveAttractionType(attractionSearchCondition);
	}


}
