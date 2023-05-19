package com.enjoytrip.dao.user;

// 사용자의 북마크 및 좋아요 정보에 대한 DAO
public interface UserDetailDao {

	// 사용자가 북마크한 관광지 수 반환
	Long countAttractionBookmark(Long userId);

	// 사용자가 종아요한 관광지 수 반환
	Long countAttractionFavor(Long userId);

	// 사용자가 작성한 핫플레이스 후기 수 반환
	Long countHotplace(Long userId);

	// 사용자가 북마크한 여행 계획 수 반환
	Long countPlanBookmark(Long userId);

	// 사용자가 좋아요한 여행 계획 수 반환
	Long countPlanFavor(Long userId);

	// 사용자가 참여한 여행 계획 수 반환
	Long countPlanParticipate(Long userId);

}
