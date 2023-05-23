package com.enjoytrip.service.user;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.enjoytrip.dao.user.UserDetailDao;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	private UserDetailDao userDetailDao;

	public UserDetailServiceImpl(UserDetailDao userDetailDao) {
		super();
		this.userDetailDao = userDetailDao;
	}

	@Override
	public Long countAttractionBookmark(Long userId) throws SQLException {
		return userDetailDao.countAttractionBookmark(userId);
	}

	@Override
	public Long countAttractionFavor(Long userId) throws SQLException {
		return userDetailDao.countAttractionFavor(userId);
	}

	@Override
	public Long countHotplace(Long userId) throws SQLException {
		return userDetailDao.countHotplace(userId);
	}

	@Override
	public Long countPlanBookmark(Long userId) throws SQLException {
		return userDetailDao.countPlanBookmark(userId);
	}

	@Override
	public Long countPlanFavor(Long userId) throws SQLException {
		return userDetailDao.countPlanFavor(userId);
	}

	@Override
	public Long countPlanParticipate(Long userId) throws SQLException {
		return userDetailDao.countPlanParticipate(userId);
	}

}
