package com.enjoytrip.dao.attraction.attractionuserbookmarkfavor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.attraction.AttractionUserBookmarkFavorDao;
import com.enjoytrip.dto.attraction.AttractionUserBookmarkFavor;
import com.enjoytrip.dto.attraction.AttractionUserSearchCondition;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttractionUserBookmarkFavorTest {
	
	@Autowired
	AttractionUserBookmarkFavorDao attractionUserBookmarkFavordao;

	
	@Test
	@DisplayName("북마크 좋아요 조회")
	public void retrieveAttractionUserBookmarkFavor() {
		//give
		List<Long> attractionIdList = new ArrayList<>();
		attractionIdList.add(125266L);
		attractionIdList.add(125267L);
		
		Long userId = 1L;
		
		AttractionUserSearchCondition attractionUserSearchCondition = new AttractionUserSearchCondition();
		attractionUserSearchCondition.setUserId(userId);
		attractionUserSearchCondition.setAttractionIdList(attractionIdList);
		
		//기대값
		AttractionUserBookmarkFavor expect1 = new AttractionUserBookmarkFavor();
		expect1.setAttractionId(125266L);
		expect1.setBookmark(true);
		expect1.setFavor(true);
		expect1.setUserId(userId);

		AttractionUserBookmarkFavor expect2 = new AttractionUserBookmarkFavor();
		expect2.setAttractionId(125267L);
		expect2.setBookmark(true);
		expect2.setFavor(false);
		expect2.setUserId(userId);
		//when
		List<AttractionUserBookmarkFavor> resultList = attractionUserBookmarkFavordao
				.retrieveAttractionUserBookmarkFavor(attractionUserSearchCondition);
		
		//then
		
		// 기대값을 포함해야함
		System.out.println(resultList);
		assertThat(resultList)
		.usingRecursiveFieldByFieldElementComparator()
		.contains(expect1,expect2);
		
	}		
	
	@Test
	@DisplayName("북마크 좋아요 생성")
	public void createAttractionUserBookmarkFavor() {
		
		//give
		
		//생성할 값
		Long userId = 1L;
		
		AttractionUserBookmarkFavor attractionUserBookmarkFavor = new AttractionUserBookmarkFavor();
		attractionUserBookmarkFavor.setAttractionId(125270L);
		attractionUserBookmarkFavor.setBookmark(true);
		attractionUserBookmarkFavor.setFavor(true);
		attractionUserBookmarkFavor.setUserId(userId);
		
		//생성 후 검색조건
		List<Long> attractionIdList = new ArrayList<>();
		attractionIdList.add(125270L);
		
		
		AttractionUserSearchCondition attractionUserSearchCondition = new AttractionUserSearchCondition();
		attractionUserSearchCondition.setUserId(userId);
		attractionUserSearchCondition.setAttractionIdList(attractionIdList);
		
		//when
		Long resultRow = attractionUserBookmarkFavordao.
				createAttractionUserBookmarkFavor(attractionUserBookmarkFavor);
		
		//then
		
		//삽입된 행은 하나
		assertThat(resultRow)
		.isEqualTo(1L);
		
		//삽입한 해잉 존재해야함
		
		List<AttractionUserBookmarkFavor> afterAttractionUserBookmarkFavors = 
		attractionUserBookmarkFavordao.retrieveAttractionUserBookmarkFavor(attractionUserSearchCondition);
		
		assertThat(afterAttractionUserBookmarkFavors)
		.hasSize(1);
		
	}	
	
	@Test
	@DisplayName("북마크 좋아요 수정")
	public void updateAttractionUserBookmarkFavor() {
		
		//give
		
		//생성할 값
		Long userId = 1L;
		Long attractionId = 125266L;
		
		//수정대상
		AttractionUserBookmarkFavor attractionUserBookmarkFavor = new AttractionUserBookmarkFavor();
		attractionUserBookmarkFavor.setAttractionId(attractionId);
		attractionUserBookmarkFavor.setUserId(userId);
		attractionUserBookmarkFavor.setBookmark(false);
		attractionUserBookmarkFavor.setFavor(false);
		
		
		//when
		Long resultRow = attractionUserBookmarkFavordao.
				updateAttractionUserBookmarkFavor(attractionUserBookmarkFavor);
		
		//then
		
		//수정된 행은 하나
		assertThat(resultRow)
		.isEqualTo(1L);
		
		//수정한 행이 가져온 결과와 일치해야함
		List<Long> attractionIdList = new ArrayList<>();
		attractionIdList.add(attractionId);
		
		AttractionUserSearchCondition attractionUserSearchCondition = new AttractionUserSearchCondition();
		attractionUserSearchCondition.setUserId(userId);
		attractionUserSearchCondition.setAttractionIdList(attractionIdList);
		
		
		List<AttractionUserBookmarkFavor> afterAttractionUserBookmarkFavors = 
		attractionUserBookmarkFavordao.retrieveAttractionUserBookmarkFavor(attractionUserSearchCondition);
		
		assertThat(afterAttractionUserBookmarkFavors)
		.usingRecursiveFieldByFieldElementComparator()
		.contains(attractionUserBookmarkFavor);
		
	}
	
	@Test
	@DisplayName("북마크 좋아요 삭제")
	public void deleteAttractionUserBookmarkFavor() {
		//give
		List<Long> attractionIdList = new ArrayList<>();
		attractionIdList.add(125266L);
		
		Long userId = 1L;
		
		AttractionUserSearchCondition attractionUserSearchCondition = new AttractionUserSearchCondition();
		attractionUserSearchCondition.setUserId(userId);
		attractionUserSearchCondition.setAttractionIdList(attractionIdList);
		
		//삭제할 행이 존재하는지 확인
		List<AttractionUserBookmarkFavor> attractionUserBookmarkFavors = 
				attractionUserBookmarkFavordao.retrieveAttractionUserBookmarkFavor(attractionUserSearchCondition);
		
		assertThat(attractionUserBookmarkFavors)
		.hasSize(1);
		
		//when
		Long resultRow = attractionUserBookmarkFavordao
				.deleteAttractionUserBookmarkFavor(attractionUserSearchCondition);
		
		//then
		
		//삭제된 행은 하나
		assertThat(resultRow)
		.isEqualTo(1L);
		
		//해당 행이 삭제되어 존재하지 않아야함
		
		List<AttractionUserBookmarkFavor> afterAttractionUserBookmarkFavors = 
		attractionUserBookmarkFavordao.retrieveAttractionUserBookmarkFavor(attractionUserSearchCondition);
		
		assertThat(afterAttractionUserBookmarkFavors)
		.hasSize(0);
	}
}
