package com.enjoytrip.dao.attraction;

import java.util.List;

import com.enjoytrip.dto.attraction.AttractionUserBookmarkFavor;
import com.enjoytrip.dto.attraction.AttractionUserSearchCondition;

public interface AttractionUserBookmarkFavorDao {
	
	public List<AttractionUserBookmarkFavor> retrieveAttractionUserBookmarkFavor(AttractionUserSearchCondition aUserSearchCondition);
	
	public Long updateAttractionUserBookmarkFavor(AttractionUserBookmarkFavor attractionUserBookmarkFavor);
	
	public Long deleteAttractionUserBookmarkFavor(AttractionUserSearchCondition aUserSearchCondition);
	
	public Long createAttractionUserBookmarkFavor(AttractionUserBookmarkFavor attractionUserBookmarkFavor);
	
}
