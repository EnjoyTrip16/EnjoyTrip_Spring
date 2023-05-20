package com.enjoytrip.dao.hotplace;

import java.util.List;

import com.enjoytrip.dto.hotplace.HotplaceSearchCondition;
import com.enjoytrip.dto.hotplace.HotplaceSimpleInfo;

// 간단히 보여질 핫 플레이스 DAO
public interface HotplaceSimpleInfoDao {

	List<HotplaceSimpleInfo> searchHotplaceSimpleInfo(HotplaceSearchCondition hotplaceSearchCondition);
}
