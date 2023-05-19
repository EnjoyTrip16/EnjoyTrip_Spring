package com.enjoytrip.dao.attraction;

import com.enjoytrip.dto.attraction.AttractionDescription;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;

public interface AttractionDescriptionDao {
	
	public Long createAttractionDescription(AttractionDescription attractionDescription);
	
	public Long deleteAttractionDescription(AttractionSearchCondition attractionSearchCondition);
	
	public Long updateAttractionDescription(AttractionDescription attractionDescription);
	
	public AttractionDescription retrieveAttractionDescription(AttractionSearchCondition attractionSearchCondition);
}
