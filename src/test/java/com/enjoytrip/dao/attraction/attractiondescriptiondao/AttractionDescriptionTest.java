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
	
	@Test
	@DisplayName("관광지 설명 수정 테스트")
	public void updateAttractionDescriptionTest() {
		//검색결과에 해당하는 관광지ID가 검색조건 관광지ID가 같아야함
		
		//give
		
		//수정대상인 관광지 ID
		Long attractionId = 125266L;
		
		//수정 후 홈페이지 
		String expectHomepage = "http://edu.ssafy.com/";
		
		//수정 후 관광지 설명
		String expectOverview = "청태산이 뭐에용?";
		
		//검색조건 DTO
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(attractionId);
		
		//수정 전 관광지 설명 DTO
		List<AttractionDescription> beforeAttractionDescription = attractionDescriptionDao.retrieveAttractionDescription(attractionSearchCondition);
		
		//테스트 대상 관광지 설명 DTO는 존재해야함
		assertThat(beforeAttractionDescription)
		.hasSize(1);
		
		//수정 전과 수정 후가 update전에 같으면 안됨
		assertThat(beforeAttractionDescription)
		.extracting("homepage")
		.allMatch(homepage -> !homepage.equals(expectHomepage));
		

		assertThat(beforeAttractionDescription)
		.extracting("overview")
		.allMatch(overview -> !overview.equals(expectOverview));
		
		//결과로 기대하는 관광지 설명 DTO
		AttractionDescription expectAttractionDescription = new AttractionDescription();
		expectAttractionDescription.setAttractionId(attractionId);
		expectAttractionDescription.setHomepage(expectHomepage);
		expectAttractionDescription.setOverview(expectOverview);
		
		//when
		
		Long resultRow = attractionDescriptionDao.updateAttractionDescription(expectAttractionDescription);
		List<AttractionDescription> afterAttractionDescription = attractionDescriptionDao.retrieveAttractionDescription(attractionSearchCondition);
		
		//then		
		//수정 결과가 한 행에 대하여
		assertThat(resultRow).isEqualTo(1L);
		
		//수정 전과 수정 후가 update전에 같으면 안됨
		assertThat(afterAttractionDescription)
		.extracting("homepage")
		.allMatch(homepage -> homepage.equals(expectHomepage));
		

		assertThat(afterAttractionDescription)
		.extracting("overview")
		.allMatch(overview -> overview.equals(expectOverview));
	}	
	
	@Test
	@DisplayName("관광지 설명 삭제 테스트")
	public void deletettractionDescriptionTest() {
		//검색결과에 해당하는 관광지ID가 검색조건 관광지ID가 같아야함
		
		//give
		
		//삭제대상인 관광지 ID
		Long attractionId = 125266L;
		
		//삭제 조건 DTO
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(attractionId);
		
		//삭제 전 관광지 설명 DTO
		List<AttractionDescription> beforeAttractionDescription = attractionDescriptionDao.retrieveAttractionDescription(attractionSearchCondition);
		
		//테스트 대상 관광지 설명 DTO는 존재해야함
		assertThat(beforeAttractionDescription)
		.hasSize(1);
		
		//when
		
		Long resultRow = attractionDescriptionDao.deleteAttractionDescription(attractionSearchCondition);
		
		//then		
		//삭제 결과가 한 행에 대하여
		assertThat(resultRow).isEqualTo(1L);
		
		//삭제 후 해당 DTO는 존재하면 안됨!
		List<AttractionDescription> afterAttractionDescription  = attractionDescriptionDao.retrieveAttractionDescription(attractionSearchCondition);
		assertThat(afterAttractionDescription)
		.isEmpty();
	}		
	
	@Test
	@DisplayName("관광지 설명 생성 테스트")
	public void createAttractionDescription() {
		//검색결과에 해당하는 관광지ID가 검색조건 관광지ID가 같아야함
		
		//give
		
		//DB에 생성할 DTO
		AttractionDescription attractionDescription = new AttractionDescription();
		attractionDescription.setAttractionId(20000000L);
		attractionDescription.setHomepage("http://kau.ac.kr");
		attractionDescription.setOverview("한국항공대입니다!");
		
		//when
		
		Long resultRow = attractionDescriptionDao.createAttractionDescription(attractionDescription);
		System.out.println(resultRow);
		
		//then		
		//삽입 결과로 1L이 정상적으로 반환
		assertThat(resultRow).isEqualTo(1L);
		
		//null이 아닌PK로 조회시 row가 존재
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(attractionDescription.getAttractionId());
		
		List<AttractionDescription> resultAttractionDescription  = 
				attractionDescriptionDao
				.retrieveAttractionDescription(attractionSearchCondition);
		
		//조회시 해당 행이 존재하며 삽입한 attractionDescription DTO와 조회한 DTO가 같아야함
		assertThat(resultAttractionDescription)
		.hasSize(1);
		
		assertThat(resultAttractionDescription)
		.usingRecursiveFieldByFieldElementComparator()
		.containsOnly(attractionDescription);
		
		
	}	
}
