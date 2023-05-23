package com.enjoytrip.service.user;

import java.sql.SQLException;

import com.enjoytrip.dto.user.UserGrade;

public interface UserGradeService {
	
	// 사용자 등급 생성 메소드
	Long createUserGrade(UserGrade userGrade) throws SQLException;

	// 사용자 등급 검색 메소드
	String searchUserGrade(Long userId) throws SQLException;

	// 사용자 등급 수정 메소드
	Long updateUserGrade(UserGrade userGrade) throws SQLException;

	// 사용자 등급 삭제 메소드
	Long deleteUserGrade(Long userId) throws SQLException;

}
