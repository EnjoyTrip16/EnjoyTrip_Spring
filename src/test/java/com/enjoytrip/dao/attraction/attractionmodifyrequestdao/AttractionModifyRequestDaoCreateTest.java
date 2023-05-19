package com.enjoytrip.dao.attraction.attractionmodifyrequestdao;

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
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dao.attraction.AttractionModifyRequestDao;
import com.enjoytrip.dto.attraction.AttractionModifyRequest;

//Mybatis에 대한 DAO 유닛테스트
@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttractionModifyRequestDaoCreateTest {
	
	//테스트 대상 DAO
	//관광지 수정요청에 관한 DAO
	@Autowired
	AttractionModifyRequestDao attractionModifyRequestDao;
	
	@Test
	@DisplayName("관광지 수정요청 생성 테스트")
	void createRequestTest() {
		//give
		
		//test db에 저장된 기대값
		
		//DB에 넣을 수정요청 DTO 객체
		AttractionModifyRequest createRequestDto = new AttractionModifyRequest();
		createRequestDto.setAttractionId(125266L);
		createRequestDto.setRequestComment(null);
		createRequestDto.setRequestContent("청태산이 뭐에용?");
		createRequestDto.setRequestStatus(AttractionModifyRequest.STATUS_READY);
		createRequestDto.setRequestType(AttractionModifyRequest.TYPE_ETC);
		createRequestDto.setUserId(2L);
		
		//DB에서 createdRequestId를 통해 가져온 수정요청
		//초기 수정요청 DTO객체와 같아야함
		List<AttractionModifyRequest> expectRequestDto = null;
		//when
		try {
			attractionModifyRequestDao.createRequest(createRequestDto);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
		//then
		try {
			expectRequestDto = attractionModifyRequestDao.retrieveRequest(createRequestDto.getRequestId(), null, null);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		assertThat(expectRequestDto)
		.usingRecursiveFieldByFieldElementComparatorIgnoringFields("requestId","requestedAt")
		.contains(createRequestDto);
	}
	
	
}
