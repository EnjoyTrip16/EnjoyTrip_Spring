package com.enjoytrip.dto.hotplace;

import java.time.LocalDateTime;
import java.util.List;

//핫 플레이스에 대한 세부 정보 DTO
public class HotplaceDetailInfo {

	// 핫 플레이스 번호 (PK)
	private Long hotplaceId;

	// 제목
	private String title;

	// 사용자 이름
	private Long username;

	// 북마크 수
	private Integer bookmarkCount;

	// 좋아요 수
	private Integer favorCount;

	// 조회수
	private Integer readCount;

	// 사진
	private String image;

	// 최초 등록 시간
	private LocalDateTime createdAt;

	// 마지막 변경 시간
	private LocalDateTime updatedAt;

	// 핫 플레이스 내용
	private String content;
	
	// 관광지 위도
	private String latitude;
	
	// 관광지 경도
	private String longitude;
	
	// 관광지 간단 정보
	// private AttractionSimpleInfo attractionSimpleInfo;
	
	// 댓글 수
	private Integer commentCount;

	// 댓글 리스트
	private List<HotplaceComments> commentsList;
}
