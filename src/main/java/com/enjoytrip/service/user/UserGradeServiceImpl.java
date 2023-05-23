package com.enjoytrip.service.user;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.enjoytrip.dao.user.UserGradeDao;
import com.enjoytrip.dto.user.UserGrade;

@Service
public class UserGradeServiceImpl implements UserGradeService {

	private UserGradeDao userGradeDao;

	public UserGradeServiceImpl(UserGradeDao userGradeDao) {
		super();
		this.userGradeDao = userGradeDao;
	}

	@Override
	public Long createUserGrade(UserGrade userGrade) throws SQLException {
		return userGradeDao.createUserGrade(userGrade);
	}

	@Override
	public String searchUserGrade(Long userId) throws SQLException {
		return userGradeDao.searchUserGrade(userId);
	}

	@Override
	public Long updateUserGrade(UserGrade userGrade) throws SQLException {
		return userGradeDao.updateUserGrade(userGrade);
	}

	@Override
	public Long deleteUserGrade(Long userId) throws SQLException {
		return userGradeDao.deleteUserGrade(userId);
	}

}
