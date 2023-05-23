package com.enjoytrip.dao.user;

import org.apache.ibatis.annotations.Mapper;

import com.enjoytrip.dto.user.UserGrade;
@Mapper
// user_grade DAO
// 사용자 역할 테이블에 관한 DAO
public interface UserGradeDao {

	// 사용자 등급 생성 요청
	Long createUserGrade(UserGrade userGrade);
	
	// 사용자 등급 검색
	// return 검색된 사용자 등급
	String searchUserGrade(Long userId);
	
	// 사용자 등급 수정 요청
	Long updateUserGrade(UserGrade userGrade);
	
	// 사용자 등급 삭제 요청
	Long deleteUserGrade(Long userId);
	
}
