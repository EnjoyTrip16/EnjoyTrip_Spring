package com.enjoytrip.dao.plan.planattractiondao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.plan.PlanAttractionDao;
import com.enjoytrip.dto.plan.PlanAttraction;
import com.enjoytrip.dto.plan.PlanSearchCondition;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlanAttractionDaoTest {
	
	@Autowired
	PlanAttractionDao planAttractionDao;
	
	@Test
	@DisplayName("계획 - 관광지 조회")
	public void retrievePlanAttractionTest() {
		//give
		//계획 PK
		Long planId = 1L;
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(planId);
		//when
		List<PlanAttraction> planAttractionList = planAttractionDao.retrievePlanAttraction(planSearchCondition);
		
		//then
		assertThat(planAttractionList)
		.hasSizeGreaterThanOrEqualTo(1);
		
		assertThat(planAttractionList)
		.extracting("planId")
		.containsOnly(planId);
	}	
	
	@Test
	@DisplayName("계획 - 관광지 수정")
	public void updatePlanAttractionTest() {
		//give
		//계획 PK
		Long planId = 1L;
		Long attractionId = 125266L;
		Long sequence = 2L;
		
		PlanAttraction expectPlanAttraction = new PlanAttraction();
		expectPlanAttraction.setSequence(sequence);
		expectPlanAttraction.setPlanId(planId);
		expectPlanAttraction.setAttractionId(attractionId);
		
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		List<Long> attractionIdList = new ArrayList<>();
		attractionIdList.add(attractionId);
		planSearchCondition.setAttractionIdList(attractionIdList);
		planSearchCondition.setPlanId(planId);

		List<PlanAttraction> planAttractionList = planAttractionDao.retrievePlanAttraction(planSearchCondition);
		
		//수정 대상 행이 존재
		assertThat(planAttractionList)
		.hasSize(1);
		
		//when
		Long resultRow = planAttractionDao.updatePlanAttraction(expectPlanAttraction);
		
		//then
		assertThat(resultRow)
		.isEqualTo(1L);

		List<PlanAttraction> afterPlanAttractionList = planAttractionDao.retrievePlanAttraction(planSearchCondition);
		
		assertThat( afterPlanAttractionList)
		.usingRecursiveFieldByFieldElementComparatorOnFields("planId","attractionId","sequence")
		.containsOnly(expectPlanAttraction);
	}	
	
	@Test
	@DisplayName("계획 - 관광지 생성")
	public void createPlanAttractionTest() {
		//give
		//계획 PK
		Long planId = 1L;
		Long attractionId = 125290L;
		Long sequence = 2L;
		
		PlanAttraction expectPlanAttraction = new PlanAttraction();
		expectPlanAttraction.setSequence(sequence);
		expectPlanAttraction.setPlanId(planId);
		expectPlanAttraction.setAttractionId(attractionId);
		
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		List<Long> attractionIdList = new ArrayList<>();
		attractionIdList.add(attractionId);
		planSearchCondition.setAttractionIdList(attractionIdList);
		planSearchCondition.setPlanId(planId);
		
		//when
		Long resultRow = planAttractionDao.createPlanAttraction(expectPlanAttraction);
		
		//then
		assertThat(resultRow)
		.isEqualTo(1L);

		List<PlanAttraction> afterPlanAttractionList = planAttractionDao.retrievePlanAttraction(planSearchCondition);
		
		assertThat( afterPlanAttractionList)
		.hasSize(1);
		
		assertThat( afterPlanAttractionList)
		.usingRecursiveFieldByFieldElementComparatorOnFields("planId","attractionId","sequence")
		.containsOnly(expectPlanAttraction);
	}
	
	@Test
	@DisplayName("계획 - 관광지 삭제")
	public void deletelanAttractionTest() {
		//give
		//계획 PK
		Long planId = 1L;
		Long attractionId = 125266L;
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(planId);
		List<Long> attractionIdList = new ArrayList<>();
		attractionIdList.add(attractionId);
		planSearchCondition.setAttractionIdList(attractionIdList);
		
		//행이 존재해야함
		List<PlanAttraction> planAttractionList = planAttractionDao.retrievePlanAttraction(planSearchCondition);
		
		assertThat(planAttractionList)
		.hasSize(1);
		
		//when
		planAttractionDao.deletePlanAttraction(planSearchCondition);
		
		//then
		List<PlanAttraction> afterPlanAttractionList = planAttractionDao.retrievePlanAttraction(planSearchCondition);
		
		assertThat(afterPlanAttractionList)
		.isEmpty();
		
	}
}
