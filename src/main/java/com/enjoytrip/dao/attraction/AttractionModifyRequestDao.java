package com.enjoytrip.dao.attraction;

import java.sql.SQLException;
import java.util.List;

import com.enjoytrip.dto.attraction.AttractionModifyRequest;

//attraction_modify_request table DAO
//관광지 수정 요청에 관한 data DAO
public interface AttractionModifyRequestDao {
	
	//관광지 수정 요청을 생성함
	//return 생성한 AttractionModifyRequest PK
	public Long createRequest(AttractionModifyRequest req) throws SQLException;
	
	//관광지 수정요청을 가져옴
	//mybatis 동적 쿼리를 통해 요청에 대한 필터링(userId가 null일때 attractionId가 null일때)
	public List<AttractionModifyRequest> retrieveRequest(Long requestId,Long userId,Long attractionId) throws SQLException;
	
	//관광지 수정요청을 변경함
	public void updateRequest(AttractionModifyRequest req) throws SQLException;
	
	//관광지 수정요청을 삭제함
	//해당 requestId에 해당하는 관광지 수정요청삭제
	public void deleteRequest(Long requestId) throws SQLException;
}
