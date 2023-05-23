package com.enjoytrip.service.hotplace;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoytrip.dao.hotplace.HotplaceSimpleInfoDao;
import com.enjoytrip.dto.hotplace.HotplaceSearchCondition;
import com.enjoytrip.dto.hotplace.HotplaceSimpleInfo;

@Service
public class HotplaceSimpleInfoServiceImpl implements HotplaceSimpleInfoService {

	private HotplaceSimpleInfoDao hotplaceSimpleInfoDao;

	@Autowired
	public HotplaceSimpleInfoServiceImpl(HotplaceSimpleInfoDao hotplaceSimpleInfoDao) {
		super();
		this.hotplaceSimpleInfoDao = hotplaceSimpleInfoDao;
	}

	@Override
	public List<HotplaceSimpleInfo> searchHotplaceSimpleInfo(HotplaceSearchCondition hotplaceSearchCondition)
			throws SQLException {
		return hotplaceSimpleInfoDao.searchHotplaceSimpleInfo(hotplaceSearchCondition);
	}

}
