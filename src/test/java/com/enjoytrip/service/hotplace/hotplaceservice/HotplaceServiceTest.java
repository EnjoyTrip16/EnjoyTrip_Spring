package com.enjoytrip.service.hotplace.hotplaceservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.hotplace.HotplaceDao;
import com.enjoytrip.dto.hotplace.Hotplace;
import com.enjoytrip.dto.hotplace.HotplaceSearchCondition;
import com.enjoytrip.dto.hotplace.HotplaceSortOrder;
import com.enjoytrip.service.hotplace.HotplaceService;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotplaceServiceTest {

	@Autowired
	private HotplaceDao hotplaceDao;

	@Autowired
	private HotplaceService hotplaceService;

	@Test
	@DisplayName("핫 플레이스 조회 (검색 조건: HotplaceId)")
	public void searchHotplaceByHotplaceId() throws SQLException {

		// given
		// 검색 조건: hotplaceId
		Long searchConditionHotplaceId = 1L;
		HotplaceSearchCondition hotplaceSearchCondition = new HotplaceSearchCondition();
		hotplaceSearchCondition.setHotplaceId(searchConditionHotplaceId);

		// when
		List<Hotplace> resultHotplace = hotplaceService.searchHotplace(hotplaceSearchCondition);

		// then
		assertThat(resultHotplace).extracting("hotplaceId").containsOnly(searchConditionHotplaceId);
	}

	@Test
	@DisplayName("핫 플레이스 조회 (검색 조건: keywordTitle)")
	public void searchHotplaceByKeywordTitle() throws SQLException {

		// given
		// 검색 조건: keywordTitle
		String searchConditionKeywordTitle = "도";
		HotplaceSearchCondition hotplaceSearchCondition = new HotplaceSearchCondition();
		hotplaceSearchCondition.setKeywordTitle(searchConditionKeywordTitle);

		// when
		List<Hotplace> resultHotplace = hotplaceService.searchHotplace(hotplaceSearchCondition);

		// Print the resultHotplace values
		for (Hotplace hotplace : resultHotplace) {
			System.out.println("Title: " + hotplace.getTitle());
		}

		// then
		assertThat(resultHotplace).extracting(Hotplace::getTitle)
				.allMatch(title -> title.contains(searchConditionKeywordTitle));
	}

	@Test
	@DisplayName("핫 플레이스 목록 조회 (검색 조건: userId)")
	public void searchHotplaceByUserId() throws SQLException {

		// given
		// 검색 조건: userId
		Long searchConditionUserId = 1L;
		HotplaceSearchCondition hotplaceSearchCondition = new HotplaceSearchCondition();
		hotplaceSearchCondition.setUserId(searchConditionUserId);

		// when
		List<Hotplace> resultHotplace = hotplaceService.searchHotplace(hotplaceSearchCondition);

		// then
		assertThat(resultHotplace).extracting("userId").containsOnly(searchConditionUserId);
	}

	@Test
	@DisplayName("핫 플레이스 목록 조회 (검색 조건: 없음) 및 정렬")
	public void searchHotplaceSorted() throws SQLException {

		// given
		// 검색 조건: 없음, 정렬
//		HotplaceSortOrder sortCondition = HotplaceSortOrder.DICTIONARY_ASC;
		HotplaceSortOrder sortCondition = HotplaceSortOrder.DICTIONARY_DESC;
		HotplaceSearchCondition hotplaceSearchCondition = new HotplaceSearchCondition();
		hotplaceSearchCondition.setSortOrder(sortCondition);

		// when
		List<Hotplace> resultHotplace = hotplaceService.searchHotplace(hotplaceSearchCondition);

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

}
