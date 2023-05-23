package com.enjoytrip.service.user;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoytrip.dao.user.UserDao;
import com.enjoytrip.dto.user.User;
import com.enjoytrip.dto.user.UserSearch;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Long createUser(User user) throws SQLException {
		return userDao.createUser(user);
	}

	@Override
	public User searchUser(UserSearch userSearch) throws SQLException {
		return userDao.searchUser(userSearch);
	}

	@Override
	public Long updateUser(User user) throws SQLException {
		return userDao.updateUser(user);
	}

	@Override
	public Long deleteUser(Long userId) throws SQLException {
		return userDao.deleteUser(userId);
	}

}
