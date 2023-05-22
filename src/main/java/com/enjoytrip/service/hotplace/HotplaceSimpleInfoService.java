package com.enjoytrip.service.hotplace;

import java.sql.SQLException;
import java.util.List;

import com.enjoytrip.dto.hotplace.HotplaceSearchCondition;
import com.enjoytrip.dto.hotplace.HotplaceSimpleInfo;

public interface HotplaceSimpleInfoService {

	// 조건에 맞는 핫 플레이스 간단 정보 검색 메소드 
	List<HotplaceSimpleInfo> searchHotplaceSimpleInfo(HotplaceSearchCondition hotplaceSearchCondition) throws SQLException;

}
