package com.enjoytrip.service.attraction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.attraction.AttractionDao;
import com.enjoytrip.dao.attraction.AttractionUserRatingDao;
import com.enjoytrip.dto.attraction.Attraction;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionUserRating;
import com.enjoytrip.dto.attraction.AttractionUserSearchCondition;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.AttractionException;

@Service
public class AttractionUserRatingService {

	private AttractionDao attractionDao;
	private AttractionUserRatingDao attractionUserRatingDao;
	
	@Autowired
	public AttractionUserRatingService(AttractionDao attractionDao, AttractionUserRatingDao attractionUserRatingDao) {
		super();
		this.attractionDao = attractionDao;
		this.attractionUserRatingDao = attractionUserRatingDao;
	}
	
	@Transactional
	public void createAttractionUserRating(AttractionUserRating attractionUserRating) throws AttractionException,BadParameterException {
		if(attractionUserRating.getAttractionId()==null || attractionUserRating.getUserId()==null) {
			throw new BadParameterException("AttractionId와 userId가 필요합니다.");
		}
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(attractionUserRating.getAttractionId());
		List<Attraction> attractionList = attractionDao.retrieveAttraction(attractionSearchCondition);
		if(attractionList.isEmpty()) {
			throw new BadParameterException("존재하지 않는 attractionId");
		}
		Long resultRow = attractionUserRatingDao
				.createAttractionUserRating(attractionUserRating);
		if(resultRow!=1L) {
			throw new AttractionException("잘못된 관광지 좋아요 북마크 생성");
		} 
	}
	@Transactional
	public List<AttractionUserRating> retrieveAttractionUserRating(AttractionUserSearchCondition attractionUserSearchCondition) throws AttractionException,BadParameterException {
		if(attractionUserSearchCondition.getAttractionIdList()==null && attractionUserSearchCondition.getUserId()==null) {
			throw new BadParameterException("AttractionId혹은 AttractionId가 필요합니다.");
		}
		List<AttractionUserRating> attractionUserRatings= attractionUserRatingDao
				.retrieveAttractionUserRating(attractionUserSearchCondition);
		if(attractionUserRatings==null) {
			throw new AttractionException("잘못된 계획-관광지 생성");
		}
		return attractionUserRatings;
	}	
	
	@Transactional
	public void updateAttractionUserRating(AttractionUserRating attractionUserRating) throws AttractionException,BadParameterException {
		if(attractionUserRating.getAttractionId()==null || attractionUserRating.getUserId()==null) {
			throw new BadParameterException("AttractionId혹은 AttractionId가 필요합니다.");
		}
		Long resultRow = attractionUserRatingDao
				.updateAttractionUserRating(attractionUserRating);
		if(resultRow!=1L) {
			throw new AttractionException("수정된 정보가 없습니다.");
		}
	}

	@Transactional
	public void deleteAttractionUserRating(AttractionUserSearchCondition attractionUserSearchCondition) throws AttractionException,BadParameterException {
		if(attractionUserSearchCondition.getAttractionIdList()==null && attractionUserSearchCondition.getUserId()==null) {
			throw new BadParameterException("AttractionId혹은 userId가 필요합니다.");
		}
		Long resultRow = attractionUserRatingDao
				.deleteAttractionUserRating(attractionUserSearchCondition);
		if(resultRow == 0L) {
			throw new AttractionException("잘못된 계획-관광지 삭제");
		}
	}	
}
