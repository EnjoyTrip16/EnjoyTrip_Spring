package com.enjoytrip.dao.hotplace;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.enjoytrip.dto.hotplace.HotplaceComment;

@Mapper
// 핫 플레이스 댓글 DAO
public interface HotplaceCommentsDao {

	// 핫 플레이스 댓글 삽입
	public Long createHotplaceComment(HotplaceComment hotplaceComment);

	// 핫 플레이스 댓글 수정
	public Long updateHotplaceComment(HotplaceComment hotplaceComment);

	// 핫 플레이스 댓글 조회
	List<HotplaceComment> searchHotplaceComments(Long hotplaceId);

	// 핫 플레이스의 총 댓글 수 조회
	public Integer searchCommentByHotplace(Long hotplaceId);

	// 사용자가 작성한 총 댓글 수 조회
	public Integer searchCommentByUser(Long userId);

	// 핫 플레이스 댓글 삭제
	public Long deleteHotplaceComment(HotplaceComment hotplaceComment);

}
