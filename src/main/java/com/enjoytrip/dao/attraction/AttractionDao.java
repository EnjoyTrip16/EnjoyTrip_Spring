package com.enjoytrip.dao.attraction;

import java.util.List;

import com.enjoytrip.dto.attraction.Attraction;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;

public interface AttractionDao {
	
	//attraction table 조회
	public List<Attraction> retrieveAttraction(AttractionSearchCondition attractionSearchCondition);
	
	//attraction table 삽입
	public Long createAttraction(Attraction attraction);
	
	//attraction table 수정
	public Long updateAttraction(Attraction attraction);
	
	//attraction table 삭제
	public Long deleteAttraction(AttractionSearchCondition attractionSearchCondition);
}
