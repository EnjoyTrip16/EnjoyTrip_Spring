package com.enjoytrip.service.hotplace;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoytrip.dao.hotplace.HotplaceBookmarkFavorDao;
import com.enjoytrip.dto.hotplace.HotplaceBookmarkFavor;

@Service
public class HotplaceBookmarkFavorServiceImpl implements HotplaceBookmarkFavorService {

	private HotplaceBookmarkFavorDao hotplaceBookmarkFavorDao;

	@Autowired
	public HotplaceBookmarkFavorServiceImpl(HotplaceBookmarkFavorDao hotplaceBookmarkFavorDao) {
		super();
		this.hotplaceBookmarkFavorDao = hotplaceBookmarkFavorDao;
	}

	@Override
	public Long createHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor) throws SQLException {
		return hotplaceBookmarkFavorDao.createHotplaceBookmarkFavor(hotplaceBookmarkFavor);
	}

	@Override
	public HotplaceBookmarkFavor searchHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor)
			throws SQLException {
		return hotplaceBookmarkFavorDao.searchHotplaceBookmarkFavor(hotplaceBookmarkFavor);
	}

	@Override
	public Integer countBookmarkByHotplace(Long hotplaceId) throws SQLException {
		return hotplaceBookmarkFavorDao.countBookmarkByHotplace(hotplaceId);
	}

	@Override
	public Integer countFavorByHotplace(Long hotplaceId) throws SQLException {
		return hotplaceBookmarkFavorDao.countFavorByHotplace(hotplaceId);
	}

	@Override
	public Integer countBookmarkByUser(Long userId) throws SQLException {
		return hotplaceBookmarkFavorDao.countBookmarkByUser(userId);
	}

	@Override
	public Integer countFavorByUser(Long userId) throws SQLException {
		return hotplaceBookmarkFavorDao.countFavorByUser(userId);
	}

	@Override
	public Long updateHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor) throws SQLException {
		return hotplaceBookmarkFavorDao.updateHotplaceBookmarkFavor(hotplaceBookmarkFavor);
	}

	@Override
	public Long deleteHotplaceBookmarkFavor(HotplaceBookmarkFavor hotplaceBookmarkFavor) throws SQLException {
		return hotplaceBookmarkFavorDao.deleteHotplaceBookmarkFavor(hotplaceBookmarkFavor);
	}

}
