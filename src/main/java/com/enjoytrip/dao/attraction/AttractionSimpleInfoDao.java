package com.enjoytrip.dao.attraction;

import java.util.List;

import com.enjoytrip.dto.attraction.AttractionDescription;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionSimpleInfo;
import com.enjoytrip.dto.plan.response.AttractionTotalInfo;

public interface AttractionSimpleInfoDao {
	
	List<AttractionSimpleInfo> retrieveAttractionSimpleInfo(AttractionSearchCondition attractionSearchCondition);
	
}
