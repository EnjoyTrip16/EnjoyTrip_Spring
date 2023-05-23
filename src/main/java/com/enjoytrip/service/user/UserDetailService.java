package com.enjoytrip.service.user;

import java.sql.SQLException;

public interface UserDetailService {

	// 사용자의 관광지 북마크 수 반환 메소드
	Long countAttractionBookmark(Long userId) throws SQLException;

	// 사용자의 관광지 좋아요 수 반환 메소드
	Long countAttractionFavor(Long userId) throws SQLException;

	// 사용자의 핫 플레이스 후기 수 반환 메소드
	Long countHotplace(Long userId) throws SQLException;

	// 사용자의 여행 계획 북마크 수 반환 메소드
	Long countPlanBookmark(Long userId) throws SQLException;

	// 사용자의 여행 계획 좋아요 수 반환 메소드
	Long countPlanFavor(Long userId) throws SQLException;

	// 사용자의 참여 여행 계획 수 반환 메소드
	Long countPlanParticipate(Long userId) throws SQLException;

}
