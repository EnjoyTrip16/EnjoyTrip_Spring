package com.enjoytrip.dao.hotplace;

import org.apache.ibatis.annotations.Mapper;

import com.enjoytrip.dto.hotplace.HotplaceBookmarkFavor;

@Mapper
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

	// 북마크, 좋아요 수정
	public Long updateHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor);

	// 북마크, 좋아요 삭제
	public Long deleteHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor);
}
