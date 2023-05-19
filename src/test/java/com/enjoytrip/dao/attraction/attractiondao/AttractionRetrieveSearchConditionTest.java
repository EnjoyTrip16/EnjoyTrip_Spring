package com.enjoytrip.dao.attraction.attractiondao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.attraction.AttractionDao;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionSimpleInfo;

//Mybatis에 대한 DAO 유닛테스트
@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttractionRetrieveSearchConditionTest {
	
	//테스트 대상 DAO
	//관광지 CRUD에 관한 DAO
	@Autowired
	AttractionDao attractionDao;
	
	@Test
	@DisplayName("검색조건(관광지ID) 메소드 테스트")
	public void retrieveAttractionSimpleInfoByAttractionIdTest() {
		//검색결과에 해당하는 관광지ID가 검색조건 관광지ID가 같아야함
		
		//give
		
		//검색조건인 관광지 ID
		Long searchConditionAttractionId = 125266L;
		
		//검색조건 DTO
		AttractionSearchCondition attractionSearchCondition =  new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(searchConditionAttractionId);
		
		//when
		
		List<AttractionSimpleInfo> resultAttractionSimpleInfoList = attractionDao.retrieveAttractionSimpleInfo(attractionSearchCondition);
		
		//then
		
		//관광지PK로 조회한것이기 때문에 결과는 1이 나와야함
		assertThat(resultAttractionSimpleInfoList)
		.hasSize(1);
		
		//결과에 해당하는 관광지와 검색조건인 관광지PK가 일치해야함
		assertThat(resultAttractionSimpleInfoList)
		.extracting("attractionId")
		.containsOnly(searchConditionAttractionId);
	}	
	
	@Test
	@DisplayName("검색조건(시도코드) 메소드 테스트")
	public void retrieveAttractionSimpleInfoBySidoCodeTest() {
		//검색결과에 해당하는 관광지시도코드가 검색조건과 같아야함
		
		//give
		
		//검색조건인 시도코드
		Integer searchConditionSidoCode = 1;
		
		//검색조건 DTO
		AttractionSearchCondition attractionSearchCondition =  new AttractionSearchCondition();
		attractionSearchCondition.setSidoCode(searchConditionSidoCode);
		
		//when
		
		List<AttractionSimpleInfo> resultAttractionSimpleInfoList = attractionDao.retrieveAttractionSimpleInfo(attractionSearchCondition);
		
		//then
		
		//서울에 있는 관광지는 5개는 넘음
		assertThat(resultAttractionSimpleInfoList)
		.hasSizeGreaterThanOrEqualTo(5);
		
		//결과에 해당하는 관광지와 검색조건인 시도코드가 일치해야함
		assertThat(resultAttractionSimpleInfoList)
		.extracting("sidoCode")
		.containsOnly(searchConditionSidoCode);
	}
	
	@Test
	@DisplayName("검색조건(구군코드) 메소드 테스트")
	public void retrieveAttractionSimpleInfoByGugunCodeTest() {
		//검색결과에 해당하는 관광지시도코드가 검색조건과 같아야함
		
		//give
		
		//검색조건인 시도코드
		Integer searchConditionSidoCode = 1;
		
		//검색조건인 구군코드
		Integer searchConditionGugunCode = 1;
		
		//검색조건 DTO
		AttractionSearchCondition attractionSearchCondition =  new AttractionSearchCondition();
		attractionSearchCondition.setSidoCode(searchConditionSidoCode);
		attractionSearchCondition.setGugunCode(searchConditionGugunCode);
		
		//when
		
		List<AttractionSimpleInfo> resultAttractionSimpleInfoList = attractionDao.retrieveAttractionSimpleInfo(attractionSearchCondition);
		
		//then
		
		//서울 강남구에 있는 관광지는 1개는 넘음
		assertThat(resultAttractionSimpleInfoList).hasSizeGreaterThanOrEqualTo(1);
		
		//결과에 해당하는 관광지와 검색조건인 시도코드가 일치해야함
		assertThat(resultAttractionSimpleInfoList)
		.extracting("sidoCode")
		.containsOnly(searchConditionSidoCode);		
		
		//결과에 해당하는 관광지와 검색조건인 구군코드가 일치해야함
		assertThat(resultAttractionSimpleInfoList)
		.extracting("gugunCode")
		.containsOnly(searchConditionGugunCode);
	}
	
	@Test
	@DisplayName("검색조건(관광지 종류) 메소드 테스트")
	public void retrieveAttractionSimpleInfoByAttractionTypeIdTest() {
		//검색결과에 해당하는 관광지종류 ID가 검색조건과 같아야함
		
		//give
		
		//검색조건인 관광지 종류 ID
		Long searchConditionAttractionTypeId = 14L;
		
		//검색조건 DTO
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionTypeId(searchConditionAttractionTypeId);
		//when
		
		List<AttractionSimpleInfo> resultAttractionSimpleInfoList = attractionDao.retrieveAttractionSimpleInfo(attractionSearchCondition);
		
		//then
		
		//관광지 종류 ID 14 ->문화시설의 개수는 5개는넘음
		assertThat(resultAttractionSimpleInfoList)
		.hasSizeGreaterThan(5);
		
		//결과에 해당하는 관광지와 검색조건인 관광지종류ID가 같아야함
		assertThat(resultAttractionSimpleInfoList)
		.extracting("attractionTypeId")
		.containsOnly(14L);
	}
	
	@Test
	@DisplayName("검색조건(관광지명) 메소드 테스트")
	public void retireveAttractionSimpleInfoByTitleTest() {
		//검색결과에 해당하는 관광지명이 검색조건을 포함해야함
		
		//give
		
		//검색조건인 관광지명
		String searchConditionKeywordTitle = "숲";
		
		//검색조건 DTO
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setKeywordTitle(searchConditionKeywordTitle);
		
		//when
		
		List<AttractionSimpleInfo> resultAttractionSimpleInfoList = attractionDao.retrieveAttractionSimpleInfo(attractionSearchCondition);
		
		//then
		
		//남한이 들어간 관광지는 3개는넘음
		assertThat(resultAttractionSimpleInfoList)
		.hasSizeGreaterThanOrEqualTo(3);
		
		//결과에 해당하는 관광지들의 관광지명은 남한을 포함해야함
		assertThat(resultAttractionSimpleInfoList)
		.extracting(AttractionSimpleInfo::getTitle)
		.allMatch(title->title.contains(searchConditionKeywordTitle));
	}
	
	@Test
	@DisplayName("검색조건(관광지 종류명) 메소드 테스트")
	public void retireveAttractionSimpleInfoByKeyWordAttractionTypeTest() {
		//검색결과에 해당하는 관광지명이 검색조건을 포함해야함
		
		//give
		
		//검색조건인 관광지종류명
		String searchConditionKeywordAttractionType = "행사";
		
		//검색조건 DTO
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setKeywordAttractionType(searchConditionKeywordAttractionType);
		
		//when
		
		List<AttractionSimpleInfo> resultAttractionSimpleInfoList = attractionDao.retrieveAttractionSimpleInfo(attractionSearchCondition);
		
		//then
		
		//관광지 종류명에 행사가 들어간 관광지는 3개는넘음
		assertThat(resultAttractionSimpleInfoList)
		.hasSizeGreaterThanOrEqualTo(3);
		
		//결과에 해당하는 관광지들의 관광지 종류명은 '행사'가 포함되어야함
		assertThat(resultAttractionSimpleInfoList)
		.extracting(AttractionSimpleInfo::getAttractionType)
		.allMatch(
				attractionType ->
				attractionType.contains(searchConditionKeywordAttractionType)
		);
	}
	
	@Test
	@DisplayName("다중 검색조건에 대한 검색결과 메소드 테스트")
	public void retireveAttractionSimpleInfoByMultipleConditionTest() {
		//give
		
		//검색조건인 관광지명
		String searchConditionKeywordTitle = "숲";
		
		//검색조건인 시도코드
		Integer searchConditionSidoCode = 31;
		
		//검색조건인 관광지 종류명
		String searchConditionKeywordAttractionType = "관광";
		
		//검색조건 DTO
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setKeywordAttractionType(searchConditionKeywordAttractionType);
		attractionSearchCondition.setKeywordTitle(searchConditionKeywordTitle);
		attractionSearchCondition.setSidoCode(searchConditionSidoCode);
		
		//when
		
		List<AttractionSimpleInfo> resultAttractionSimpleInfoList = attractionDao.retrieveAttractionSimpleInfo(attractionSearchCondition);
		
		//then
		
		//검색조건에 해당하는 관광지는 1개는 넘음
		assertThat(resultAttractionSimpleInfoList)
		.hasSizeGreaterThan(1);
		
		//검색조건의 시도코드와 결과 관광지들에 시도코드는 일치해야함
		assertThat(resultAttractionSimpleInfoList)
		.extracting("sidoCode")
		.containsOnly(searchConditionSidoCode);
		
		//검색조건의 관광지명이 결과 관광지들의 관광지명에 포함되어야함
		assertThat(resultAttractionSimpleInfoList)
		.extracting(AttractionSimpleInfo::getTitle)
		.allMatch(title->title.contains(searchConditionKeywordTitle));
		
		//결과에 해당하는 관광지들의 관광지 종류명은 '관광'이 포함되어야함
		assertThat(resultAttractionSimpleInfoList)
		.extracting(AttractionSimpleInfo::getAttractionType)
		.allMatch(
				attractionType ->
				attractionType.contains(searchConditionKeywordAttractionType)
		);
		
	}
}
