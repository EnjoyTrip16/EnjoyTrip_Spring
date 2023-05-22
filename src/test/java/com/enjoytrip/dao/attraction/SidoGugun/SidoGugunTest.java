package com.enjoytrip.dao.attraction.SidoGugun;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.attraction.SidoGugunDao;
import com.enjoytrip.dto.attraction.Gugun;
import com.enjoytrip.dto.attraction.Sido;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SidoGugunTest {
	
	@Autowired
	SidoGugunDao sidoGugunDao;
	
	@Test
	@DisplayName("시도 사져오기")
	public void retrieveSidoBySidoCodeTest() {
		//give
		//when
		List<Sido> sidoList = sidoGugunDao.retrieveSido();
		
		//then
		//시도의 행 개수는 7개이상
		assertThat(sidoList).
		hasSizeGreaterThanOrEqualTo(7);
		
		System.out.println(sidoList);
	}	
	
	@Test
	@DisplayName("구군 가져오기")
	public void retrieveGugunBySidoGugunCodeTest() {
		//give
		Long sidoCode = 1L;
		
		//when
		List<Gugun> seoulGugunList = sidoGugunDao.retrieveGugun(sidoCode, null);
		
		Long gugunCode = 1L;
		List<Gugun> sidoGugunList = sidoGugunDao.retrieveGugun(sidoCode, gugunCode);
		
		//then
		//가져온 구군 행은 서울의 구들
		assertThat(seoulGugunList)
		.hasSizeGreaterThan(6);
		
		//가져온 구군 행은 하나(시도와 구군이 정해짐)
		assertThat(sidoGugunList)
		.hasSize(1);
	}
}
