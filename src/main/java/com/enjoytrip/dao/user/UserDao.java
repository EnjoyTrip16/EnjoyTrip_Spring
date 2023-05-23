package com.enjoytrip.dao.user;

import org.apache.ibatis.annotations.Mapper;

import com.enjoytrip.dto.user.User;
import com.enjoytrip.dto.user.UserSearch;

@Mapper
// user table DAO
// 사용자 테이블에 관한 DAO
public interface UserDao {

	// 사용자 생성 요청
	// return 생성한 User PK
	Long createUser(User user);

	// 사용자 검색
	// 로그인 (by id, pw)
	// 정보 검색 (by userId)
	// return 검색된 User
	User searchUser(UserSearch userSearch);

	// 사용자 수정 요청
	Long updateUser(User user);

	// 사용자 삭제 요청
	Long deleteUser(Long userId);

}
