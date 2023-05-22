package com.enjoytrip.service.hotplace;

import java.sql.SQLException;
import java.util.List;

import com.enjoytrip.dto.hotplace.HotplaceComment;

public interface HotplaceCommentsService {

	// 핫 플레이스에 댓글을 추가하는 메소드
	public Long createHotplaceComment(HotplaceComment hotplaceComment) throws SQLException;

	// 핫 플레이스 댓글을 수정하는 메소드
	public Long updateHotplaceComment(HotplaceComment hotplaceComment) throws SQLException;

	// 특정 핫 플레이스의 댓글을 조회하는 메소드
	List<HotplaceComment> searchHotplaceComments(Long hotplaceId) throws SQLException;

	// 특정 핫 플레이스의 총 댓글 수를 조회하는 메소드
	public Integer searchCommentByHotplace(Long hotplaceId) throws SQLException;

	// 특정 사용자가 핫 플레이스에 작성한 총 댓글 수를 조회하는 메소드
	public Integer searchCommentByUser(Long userId) throws SQLException;

	// 핫 플레이스 댓글을 삭제하는 메소드
	public Long deleteHotplaceComment(HotplaceComment hotplaceComment) throws SQLException;

}
