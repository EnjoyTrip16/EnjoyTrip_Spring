package com.enjoytrip.dao.attraction;

import java.util.List;

import com.enjoytrip.dto.attraction.AttractionInfo;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;

public interface AttractionInfoDao {
	
	public List<AttractionInfo> retrieveAttractionInfo(AttractionSearchCondition attractionSearchCondition);
	
	public Long updateAttractionInfo(AttractionInfo attractionInfo);
	
	public Long deleteAttractionInfo(AttractionSearchCondition attractionSearchCondition);
	
	public Long createAttractionInfo(AttractionInfo attractionInfo);
	
}
