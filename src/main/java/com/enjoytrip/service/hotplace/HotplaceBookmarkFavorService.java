package com.enjoytrip.service.hotplace;

import java.sql.SQLException;

import com.enjoytrip.dto.hotplace.HotplaceBookmarkFavor;

public interface HotplaceBookmarkFavorService {

	// 핫 플레이스에 대한 북마크, 좋아요를 생성하는 메소드
	public Long createHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor) throws SQLException;

	// 핫 플레이스에 대한 북마크, 좋아요를 조회하는 메소드
	public HotplaceBookmarkFavor searchHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor)
			throws SQLException;

	// 특정 핫 플레이스에 대한 북마크 수를 조회하는 메소드
	public Integer countBookmarkByHotplace(Long hotplaceId) throws SQLException;

	// 특정 핫 플레이스에 대한 좋아요 수를 조회하는 메소드
	public Integer countFavorByHotplace(Long hotplaceId) throws SQLException;

	// 특정 사용자가 작성한 북마크 수를 조회하는 메소드
	public Integer countBookmarkByUser(Long userId) throws SQLException;

	// 특정 사용자가 작성한 좋아요 수 조회를 조회하는 메소드
	public Integer countFavorByUser(Long userId) throws SQLException;

	// 핫 플레이스에 대한 북마크, 좋아요를 수정하는 메소드
	public Long updateHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor) throws SQLException;

	// 핫 플레이스에 대한 북마크, 좋아요를 삭제하는 메소드
	public Long deleteHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor) throws SQLException;

}
