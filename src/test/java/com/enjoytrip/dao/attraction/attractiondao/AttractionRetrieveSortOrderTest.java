package com.enjoytrip.dao.attraction.attractiondao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.attraction.AttractionDao;
import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionSimpleInfo;
import com.enjoytrip.dto.attraction.AttractionSortOrder;

//Mybatis에 대한 DAO 유닛테스트
@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttractionRetrieveSortOrderTest {
	
	//테스트 대상 DAO
	//관광지 CRUD에 관한 DAO
	@Autowired
	AttractionDao attractionDao;
	
	//Mysql의 String에 대한 특정 collation에 대한 정렬을 JAVA에서 검증하는 것은 매우어려움
	//따라서 이에 대한 해결방안을 생각해야함
	@Test
	@DisplayName("검색조건 정렬기준 북마크수 오름차순 내림차순 테스트")
	public void retrieveAttractionSimpleInfoByBookmarkOrderTest() {
		//검색결과에 해당하는 관광지ID가 검색조건 관광지ID가 같아야함
		
		//give
		
		//정렬기준인 북마크 오름차순 내림차순
		AttractionSortOrder sortOrderBookmarkASC = AttractionSortOrder.BOOKMARK_ASC;
		AttractionSortOrder sortOrderBookmarkDESC = AttractionSortOrder.BOOKMARK_DESC;
		
		//검색조건 DTO 오름차순
		AttractionSearchCondition attractionSearchConditionASC =  new AttractionSearchCondition();
		attractionSearchConditionASC.setSortOrder(sortOrderBookmarkASC);
		
		//검색조건 DTO 내림차순
		AttractionSearchCondition attractionSearchConditionDESC =  new AttractionSearchCondition();
		attractionSearchConditionDESC.setSortOrder(sortOrderBookmarkDESC);
		
		//when
		
		List<AttractionSimpleInfo> resultAttractionSimpleInfoListASC = attractionDao.retrieveAttractionSimpleInfo(attractionSearchConditionASC);
		List<AttractionSimpleInfo> resultAttractionSimpleInfoListDESC = attractionDao.retrieveAttractionSimpleInfo(attractionSearchConditionDESC);
		//then
		
		//오름차순 내림차순 정렬한 두검색결과의 사이즈는 같아야하며 1이 넘어야함
		assertThat(resultAttractionSimpleInfoListASC)
		.hasSize(resultAttractionSimpleInfoListDESC.size())
		.hasSizeGreaterThan(1);
		
		//검색결과가 관광지명을 기준으로 오름차순으로 정렬되어있는지
		assertThat(resultAttractionSimpleInfoListASC)
		.usingElementComparator(Comparator.comparingInt(AttractionSimpleInfo::getBookmark))
		.isSorted();
		
		//검색결과가 관광지명을 기준으로 내림차순으로 정렬되어있는지
		assertThat(resultAttractionSimpleInfoListDESC)
		.usingElementComparator(Comparator.comparingInt(AttractionSimpleInfo::getBookmark).reversed())
		.isSorted();
	}	
	
	@Test
	@DisplayName("검색조건 정렬기준 좋아요수 오름차순 내림차순 테스트")
	public void retrieveAttractionSimpleInfoByFavorOrderTest() {
		//검색결과에 해당하는 관광지ID가 검색조건 관광지ID가 같아야함
		
		//give
		
		//정렬기준 좋아요수 오름차순 내림차순
		AttractionSortOrder sortOrderFavorASC = AttractionSortOrder.FAVOR_ASC;
		AttractionSortOrder sortOrderFavorDESC = AttractionSortOrder.FAVOR_DESC;
		
		//검색조건 DTO 오름차순
		AttractionSearchCondition attractionSearchConditionASC =  new AttractionSearchCondition();
		attractionSearchConditionASC.setSortOrder(sortOrderFavorASC);
		
		//검색조건 DTO 내림차순
		AttractionSearchCondition attractionSearchConditionDESC =  new AttractionSearchCondition();
		attractionSearchConditionDESC.setSortOrder(sortOrderFavorDESC);
		
		//when
		
		List<AttractionSimpleInfo> resultAttractionSimpleInfoListASC = attractionDao.retrieveAttractionSimpleInfo(attractionSearchConditionASC);
		List<AttractionSimpleInfo> resultAttractionSimpleInfoListDESC = attractionDao.retrieveAttractionSimpleInfo(attractionSearchConditionDESC);
		//then
		
		//오름차순 내림차순 정렬한 두검색결과의 사이즈는 같아야하며 1이 넘어야함
		assertThat(resultAttractionSimpleInfoListASC)
		.hasSize(resultAttractionSimpleInfoListDESC.size())
		.hasSizeGreaterThan(1);
		
		//검색결과가 관광지명을 기준으로 오름차순으로 정렬되어있는지
		assertThat(resultAttractionSimpleInfoListASC)
		.usingElementComparator(Comparator.comparingInt(AttractionSimpleInfo::getFavor))
		.isSorted();
		
		//검색결과가 관광지명을 기준으로 내림차순으로 정렬되어있는지
		assertThat(resultAttractionSimpleInfoListDESC)
		.usingElementComparator(Comparator.comparingInt(AttractionSimpleInfo::getFavor).reversed())
		.isSorted();
	}	
	
	@Test
	@DisplayName("검색조건 정렬기준 평점순 오름차순 내림차순 테스트")
	public void retrieveAttractionSimpleInfoByRatingOrderTest() {
		//검색결과에 해당하는 관광지ID가 검색조건 관광지ID가 같아야함
		
		//give
		
		//정렬기준 평점순 오름차순 내림차순
		AttractionSortOrder sortOrderRatingASC = AttractionSortOrder.RATING_ASC;
		AttractionSortOrder sortOrderRatingDESC = AttractionSortOrder.RATING_DESC;
		
		//검색조건 DTO 오름차순
		AttractionSearchCondition attractionSearchConditionASC =  new AttractionSearchCondition();
		attractionSearchConditionASC.setSortOrder(sortOrderRatingASC);
		
		//검색조건 DTO 내림차순
		AttractionSearchCondition attractionSearchConditionDESC =  new AttractionSearchCondition();
		attractionSearchConditionDESC.setSortOrder(sortOrderRatingDESC);
		
		//when
		
		List<AttractionSimpleInfo> resultAttractionSimpleInfoListASC = attractionDao.retrieveAttractionSimpleInfo(attractionSearchConditionASC);
		List<AttractionSimpleInfo> resultAttractionSimpleInfoListDESC = attractionDao.retrieveAttractionSimpleInfo(attractionSearchConditionDESC);
		//then
		
		//오름차순 내림차순 정렬한 두검색결과의 사이즈는 같아야하며 1이 넘어야함
		assertThat(resultAttractionSimpleInfoListASC)
		.hasSize(resultAttractionSimpleInfoListDESC.size())
		.hasSizeGreaterThan(1);
		
		//검색결과가 관광지명을 기준으로 오름차순으로 정렬되어있는지
		assertThat(resultAttractionSimpleInfoListASC)
		.usingElementComparator(Comparator.comparingDouble(AttractionSimpleInfo::getRating))
		.isSorted();
		
		//검색결과가 관광지명을 기준으로 내림차순으로 정렬되어있는지
		assertThat(resultAttractionSimpleInfoListDESC)
		.usingElementComparator(Comparator.comparingDouble(AttractionSimpleInfo::getRating).reversed())
		.isSorted();
	}		
}
