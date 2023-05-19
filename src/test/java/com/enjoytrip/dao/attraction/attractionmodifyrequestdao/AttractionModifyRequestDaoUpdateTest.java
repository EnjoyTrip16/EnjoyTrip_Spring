package com.enjoytrip.dao.attraction.attractionmodifyrequestdao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.attraction.AttractionModifyRequestDao;
import com.enjoytrip.dto.attraction.AttractionModifyRequest;

//Mybatis에 대한 DAO 유닛테스트
@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttractionModifyRequestDaoUpdateTest {
	
	//테스트 대상 DAO
	//관광지 수정요청에 관한 DAO
	@Autowired
	AttractionModifyRequestDao attractionModifyRequestDao;
	
	@Test
	@DisplayName("관광지 수정요청 수정 테스트")
	void updateRequestTest() {
		//give
		
		//test db에 저장된 기대값
		
		//수정 대상인 DTO객체
		AttractionModifyRequest beforeRequestDto = null;		
		try {
			beforeRequestDto = attractionModifyRequestDao.retrieveRequest(1L,null,null).get(0);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
		//대상인 객체를 수정한 DTO 만들기
		//수정하지않을 필드
		AttractionModifyRequest afterRequestDto = new AttractionModifyRequest();
		afterRequestDto.setAttractionId(beforeRequestDto.getAttractionId());
		afterRequestDto.setRequestComment(beforeRequestDto.getRequestComment());
		afterRequestDto.setRequestedAt(beforeRequestDto.getRequestedAt());
		afterRequestDto.setRequestId(beforeRequestDto.getRequestId());
		afterRequestDto.setUserId(beforeRequestDto.getUserId());

		//테스트 조건에 대한 검증 필드 값이 같은 값으로 수정되면 안됨
		String afterRequestStatus = AttractionModifyRequest.STATUS_PROCESSED;
		String afterRequestType = AttractionModifyRequest.TYPE_ADDRESS;
		String afterRequestContent = "청태산이 뭐죵";
		assertNotEquals(beforeRequestDto.getRequestStatus(),afterRequestStatus);
		assertNotEquals(beforeRequestDto.getRequestType(),afterRequestType);
		assertNotEquals(beforeRequestDto.getRequestContent(),afterRequestContent);
		
		//수정 후 DTO
		afterRequestDto.setRequestStatus(afterRequestStatus);
		afterRequestDto.setRequestType(afterRequestType);
		afterRequestDto.setRequestContent(afterRequestContent);
		
		//수정후 기대 결과 DTO
		AttractionModifyRequest expectRequestDto = null;
		
		//when
		try {
			attractionModifyRequestDao.updateRequest(afterRequestDto);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
		//then
		try {
			expectRequestDto = attractionModifyRequestDao.retrieveRequest(beforeRequestDto.getRequestId(), null, null).get(0);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
		//수정하지 않은 필드 같은지 체크
		assertThat(expectRequestDto)
		.usingRecursiveComparison()
		.ignoringFields("requestStatus","requestType","requestContent")
		.isEqualTo(afterRequestDto);
		
	}
	
	
}
