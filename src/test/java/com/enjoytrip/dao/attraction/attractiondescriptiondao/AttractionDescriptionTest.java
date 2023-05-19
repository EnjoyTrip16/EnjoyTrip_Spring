package com.enjoytrip.dao.attraction.attractiondescriptiondao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.attraction.AttractionDescriptionDao;
import com.enjoytrip.dto.attraction.AttractionDescription;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;

//Mybatis에 대한 DAO 유닛테스트
@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttractionDescriptionTest {
	//테스트 대상 DAO
	//관광지 설명 정보 CRUD에 관한 DAO
	@Autowired
	AttractionDescriptionDao attractionDescriptionDao;
	
	@Test
	@DisplayName("검색조건(관광지ID)로 관광지 설명 조회 테스트")
	public void retrieveAttractionDescriptionByAttractionIdTest() {
		//검색결과에 해당하는 관광지ID가 검색조건 관광지ID가 같아야함
		
		//give
		
		//검색조건인 관광지 ID
		Long searchConditionAttractionId = 125266L;
		
		//검색조건 DTO
		AttractionSearchCondition attractionSearchCondition =  new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(searchConditionAttractionId);
		
		//when
		
		List<AttractionDescription> resultAttractionDescriptionList = attractionDescriptionDao.retrieveAttractionDescription(attractionSearchCondition);
		
		//then
		
		//관광지PK로 조회한것이기 때문에 결과는 1이 나와야함
		assertThat(resultAttractionDescriptionList)
		.hasSize(1);
		
		//결과에 해당하는 관광지와 검색조건인 관광지PK가 일치해야함
		assertThat(resultAttractionDescriptionList)
		.extracting("attractionId")
		.containsOnly(searchConditionAttractionId);
	}	
}
