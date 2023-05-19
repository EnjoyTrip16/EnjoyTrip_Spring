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
public class AttractionModifyRequestDaoDeleteTest {
	
	//테스트 대상 DAO
	//관광지 수정요청에 관한 DAO
	@Autowired
	AttractionModifyRequestDao attractionModifyRequestDao;
	
	@Test
	@DisplayName("관광지 수정요청 삭제 테스트")
	void updateRequestTest() {
		//give
		
		//삭제 대상 DTO의 requestId
		Long requestId = 1L;
		
		//삭제 대상인 DTO객체
		AttractionModifyRequest beforeRequestDto = null;	
		
		//delete후 조회 결과가 담길 객체
		List<AttractionModifyRequest> resultList = null;
		try {
			beforeRequestDto = attractionModifyRequestDao.retrieveRequest(requestId,null,null).get(0);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		catch(NullPointerException e) {
			fail("존재하지 않는 테스트 대상 DTO");
		}
		
		//삭제 대상 DTO가 null이면 안됨
		assertThat(beforeRequestDto).isNotNull();
		
		//when
		try {
			attractionModifyRequestDao.deleteRequest(requestId);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
		//then
		try {
			resultList = attractionModifyRequestDao.retrieveRequest(beforeRequestDto.getRequestId(), null, null);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
		//삭제했으므로 requestId가 1인 수정요청이 존재하면 안됨
		assertThat(resultList).hasSize(0);
		
	}
	
	
}
