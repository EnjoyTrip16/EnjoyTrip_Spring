package com.enjoytrip.service.user;

import java.sql.SQLException;

import com.enjoytrip.dto.user.User;
import com.enjoytrip.dto.user.UserSearch;

public interface UserService {

	// 사용자 정보를 생성하는 메소드
	public Long createUser(User user) throws SQLException;

	// 조건에 맞는 사용자 정보를 검색하는 메소드
	public User searchUser(UserSearch userSearch) throws SQLException;

	// 사용자 정보를 수정하는 메소드
	public Long updateUser(User user) throws SQLException;

	// 사용자 정보를 삭제하는 메소드
	public Long deleteUser(Long userId) throws SQLException;
}
