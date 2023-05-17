package com.enjoytrip.dao.attraction;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.dto.attraction.AttractionModifyRequest;

//Mybatis에 대한 DAO 유닛테스트
@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttractionModifyRequestDaoTest {
	
	//테스트 대상 DAO
	//관광지 수정요청에 관한 DAO
	@Autowired
	AttractionModifyRequestDao attractionModifyRequestDao;

	@Test
	@DisplayName("관광지 수정요청 userId로 가져오기  테스트")
	void retrieveRequestByUserIdTest() {
		//give
		//user_id를 통해 조회
		Long userId = new Long(1);
		
		//attraction_id는 사용하지않음
		Long attractionId = null;
		
		//request_id는 사용하지않음
		Long requestId = null;
		
		//test db에 저장된 기대값
		
		//기대값 List
		List<AttractionModifyRequest> amrList = new ArrayList<>();
		
		//기대값 result1
		AttractionModifyRequest expectResult1 = new AttractionModifyRequest();
		
		expectResult1.setAttractionId(125266L);	
		expectResult1.setUserId(userId);	
		expectResult1.setRequestedAt(new Timestamp(1684213714));	
		expectResult1.setRequestContent("fff");	
		expectResult1.setRequestComment(null);	
		expectResult1.setRequestStatus(AttractionModifyRequest.STATUS_READY);	
		expectResult1.setRequestId(1L);
		expectResult1.setRequestType("name");
		amrList.add(expectResult1);
		
		//기대값 result2
		AttractionModifyRequest expectResult2 = new AttractionModifyRequest();
		expectResult2.setAttractionId(125267L);
		expectResult2.setUserId(userId);		
		expectResult2.setRequestedAt(new Timestamp(1684214281));		
		expectResult2.setRequestContent("test2");		
		expectResult2.setRequestComment(null);		
		expectResult2.setRequestStatus(AttractionModifyRequest.STATUS_READY);		
		expectResult2.setRequestId(2L);
		expectResult2.setRequestType("address");
		amrList.add(expectResult2);
		
		//DAO가 가져온 결과를 담을 객체
		List<AttractionModifyRequest> resultList=null;
		//when
		
		try {
			resultList = attractionModifyRequestDao.retrieveRequest(requestId, userId, attractionId);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
		//then
		assertEquals(amrList,resultList);
	}
	

	@Test
	@DisplayName("관광지 수정요청 attractionId로 가져오기 테스트")
	void retrieveRequestByAttractionIdTest() {
		//give
		//user_id는 사용하지 않음
		Long userId = null;
		
		//attraction_id를 사용함
		Long attractionId = new Long(125267);
		
		//request_id는 사용하지않음
		Long requestId = null;
		
		//test db에 저장된 기대값
		
		//기대값 List
		List<AttractionModifyRequest> amrList = new ArrayList<>();
		
		//기대값 result1
		AttractionModifyRequest expectResult1 = new AttractionModifyRequest();
		
		expectResult1.setAttractionId(125267L);
		expectResult1.setUserId(1L);		
		expectResult1.setRequestedAt(new Timestamp(1684214281));		
		expectResult1.setRequestContent("test2");		
		expectResult1.setRequestComment(null);		
		expectResult1.setRequestStatus(AttractionModifyRequest.STATUS_READY);		
		expectResult1.setRequestId(2L);
		expectResult1.setRequestType("address");
		amrList.add(expectResult1);
		
		//기대값 result2
		AttractionModifyRequest expectResult2 = new AttractionModifyRequest();
		expectResult2.setAttractionId(125267L);		
		expectResult2.setUserId(2L);		
		expectResult2.setRequestedAt(new Timestamp(1684216939));		
		expectResult2.setRequestContent("test3");		
		expectResult2.setRequestComment(null);		
		expectResult2.setRequestStatus(AttractionModifyRequest.STATUS_READY);		
		expectResult2.setRequestId(3L);
		expectResult2.setRequestType("content");
		amrList.add(expectResult2);
		
		//DAO가 가져온 결과를 담을 객체
		List<AttractionModifyRequest> resultList=null;
		//when
		
		try {
			resultList = attractionModifyRequestDao.retrieveRequest(requestId, userId, attractionId);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
		//then
		assertEquals(amrList,resultList);
	}
	
	@Test
	@DisplayName("관광지 수정요청 requestId로 가져오기 테스트")
	void retrieveRequestByRequestIdTest() {
		//give
		//user_id는 사용하지 않음
		Long userId = null;
		
		//attraction_id는 사용하지않음
		Long attractionId = null;
		
		//request_id를 사용하여 가져옴
		Long requestId = new Long(2);
		
		//test db에 저장된 기대값
		
		//기대값 List
		List<AttractionModifyRequest> amrList = new ArrayList<>();
		
		//기대값 result1
		AttractionModifyRequest expectResult1 = new AttractionModifyRequest();
		
		expectResult1.setAttractionId(125267L);		
		expectResult1.setUserId(1L);		
		expectResult1.setRequestedAt(new Timestamp(1684214281));		
		expectResult1.setRequestContent("test2");		
		expectResult1.setRequestComment(null);		
		expectResult1.setRequestStatus(AttractionModifyRequest.STATUS_READY);		
		expectResult1.setRequestId(2L);
		expectResult1.setRequestType("address");
		amrList.add(expectResult1);
		
		//DAO가 가져온 결과를 담을 객체
		List<AttractionModifyRequest> resultList=null;
		//when
		
		try {
			resultList = attractionModifyRequestDao.retrieveRequest(requestId, userId, attractionId);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
		//then
		assertEquals(amrList,resultList);
	}

	
}
