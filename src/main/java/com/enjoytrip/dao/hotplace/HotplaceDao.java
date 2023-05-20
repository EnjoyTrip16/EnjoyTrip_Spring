package com.enjoytrip.dao.hotplace;

import java.util.List;

import com.enjoytrip.dto.hotplace.Hotplace;
import com.enjoytrip.dto.hotplace.HotplaceSearchCondition;

// 핫 플레이스 테이블 DAO
public interface HotplaceDao {

	// hotplace table 조회
	public List<Hotplace> searchHotplace(HotplaceSearchCondition hotplaceSearchCondition);

	// hotplace 삽입
	public Long createHotplace(Hotplace hotplace);

	// hotplace 수정
	public Long updateHotplace(Hotplace hotplace);

	// hotplace 삭제
	public Long deleteHotplace(HotplaceSearchCondition hotplaceSearchCondition);

}
