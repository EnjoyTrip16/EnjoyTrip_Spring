package com.enjoytrip.service.attraction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.attraction.AttractionDao;
import com.enjoytrip.dao.attraction.AttractionUserBookmarkFavorDao;
import com.enjoytrip.dto.attraction.Attraction;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionUserBookmarkFavor;
import com.enjoytrip.dto.attraction.AttractionUserSearchCondition;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.AttractionException;

@Service
public class AttractionUserBookmarkFavorService {

	private AttractionDao attractionDao;
	private AttractionUserBookmarkFavorDao attractionUserBookmarkFavorDao;
	
	@Autowired
	public AttractionUserBookmarkFavorService(AttractionDao attractionDao, AttractionUserBookmarkFavorDao attractionUserBookmarkFavorDao) {
		super();
		this.attractionDao = attractionDao;
		this.attractionUserBookmarkFavorDao = attractionUserBookmarkFavorDao;
	}
	
	@Transactional
	public void createAttractionUserBookmarkFavorDao(AttractionUserBookmarkFavor attractionUserBookmarkFavor) throws AttractionException,BadParameterException {
		if(attractionUserBookmarkFavor.getAttractionId()==null || attractionUserBookmarkFavor.getUserId()==null) {
			throw new BadParameterException("AttractionId와 userId가 필요합니다.");
		}
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(attractionUserBookmarkFavor.getAttractionId());
		List<Attraction> attractionList = attractionDao.retrieveAttraction(attractionSearchCondition);
		if(attractionList.isEmpty()) {
			throw new BadParameterException("존재하지 않는 attractionId");
		}
		Long resultRow = attractionUserBookmarkFavorDao
				.createAttractionUserBookmarkFavor(attractionUserBookmarkFavor);
		if(resultRow!=1L) {
			throw new AttractionException("잘못된 관광지 좋아요 북마크 생성");
		} 
	}
	@Transactional
	public List<AttractionUserBookmarkFavor> retrieveAttractionUserBookmarkFavor(AttractionUserSearchCondition attractionUserSearchCondition) throws AttractionException,BadParameterException {
		if(attractionUserSearchCondition.getAttractionIdList()==null && attractionUserSearchCondition.getUserId()==null) {
			throw new BadParameterException("AttractionId혹은 AttractionId가 필요합니다.");
		}
		List<AttractionUserBookmarkFavor> attractionUserBookmarkFavors= attractionUserBookmarkFavorDao
				.retrieveAttractionUserBookmarkFavor(attractionUserSearchCondition);
		if(attractionUserBookmarkFavors==null) {
			throw new AttractionException("잘못된 계획-관광지 생성");
		}
		return attractionUserBookmarkFavors;
	}	
	
	@Transactional
	public void updateAttractionUserBookmarkFavor(AttractionUserBookmarkFavor attractionUserBookmarkFavor) throws AttractionException,BadParameterException {
		if(attractionUserBookmarkFavor.getAttractionId()==null || attractionUserBookmarkFavor.getUserId()==null) {
			throw new BadParameterException("AttractionId혹은 AttractionId가 필요합니다.");
		}
		Long resultRow = attractionUserBookmarkFavorDao
				.updateAttractionUserBookmarkFavor(attractionUserBookmarkFavor);
		if(resultRow!=1L) {
			throw new AttractionException("수정된 정보가 없습니다.");
		}
	}

	@Transactional
	public void deleteAttractionUserBookmarkFavor(AttractionUserSearchCondition attractionUserSearchCondition) throws AttractionException,BadParameterException {
		if(attractionUserSearchCondition.getAttractionIdList()==null && attractionUserSearchCondition.getUserId()==null) {
			throw new BadParameterException("AttractionId혹은 userId가 필요합니다.");
		}
		Long resultRow = attractionUserBookmarkFavorDao
				.deleteAttractionUserBookmarkFavor(attractionUserSearchCondition);
		if(resultRow == 0L) {
			throw new AttractionException("잘못된 계획-관광지 삭제");
		}
	}	
}
