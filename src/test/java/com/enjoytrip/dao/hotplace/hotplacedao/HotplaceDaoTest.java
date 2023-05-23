package com.enjoytrip.dao.hotplace.hotplacedao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.sound.sampled.ReverbType;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.hotplace.HotplaceDao;
import com.enjoytrip.dto.hotplace.Hotplace;
import com.enjoytrip.dto.hotplace.HotplaceSearchCondition;
import com.enjoytrip.dto.hotplace.HotplaceSortOrder;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotplaceDaoTest {

	@Autowired
	HotplaceDao hotplaceDao;

	@Test
	@Disabled
	@DisplayName("핫 플레이스 조회 (검색 조건: HotplaceId)")
	public void searchHotplaceByHotplaceId() {

		// given
		// 검색 조건: hotplaceId
		Long searchConditionHotplaceId = 1L;
		HotplaceSearchCondition hotplaceSearchCondition = new HotplaceSearchCondition();
		hotplaceSearchCondition.setHotplaceId(searchConditionHotplaceId);

		// when
		List<Hotplace> resultHotplace = hotplaceDao.searchHotplace(hotplaceSearchCondition);

		// then
		assertThat(resultHotplace).extracting("hotplaceId").containsOnly(searchConditionHotplaceId);
	}

	@Test
	@Disabled
	@DisplayName("핫 플레이스 조회 (검색 조건: keywordTitle)")
	public void searchHotplaceByKeywordTitle() {

		// given
		// 검색 조건: keywordTitle
		String searchConditionKeywordTitle = "도";
		HotplaceSearchCondition hotplaceSearchCondition = new HotplaceSearchCondition();
		hotplaceSearchCondition.setKeywordTitle(searchConditionKeywordTitle);

		// when
		List<Hotplace> resultHotplace = hotplaceDao.searchHotplace(hotplaceSearchCondition);

		// Print the resultHotplace values
		for (Hotplace hotplace : resultHotplace) {
			System.out.println("Title: " + hotplace.getTitle());
		}

		// then
		assertThat(resultHotplace).extracting(Hotplace::getTitle)
				.allMatch(title -> title.contains(searchConditionKeywordTitle));
	}

	@Test
	@Disabled
	@DisplayName("핫 플레이스 목록 조회 (검색 조건: userId)")
	public void searchHotplaceByUserId() {

		// given
		// 검색 조건: userId
		Long searchConditionUserId = 1L;
		HotplaceSearchCondition hotplaceSearchCondition = new HotplaceSearchCondition();
		hotplaceSearchCondition.setUserId(searchConditionUserId);

		// when
		List<Hotplace> resultHotplace = hotplaceDao.searchHotplace(hotplaceSearchCondition);

		// then
		assertThat(resultHotplace).extracting("userId").containsOnly(searchConditionUserId);
	}

	@Test
	@Disabled
	@DisplayName("핫 플레이스 목록 조회 (검색 조건: 없음) 및 정렬")
	public void searchHotplaceSorted() {

		// given
		// 검색 조건: 없음, 정렬
//		HotplaceSortOrder sortCondition = HotplaceSortOrder.DICTIONARY_ASC;
		HotplaceSortOrder sortCondition = HotplaceSortOrder.DICTIONARY_DESC;
		HotplaceSearchCondition hotplaceSearchCondition = new HotplaceSearchCondition();
		hotplaceSearchCondition.setSortOrder(sortCondition);

		// when
		List<Hotplace> resultHotplace = hotplaceDao.searchHotplace(hotplaceSearchCondition);

		// Print the resultHotplace values
		for (Hotplace hotplace : resultHotplace) {
			System.out.println("Title: " + hotplace.getTitle());
		}

		// then
		List<String> sortedTitles = resultHotplace.stream().map(Hotplace::getTitle).collect(Collectors.toList());

		List<String> expectedTitles = resultHotplace.stream().map(Hotplace::getTitle)
//		        .sorted()
				.sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		assertThat(sortedTitles).isEqualTo(expectedTitles);

	}

	@Test
	@Disabled
	@DisplayName("핫 플레이스 삽입")
	public void createHotplace() {

		// given
		// 핫 플레이스 DTO
		Long userId = 1L;
		String title = "테스트 제목";
		Long attractionId = 1L;

		Hotplace hotplace = new Hotplace();
		hotplace.setUserId(userId);
		hotplace.setTitle(title);
		hotplace.setAttractionId(attractionId);

		// when
		hotplaceDao.createHotplace(hotplace);

		List<Hotplace> resultHotplace = hotplaceDao.searchHotplace(new HotplaceSearchCondition());

		// then
		assertThat(resultHotplace).extracting(Hotplace::getTitle).allMatch(resulttitle -> title.contains(title));
	}
}
