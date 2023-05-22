package com.enjoytrip.service.hotplace;

import java.sql.SQLException;
import java.util.List;

import com.enjoytrip.dto.hotplace.Hotplace;
import com.enjoytrip.dto.hotplace.HotplaceSearchCondition;

public interface HotplaceService {
	
	// 핫 플레이스 정보를 가져오는 메소드
	public List<Hotplace> searchHotplace(HotplaceSearchCondition hotplaceSearchCondition) throws SQLException;
	
	// 핫 플레이스 정보를 삽입하는 메소드
	public Long createHotplace(Hotplace hotplace) throws SQLException;
	
	// 핫 플레이스 정보를 수정하는 메소드
	public Long updateHotplace(Hotplace hotplace) throws SQLException;
	
	// 핫 플레이스 정보를 삭제하는 메소드
	public Long deleteHotplace(HotplaceSearchCondition hotplaceSearchCondition) throws SQLException;
}
