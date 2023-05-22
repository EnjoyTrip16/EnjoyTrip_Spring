package com.enjoytrip.dao.attraction.attractionuserrating;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.attraction.AttractionUserRatingDao;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionUserRating;
import com.enjoytrip.dto.attraction.AttractionUserSearchCondition;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttractionUserRatingDaoTest {
	
	@Autowired
	AttractionUserRatingDao attractionUserRatingDao;
	
	@Test
	@DisplayName("관광지 별점 조회")
	public void retrieveAttractionUserRatingTest() {
		//give
		//검색 조건
		Long userId = 1L;
		
		List<Long> attractionIdList = new ArrayList<>();
		attractionIdList.add(125266L);
		attractionIdList.add(125267L);
		
		AttractionUserSearchCondition attractionUserSearchCondition = new AttractionUserSearchCondition();
		attractionUserSearchCondition.setAttractionIdList(attractionIdList);
		attractionUserSearchCondition.setUserId(userId);
		//when
		List<AttractionUserRating> attractionUserRatings = 
					attractionUserRatingDao.retrieveAttractionUserRating(attractionUserSearchCondition);
		
		//then
		
		//한 유저 두 관광지의 평점은 두 행
		assertThat(attractionUserRatings)
		.hasSize(2);
		
	}
	
	@Test
	@DisplayName("관광지 별점 수정")
	public void updateAttractionUserRatingTest() {
		//give
		//수정할 DTO
		Long userId = 1L;
		Long attractionId = 125266L;
		Double rating = 1.0;
		
		AttractionUserRating attractionUserRating = new AttractionUserRating();
		attractionUserRating.setAttractionId(attractionId);
		attractionUserRating.setRating(rating);
		attractionUserRating.setUserId(userId);
		//when
		Long resultRow = 
					attractionUserRatingDao.updateAttractionUserRating(attractionUserRating);
		
		//then
		
		//수정대상 행은 하나
		assertThat(resultRow)
		.isEqualTo(1);
		
		//수정 화인
		AttractionUserSearchCondition attractionUserSearchCondition 
			= new AttractionUserSearchCondition();
		List<Long> attractionIdList = new ArrayList<>();
		attractionIdList.add(attractionId);
		attractionUserSearchCondition.setAttractionIdList(attractionIdList);
		attractionUserSearchCondition.setUserId(userId);
		
		List<AttractionUserRating> attractionUserRatings = 
				attractionUserRatingDao.retrieveAttractionUserRating(attractionUserSearchCondition);
		
		assertThat(attractionUserRatings)
		.usingRecursiveFieldByFieldElementComparator()
		.containsOnly(attractionUserRating);
		
	}
	
	@Test
	@DisplayName("관광지 별점 생성")
	public void createAttractionUserRatingTest() {
		//give
		//생성할 DTO
		Long userId = 3L;
		Long attractionId = 125270L;
		Double rating = 1.0;
		
		AttractionUserRating attractionUserRating = new AttractionUserRating();
		attractionUserRating.setAttractionId(attractionId);
		attractionUserRating.setRating(rating);
		attractionUserRating.setUserId(userId);
		
		//when
		Long resultRow = 
					attractionUserRatingDao.createAttractionUserRating(attractionUserRating);
		
		//then
		
		//수정대상 행은 하나
		assertThat(resultRow)
		.isEqualTo(1);
		
		//생성확인
		AttractionUserSearchCondition attractionUserSearchCondition 
			= new AttractionUserSearchCondition();
		List<Long> attractionIdList = new ArrayList<>();
		attractionIdList.add(attractionId);
		attractionUserSearchCondition.setAttractionIdList(attractionIdList);
		attractionUserSearchCondition.setUserId(userId);
		
		List<AttractionUserRating> attractionUserRatings = 
				attractionUserRatingDao.retrieveAttractionUserRating(attractionUserSearchCondition);
		
		assertThat(attractionUserRatings)
		.usingRecursiveFieldByFieldElementComparator()
		.containsOnly(attractionUserRating);
		
	}
	
	@Test
	@DisplayName("관광지 별점 삭제")
	public void deleteAttractionUserRatingTest() {
		//give
		//검색조건
		Long userId = 1L;
		Long attractionId = 125266L;
		AttractionUserSearchCondition attractionUserSearchCondition 
			= new AttractionUserSearchCondition();
		List<Long> attractionIdList = new ArrayList<>();
		attractionIdList.add(attractionId);
		attractionUserSearchCondition.setAttractionIdList(attractionIdList);
		attractionUserSearchCondition.setUserId(userId);
		
		List<AttractionUserRating> beforeList = attractionUserRatingDao.retrieveAttractionUserRating(attractionUserSearchCondition);
		
		assertThat(beforeList)
		.hasSize(1);
		
		//when
		Long resultRow = 
					attractionUserRatingDao.deleteAttractionUserRating(attractionUserSearchCondition);
		
		//then
		
		//삭제대상 행은 하나
		assertThat(resultRow)
		.isEqualTo(1);
		
		//생성확인
		List<AttractionUserRating> afterList = attractionUserRatingDao.retrieveAttractionUserRating(attractionUserSearchCondition);
		assertThat(afterList)
		.hasSize(0);
		
	}

}
