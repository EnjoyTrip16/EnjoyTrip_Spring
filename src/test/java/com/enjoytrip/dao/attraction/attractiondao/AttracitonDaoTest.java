package com.enjoytrip.dao.attraction.attractiondao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.attraction.AttractionDao;
import com.enjoytrip.dto.attraction.Attraction;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionSimpleInfo;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttracitonDaoTest {
	
	@Autowired
	AttractionDao attractionDao;
	
	@Test
	@DisplayName("관광지 테이블 검색조건(관광지ID) 조회")
	public void retrieveAttractionByAttractionId() {
		
		//give
		//검색조건 관광지ID 
		Long searchConditionAttractionId = 125266L;
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(searchConditionAttractionId);
		
		//when
		List<Attraction> resultAttraction = attractionDao.retrieveAttraction(attractionSearchCondition);
		
		//then
		assertThat(resultAttraction)
		.extracting("attractionId")
		.containsOnly(searchConditionAttractionId);
	}	
	
	@Test
	@DisplayName("관광지 테이블 검색조건(관광지 종류ID) 조회")
	public void retrieveAttractionByAttractionTypeId() {
		
		//give
		//검색조건 관광지ID 
		Long searchConditionAttractionTypeId = 12L;
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionTypeId(searchConditionAttractionTypeId);
		
		//when
		List<Attraction> resultAttraction = attractionDao.retrieveAttraction(attractionSearchCondition);
		
		//then
		
		//검색조건인 관광지 종류 ID와 결과인 관광지들의 관광지 종류 ID는 같아야함
		assertThat(resultAttraction)
		.extracting("attractionTypeId")
		.containsOnly(searchConditionAttractionTypeId);
	}	
	
	@Test
	@DisplayName("관광지 테이블 검색조건(관광지명) 조회")
	public void retrieveAttractionByTitle() {
		
		//give
		//검색조건 관광지명 포함 여부
		String searchConditionTitle="공원";
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setKeywordTitle(searchConditionTitle);
		
		//when
		List<Attraction> resultAttraction = attractionDao.retrieveAttraction(attractionSearchCondition);
		
		//then
		
		//관광지 명으로 검색한 결과에 관광지명은 검색조건과 같아야함(키워드 포함)
		assertThat(resultAttraction)
		.extracting(Attraction::getTitle)
		.allMatch(
				title->
				title.contains(searchConditionTitle)
		);
	}	
	
	@Test
	@DisplayName("관광지 테이블 다중 검색조건 조회")
	public void retrieveAttractionByMultipleCondition() {
		
		//give
		//검색조건 관광지명 포함 여부
		String searchConditionTitle="공원";
		
		//검색조건 관광지 종류 ID
		Long searchConditionAttractionTypeId = 12L;
		
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setKeywordTitle(searchConditionTitle);
		attractionSearchCondition.setAttractionTypeId(searchConditionAttractionTypeId);
		
		//when
		List<Attraction> resultAttraction = attractionDao.retrieveAttraction(attractionSearchCondition);
		
		//then
		
		//관광지 명으로 검색한 결과에 관광지명은 검색조건과 같아야함(키워드 포함)
		assertThat(resultAttraction)
		.extracting(Attraction::getTitle)
		.allMatch(
				title->
				title.contains(searchConditionTitle)
		);
		
		//검색조건인 관광지 종류 ID는 결과로 나온 관광지 종류 ID와 같아야함
		assertThat(resultAttraction)
		.extracting("attractionTypeId")
		.containsOnly(searchConditionAttractionTypeId);
		
	}	
	
	@Test
	@DisplayName("관광지 테이블 삽입 테스트")
	public void createAttractionTest() {
		
		//give
		//DTO에 사용할 필드
		Long attractionTypeId = 12L;
		String title = "한국항공대학교";
		
		//삽입할 관광지 
		Attraction attraction = new Attraction();
		attraction.setattractionTypeId(attractionTypeId);
		attraction.setTitle(title);

		//when
		
		//삽입한 결과 PK가져오기 (AUTO_INCREMENT PK)
		attractionDao.createAttraction(attraction);
		
		//then
		//가져온PK가 null이 아니어야함
		assertThat(attraction.getAttractionId())
		.isNotNull();
		
		//가져온 PK로 Attraction DTO retrieve
		
		//결과확인을 위한 검색조건
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionTypeId(attractionTypeId);
		attractionSearchCondition.setKeywordTitle(title);
		attractionSearchCondition.setAttractionId(attraction.getAttractionId());
		
		//가져온 DTO 
		List<Attraction> resultAttraction = attractionDao.retrieveAttraction(attractionSearchCondition);

		//가져온 DTO는 하나여야함
		assertThat(resultAttraction)
		.hasSize(1);
		
		//가져온 DTO는 예상되는 필드값을 가져야함
		assertThat(resultAttraction)
		.extracting("attractionTypeId")
		.containsOnly(attraction.getattractionTypeId());
		
		assertThat(resultAttraction)
		.extracting(Attraction::getTitle)
		.allMatch(
				conditionTitle->
				conditionTitle.contains(title)
		);
		
	}	
	
	@Test
	@DisplayName("관광지 테이블 수정 테스트")
	public void updateAttractionTest() {
		
		//give
		//수정 대상 DTO PK
		Long attractionId = 125266L;
		
		//DTO에 수정에 사용할 필드
		Long afterAttractionTypeId = 14L;
		String afterTitle = "한국항공대학교";
		LocalDateTime afterUpdatedAt = LocalDateTime.now();
		//수정 전 수정 후 데이터는 달라야함
		
		//수정 대상 미리 가져와서 확인
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(attractionId);
		List<Attraction> beforeAttraction = attractionDao.retrieveAttraction(attractionSearchCondition);
		
		assertThat(beforeAttraction)
		.extracting("title")
		.isNotEqualTo(afterTitle);
		
		assertThat(beforeAttraction)
		.extracting("attractionTypeId")
		.isNotEqualTo(afterAttractionTypeId);
		
		//수정후 DTO (기대값)
		Attraction afterAttraction = new Attraction();
		afterAttraction.setAttractionId(attractionId);
		afterAttraction.setattractionTypeId(afterAttractionTypeId);
		afterAttraction.setTitle(afterTitle);
		afterAttraction.setUpdatedAt(afterUpdatedAt);
		
		
		//when
		
		//수정한 행 가져오기
		Long resultRow = attractionDao.updateAttraction(afterAttraction);
		
		//then
		//수정한 행이 존재해야함
		assertThat(resultRow)
		.isNotNull()
		.isGreaterThanOrEqualTo(1L);
		
		//수정 후 DTO 가져오기
		List<Attraction> resultAttraction = attractionDao.retrieveAttraction(attractionSearchCondition);
		
		//가져온 DTO는 하나여야함
		assertThat(resultAttraction)
		.hasSize(1);
		
		//수정한 DTO는 기대값과 같아야함
		assertThat(resultAttraction)
		.extracting("attractionTypeId")
		.containsOnly(afterAttractionTypeId);
		
		assertThat(resultAttraction)
		.extracting(Attraction::getTitle)
		.allMatch(
				conditionTitle->
				conditionTitle.contains(afterTitle)
		);		
		
		assertThat(resultAttraction.get(0).getUpdatedAt())
		.isCloseTo(afterUpdatedAt,within(2,ChronoUnit.SECONDS));
		
		
		
	}
}
