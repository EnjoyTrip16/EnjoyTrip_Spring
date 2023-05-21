package com.enjoytrip.dao.attraction;

import java.util.List;

import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionType;

public interface AttractionTypeDao {
	
	public List<AttractionType> retrieveAttractionType(AttractionSearchCondition attractionSearchCondition);
	
	public Long updateAttractionType(AttractionType attractionType);
	
	public Long deleteAttractionType(AttractionSearchCondition attractionSearchCondition);
	
	public Long createAttractionType(AttractionType attractionType);
	
}
