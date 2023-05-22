package com.enjoytrip.service.hotplace;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoytrip.dao.hotplace.HotplaceCommentsDao;
import com.enjoytrip.dto.hotplace.HotplaceComment;

@Service
public class HotplaceCommentsServiceImpl implements HotplaceCommentsService {

	private HotplaceCommentsDao hotplaceCommentsDao;

	@Autowired
	public HotplaceCommentsServiceImpl(HotplaceCommentsDao hotplaceCommentsDao) {
		super();
		this.hotplaceCommentsDao = hotplaceCommentsDao;
	}

	@Override
	public Long createHotplaceComment(HotplaceComment hotplaceComment) throws SQLException {
		return hotplaceCommentsDao.createHotplaceComment(hotplaceComment);
	}

	@Override
	public Long updateHotplaceComment(HotplaceComment hotplaceComment) throws SQLException {
		return hotplaceCommentsDao.updateHotplaceComment(hotplaceComment);
	}

	@Override
	public List<HotplaceComment> searchHotplaceComments(Long hotplaceId) throws SQLException {
		return hotplaceCommentsDao.searchHotplaceComments(hotplaceId);
	}

	@Override
	public Integer searchCommentByHotplace(Long hotplaceId) throws SQLException {
		return hotplaceCommentsDao.searchCommentByHotplace(hotplaceId);
	}

	@Override
	public Integer searchCommentByUser(Long userId) throws SQLException {
		return hotplaceCommentsDao.searchCommentByUser(userId);
	}

	@Override
	public Long deleteHotplaceComment(HotplaceComment hotplaceComment) throws SQLException {
		return hotplaceCommentsDao.deleteHotplaceComment(hotplaceComment);
	}

}
