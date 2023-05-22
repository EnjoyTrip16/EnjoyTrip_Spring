package com.enjoytrip.dao.attraction;

import java.util.List;

public interface AttractionUserBookmarkFavorDao {
	
	public List<AttractionUserBookmarkFavorDao> retrieveAttractionUserBookmarkFavor(Long userId,Long attractionId);
	
	public Long updateAttractionUserBookmarkFavor(Long userId,Long attractionId);
	
	public Long deleteAttractionUserBookmarkFavor(Long userId,Long attractionId);
	
	public Long createAttractionUserBookmarkFavor(Long userId,Long attractionId);
	
	
}
