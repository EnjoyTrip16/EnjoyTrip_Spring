package com.enjoytrip.dao.attraction.attractioninfodao;

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

import com.enjoytrip.dao.attraction.AttractionInfoDao;
import com.enjoytrip.dto.attraction.AttractionInfo;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttracitonInfoDaoTest {
	
	@Autowired
	AttractionInfoDao attractionInfoDao;
	
	@Test
	@DisplayName("관광지 정보 DAO 검색조건(관광지ID) 조회")
	public void retrieveAttractionByAttractionId() {
		
		//give
		//검색조건 관광지ID 
		Long searchConditionAttractionId = 125266L;
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(searchConditionAttractionId);
		
		//when
		List<AttractionInfo> resultAttractionInfo = attractionInfoDao.retrieveAttractionInfo(attractionSearchCondition);
		
		//then
		
		//검색결과 존재 여부
		assertThat(resultAttractionInfo)
		.hasSize(1);
		
		//검색조건과 결과 필드가 일치해야함
		assertThat(resultAttractionInfo)
		.extracting("attractionId")
		.containsOnly(searchConditionAttractionId);
	}	
	
	@Test
	@DisplayName("관광지 정보 DAO 삽입 테스트")
	public void createAttractionTest() {
		
		//give
		//DTO에 사용할 필드
		Long attractionId = 200000L;
		String addr1 = "경기도 고양시 덕양구 항공대학로 76";
		String tel="02-300-0114";
		String zipcode = "07552";
		Integer sidoCode = 1;
		Integer gugunCode = 1;
		
		//삽입할 관광지 정보
		AttractionInfo attractionInfo = new AttractionInfo();
		attractionInfo.setAddr1(addr1);
		attractionInfo.setTel(tel);
		attractionInfo.setZipcode(zipcode);
		attractionInfo.setAttractionId(attractionId);
		attractionInfo.setSidoCode(sidoCode);
		attractionInfo.setGugunCode(gugunCode);

		//when
		
		//삽입한 결과 영향받은 행의 개수
		Long resultRow = attractionInfoDao.createAttractionInfo(attractionInfo);
		
		//then
		//가져온PK가 null이 아니어야함
		assertThat(resultRow)
		.isNotNull()
		.isEqualTo(1L);
		
		//가져온 PK로 Attraction DTO retrieve
		
		//결과확인을 위한 검색조건
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(attractionId);
		
		//가져온 DTO 
		List<AttractionInfo> resultAttraction = attractionInfoDao.retrieveAttractionInfo(attractionSearchCondition);

		//가져온 DTO는 하나여야함
		assertThat(resultAttraction)
		.hasSize(1);
		
		//가져온 DTO는 예상되는 필드값을 가져야함
		assertThat(resultAttraction)
		.extracting("attractionId")
		.containsOnly(attractionId);
		
		assertThat(resultAttraction)
		.extracting("tel")
		.containsOnly(tel);

		assertThat(resultAttraction)
		.extracting("zipcode")
		.containsOnly(zipcode);

		assertThat(resultAttraction)
		.extracting("addr1")
		.containsOnly(addr1);

		assertThat(resultAttraction)
		.extracting("sidoCode")
		.containsOnly(sidoCode);

		assertThat(resultAttraction)
		.extracting("gugunCode")
		.containsOnly(gugunCode);
		
	}	
	
	@Test
	@DisplayName("관광지 정보 DAO 수정 테스트")
	public void updateAttractionTest() {
		
		//give
		//수정 대상 관광지 정보 DTO PK
		Long attractionId = 125266L;
		
		//DTO에 수정에 사용할 필드
		String afterTel="02-300-0114";
		String afterZipcode = "07552";
		String afterAddr1 = "경기도 고양시 덕양구 항공대학로 76";
		//수정 전 수정 후 데이터는 달라야함
		
		//수정 대상 미리 가져와서 확인
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(attractionId);
		List<AttractionInfo> beforeAttraction = attractionInfoDao.retrieveAttractionInfo(attractionSearchCondition);
		
		assertThat(beforeAttraction)
		.extracting("tel")
		.isNotEqualTo(afterTel);
		
		assertThat(beforeAttraction)
		.extracting("zipcode")
		.isNotEqualTo(afterZipcode);
		
		assertThat(beforeAttraction)
		.extracting("addr1")
		.isNotEqualTo(afterAddr1);
		
		//수정후 DTO (기대값)
		AttractionInfo afterAttraction = new AttractionInfo();
		afterAttraction.setAttractionId(attractionId);
		afterAttraction.setAddr1(afterAddr1);
		afterAttraction.setZipcode(afterZipcode);
		afterAttraction.setTel(afterTel);
		
		
		//when
		
		//수정한 행 가져오기
		Long resultRow = attractionInfoDao.updateAttractionInfo(afterAttraction);
		
		//then
		//수정한 행이 존재해야함
		assertThat(resultRow)
		.isNotNull()
		.isGreaterThanOrEqualTo(1L);
		
		//수정 후 DTO 가져오기
		List<AttractionInfo> resultAttraction = attractionInfoDao.retrieveAttractionInfo(attractionSearchCondition);
		
		//가져온 DTO는 하나여야함
		assertThat(resultAttraction)
		.hasSize(1);
		
		//수정한 DTO는 기대값과 같아야함
		assertThat(resultAttraction)
		.extracting("attractionId")
		.containsOnly(attractionId);
		
		assertThat(resultAttraction)
		.extracting("addr1")
		.containsOnly(afterAddr1);
		
		assertThat(resultAttraction)
		.extracting("zipcode")
		.containsOnly(afterZipcode);
		
		assertThat(resultAttraction)
		.extracting("tel")
		.containsOnly(afterTel);
		
	}	
	
	@Test
	@DisplayName("관광지 DAO 삭제 테스트")
	public void deleteAttractionTest() {
		
		//give
		//삭제 대상 DTO PK
		Long attractionId = 125266L;
		
		//수정 대상 미리 가져와서 확인
		AttractionSearchCondition attractionSearchCondition = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionId(attractionId);
		List<AttractionInfo> beforeAttraction = attractionInfoDao.retrieveAttractionInfo(attractionSearchCondition);
		
		//테스트 삭제 대상 DTO가 존재해야함
		assertThat(beforeAttraction)
		.hasSize(1);
		
		//when
		
		//관광지 삭제 (resultRow = 영향받은 행의 개수 삭제한 행의 개수) 
		Long resultRow = attractionInfoDao.deleteAttractionInfo(attractionSearchCondition);
		
		//then
		//삭제한 행이 존재해야함
		assertThat(resultRow)
		.isNotNull()
		.isGreaterThanOrEqualTo(1L);
		
		//삭제가 됐는지 확인하기위해 조회
		List<AttractionInfo> afterAttraction = attractionInfoDao.retrieveAttractionInfo(attractionSearchCondition);
		
		assertThat(afterAttraction)
		.hasSize(0);
		
		
	}	
}
