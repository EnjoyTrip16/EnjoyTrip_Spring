package com.enjoytrip.service.hotplace;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoytrip.dao.hotplace.HotplaceDao;
import com.enjoytrip.dto.hotplace.Hotplace;
import com.enjoytrip.dto.hotplace.HotplaceSearchCondition;

@Service
public class HotplaceServiceImpl implements HotplaceService {

	private HotplaceDao hotplaceDao;

	@Autowired
	public HotplaceServiceImpl(HotplaceDao hotplaceDao) {
		super();
		this.hotplaceDao = hotplaceDao;
	}

	@Override
	public List<Hotplace> searchHotplace(HotplaceSearchCondition hotplaceSearchCondition) throws SQLException {
		return hotplaceDao.searchHotplace(hotplaceSearchCondition);
	}

	@Override
	public Long createHotplace(Hotplace hotplace) throws SQLException {
		return hotplaceDao.createHotplace(hotplace);
	}

	@Override
	public Long updateHotplace(Hotplace hotplace) throws SQLException {
		return hotplaceDao.updateHotplace(hotplace);
	}

	@Override
	public Long deleteHotplace(HotplaceSearchCondition hotplaceSearchCondition) throws SQLException {
		return hotplaceDao.deleteHotplace(hotplaceSearchCondition);
	}

}
