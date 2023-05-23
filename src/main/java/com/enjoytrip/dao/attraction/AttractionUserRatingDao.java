package com.enjoytrip.dao.attraction;

import java.util.List;

import com.enjoytrip.dto.attraction.AttractionUserRating;
import com.enjoytrip.dto.attraction.AttractionUserSearchCondition;

public interface AttractionUserRatingDao {
	
	public List<AttractionUserRating> retrieveAttractionUserRating(AttractionUserSearchCondition attractionUserSearchCondition);
	
	public Long createAttractionUserRating(AttractionUserRating attractionUserRating);
	
	public Long updateAttractionUserRating(AttractionUserRating attractionUserRating);
	
	public Long deleteAttractionUserRating(AttractionUserSearchCondition attractionUserSearchCondition);
}
