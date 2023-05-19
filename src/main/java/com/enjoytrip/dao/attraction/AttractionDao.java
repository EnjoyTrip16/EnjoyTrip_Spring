package com.enjoytrip.dao.attraction;

import java.util.List;

import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionSimpleInfo;
import com.enjoytrip.dto.attraction.AttractionTotalInfo;

public interface AttractionDao {
	
	List<AttractionSimpleInfo> retrieveAttractionSimpleInfo(AttractionSearchCondition attractionSearchCondition);
	
	List<AttractionTotalInfo> retrieveAttractionTotalInfo(AttractionSearchCondition attractionSearchCondition);
	
	AttractionTotalInfo retrieveAttractionTotalInfo(Long attractionId);
	
	Long createAttraction(AttractionTotalInfo attractionTotalInfo);
	
	Long deleteAttraction(Long attractionId);
	
	Long updateAttraction(AttractionTotalInfo attractionTotalInfo);
	
}
