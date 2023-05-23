package com.enjoytrip.dao.plan.planuserbookmarkfavor;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.plan.PlanSimpleInfoDao;
import com.enjoytrip.dao.plan.PlanUserBookmarkFavorDao;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.PlanSearchOrder;
import com.enjoytrip.dto.plan.PlanSimpleInfo;
import com.enjoytrip.dto.plan.PlanUserBookmarkFavor;
import com.enjoytrip.dto.plan.PlanVisibility;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlanUserBookmarkFavorDaoTest {
	
	@Autowired
	PlanUserBookmarkFavorDao planUserBookmarkFavorDao;
	
	@Test
	@DisplayName("조회 테스트")
	public void retrievePlanUserBookmarkFavorTest() {
		//give
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(1L);
		
		List<PlanUserBookmarkFavor> result = planUserBookmarkFavorDao.retrievePlanUserBookmarkFavor(planSearchCondition);
		
		System.out.println(result);
	}	
	
	@Test
	@DisplayName("생성 테스트")
	public void createPlanUserBookmarkFavorTest() {
		//give
		PlanUserBookmarkFavor planUserBookmarkFavor = new PlanUserBookmarkFavor();
		planUserBookmarkFavor.setBookmark(true);
		planUserBookmarkFavor.setFavor(false);
		planUserBookmarkFavor.setPlanId(1L);
		planUserBookmarkFavor.setUserId(3L);

		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(1L);
		planSearchCondition.setAuthorUserId(3L);
		
		Long result = planUserBookmarkFavorDao.createPlanUserBookmarkFavor(planUserBookmarkFavor);
		
		System.out.println(result);
		List<PlanUserBookmarkFavor> resultList = planUserBookmarkFavorDao.retrievePlanUserBookmarkFavor(planSearchCondition);	
		System.out.println(resultList);
	}	
	@Test
	@DisplayName("수정 테스트")
	public void updatePlanUserBookmarkFavorTest() {
		//give
		PlanUserBookmarkFavor planUserBookmarkFavor = new PlanUserBookmarkFavor();
		planUserBookmarkFavor.setBookmark(false);
		planUserBookmarkFavor.setFavor(false);
		planUserBookmarkFavor.setPlanId(1L);
		planUserBookmarkFavor.setUserId(2L);

		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(1L);
		planSearchCondition.setAuthorUserId(2L);
		
		Long result = planUserBookmarkFavorDao.updatePlanUserBookmarkFavor(planUserBookmarkFavor);
		
		System.out.println(result);
		List<PlanUserBookmarkFavor> resultList = planUserBookmarkFavorDao.retrievePlanUserBookmarkFavor(planSearchCondition);	
		System.out.println(resultList);
	}
	@Test
	@DisplayName("삭제 테스트")
	public void deletePlanUserBookmarkFavorTest() {
		//give

		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(1L);
		planSearchCondition.setAuthorUserId(2L);
		
		Long result = planUserBookmarkFavorDao.deletePlanUserBookmarkFavor(planSearchCondition);
		
		System.out.println(result);
		List<PlanUserBookmarkFavor> resultList = planUserBookmarkFavorDao.retrievePlanUserBookmarkFavor(planSearchCondition);	
		System.out.println(resultList);
	}
	
	
}
