package com.enjoytrip.dao.hotplace;

import com.enjoytrip.dto.hotplace.HotplaceBookmarkFavor;

// 핫 플레이스 북마크, 좋아요 DAO
public interface HotplaceBookmarkFavorDao {

	// 북마크, 좋아요 생성
	public Long createHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor);

	// 북마크, 좋아요 조회
	public HotplaceBookmarkFavor searchHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor);
	
	// 핫 플레이스에 대한 북마크 수 조회
	public Integer countBookmarkByHotplace(Long hotplaceId);
	
	// 핫 플레이스에 대한 좋아요 수 조회
	public Integer countFavorByHotplace(Long hotplaceId);
	
	// 사용자가 작성한 북마크 수 조회
	public Integer countBookmarkByUser(Long userId);
	
	// 사용자가 작성한 좋아요 수 조회
	public Integer countFavorByUser(Long userId);

	// 북마크, 좋아요 수정
	public Long updateHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor);

	// 북마크, 좋아요 삭제
	public Long deleteHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor);
}
