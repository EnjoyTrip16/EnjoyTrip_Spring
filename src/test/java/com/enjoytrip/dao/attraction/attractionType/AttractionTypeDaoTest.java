package com.enjoytrip.dao.attraction.attractionType;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.attraction.AttractionTypeDao;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionType;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttractionTypeDaoTest {
	
	@Autowired
	AttractionTypeDao attractionTypeDao;
	
	@Test
	@DisplayName("관광지 종류 DAO 검색조건(관광지ID) 조회")
	public void retrieveAttractionTypeByIdTest() {
		//give
		Long attractionTypeId = 12L;
		
		//검색조건
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionTypeId(12L);
		
		//when
		List<AttractionType> resultAttractionTypes = attractionTypeDao.retrieveAttractionType(attractionSearchCondition);
		
		//then
		assertThat(resultAttractionTypes)
		.hasSize(1);
		
		//검색조건과 관광지 종류 ID가 같아야함
		assertThat(resultAttractionTypes)
		.extracting("attractionTypeId")
		.containsOnly(12L);
	}
	
	@Test
	@DisplayName("관광지 종류 DAO 검색조건(관광지 종류 명) 조회")
	public void retrieveAttractionTypeByAttractionTypeTest() {
		//give
		//검색조건인 관광지 종류 이름
		String keywordAttractionType = "관광";
		
		//검색조건
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setKeywordAttractionType(keywordAttractionType);
		
		//when
		List<AttractionType> resultAttractionTypes = attractionTypeDao.retrieveAttractionType(attractionSearchCondition);
		
		//then
		assertThat(resultAttractionTypes)
		.hasSize(1);
		
		//결과에는 검색조건과 같은 관광지 종류 명이 포함되야함
		assertThat(resultAttractionTypes)
		.extracting("attractionType", String.class)
		.allMatch(
				attractionType ->
				attractionType.contains(keywordAttractionType)
		);
	}
	
	@Test
	@DisplayName("관광지 종류 DAO 삽입 테스트")
	public void createAttractionTypeTest() {
		//give
		//삽입할 관광지 종류 DTO
		AttractionType attractionType = new AttractionType();
		attractionType.setAttractionType("감성있는");
		
		//when
		Long resultRow = attractionTypeDao.createAttractionType(attractionType);
		
		//then
		
		//삽입한 행은 하나
		assertThat(resultRow)
		.isEqualTo(1L);
		
		//가져온 PK로 삽입한 결과 가져오기
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionTypeId(attractionType.getAttractionTypeId());
		
		List<AttractionType> resultAttractionTypes = attractionTypeDao.retrieveAttractionType(attractionSearchCondition);
		
		//삽입한 결과와 같아야함
		assertThat(resultAttractionTypes)
		.extracting("attractionType", String.class)
		.allMatch(
				conditionAttractionType ->
				conditionAttractionType.contains(attractionType.getAttractionType())
		);
	}
	
	@Test
	@DisplayName("관광지 종류 DAO 수정 테스트")
	public void updateAttractionTypeTest() {
		//give
		Long attractionTypeId = 12L;
		
		//수정할 관광지 종류 DTO
		AttractionType expectAttractionType = new AttractionType();
		expectAttractionType.setAttractionTypeId(attractionTypeId);
		expectAttractionType.setAttractionType("감성있는");
		
		//검색조건
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionTypeId(12L);
		
		//해당 관광지 종류 ID를 가진 이 존재하는지 확인
		List<AttractionType> checkAttractionType = attractionTypeDao.retrieveAttractionType(attractionSearchCondition);
		
		assertThat(checkAttractionType)
		.hasSizeGreaterThanOrEqualTo(1);
		
		//수정 전과 수정 후의 데이터는 같으면 안됨
		assertThat(checkAttractionType)
		.extracting("attractionType", String.class)
		.doesNotContain(expectAttractionType.getAttractionType());
		
		//when
		Long resultRow = attractionTypeDao.updateAttractionType(expectAttractionType);
		
		//then
		
		//관광지 종류 PK가 조건이므로 수정되어야 할
		assertThat(resultRow)
		.isEqualTo(1L);
		
		//정상적으로 수정되었는지 확인
		List<AttractionType> afterAttractionType = attractionTypeDao.retrieveAttractionType(attractionSearchCondition);
		
		assertThat(afterAttractionType)
		.extracting("attractionType")
		.containsOnly(expectAttractionType.getAttractionType());
	}
	
	@Test
	@DisplayName("관광지 종류 DAO 삭제테스트")
	public void deleteAttractionTypeTest() {
		//give
		//삭제대상 관광지 종류 PK
		Long attractionTypeId = 12L;
		
		//검색조건
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionTypeId(12L);
		
		//해당 관광지 종류 ID를 가진 행이 존재하는지 확인
		List<AttractionType> checkAttractionType = attractionTypeDao.retrieveAttractionType(attractionSearchCondition);
		
		assertThat(checkAttractionType)
		.hasSizeGreaterThanOrEqualTo(1);
		
		//when
		Long resultRow = attractionTypeDao.deleteAttractionType(attractionSearchCondition);
		
		//then
		
		//관광지 종류 PK가 조건이므로 한 행이 삭제되어야함
		assertThat(resultRow)
		.isEqualTo(1L);
		
		//정상적으로 삭제되었는지 확인
		List<AttractionType> afterAttractionType = attractionTypeDao.retrieveAttractionType(attractionSearchCondition);
		
		assertThat(afterAttractionType)
		.hasSize(0);
	}
	
}
