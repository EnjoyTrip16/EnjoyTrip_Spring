package com.enjoytrip.dao.plan.plandao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.plan.PlanDao;
import com.enjoytrip.dto.plan.Plan;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.PlanVisibility;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlanDaoTest {

	@Autowired
	PlanDao planDao;	
	
	@Test
	@DisplayName("여행 게획 조회")
	public void retrievePlanTest() {
		//give
		//검색조건 
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(1L);
		
		PlanSearchCondition planSearchCondition2 = new PlanSearchCondition();
		planSearchCondition2.setAuthorUserId(2L);
		//when
		List<Plan> resultPlan= planDao.retrievePlan(planSearchCondition);
		List<Plan> resultPlan2= planDao.retrievePlan(planSearchCondition2);
		
		//then
		
		assertThat(resultPlan)
		.hasSizeGreaterThanOrEqualTo(1);
		
		assertThat(resultPlan2)
		.hasSizeGreaterThanOrEqualTo(1);
		
		assertThat(resultPlan)
		.extracting("planId")
		.containsOnly(1L);
		
		assertThat(resultPlan2)
		.extracting("userId")
		.containsOnly(2L);
	}
	
	@Test
	@DisplayName("여행 게획 수정")
	public void updatePlanTest() {
		//give
		//수정 대상 DTO
		Plan plan = new Plan();
		plan.setPlanName("전주 먹부림");
		plan.setVisibility(PlanVisibility.PUBLIC);
		plan.setPlanId(1L);
		
		//when
		Long resultRow = planDao.updatePlan(plan);
		
		assertThat(resultRow)
		.isEqualTo(1L);
		
		//then
		//검색조건 가져온 PK
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(plan.getPlanId());
		List<Plan> planList = planDao.retrievePlan(planSearchCondition);
		
		assertThat(planList)
		.hasSize(1);
		
		assertThat(planList)
		.usingRecursiveFieldByFieldElementComparatorOnFields("planName","visibility","planId")
		.containsOnly(plan);
	}
	
	@Test
	@DisplayName("여행 게획 삽입")
	public void createPlanTest() {
		//give
		//삽입 대상 DTO
		Plan plan = new Plan();
		plan.setPlanName("전주 먹부림");
		plan.setVisibility(PlanVisibility.PUBLIC);
		plan.setUserId(1L);
		
		//when
		Long resultRow = planDao.createPlan(plan);
		
		assertThat(resultRow)
		.isEqualTo(1L);
		//then
		//검색조건 가져온 PK
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(plan.getPlanId());
		List<Plan> planList = planDao.retrievePlan(planSearchCondition);
		
		assertThat(planList)
		.hasSize(1);
		
		assertThat(planList)
		.usingRecursiveFieldByFieldElementComparatorIgnoringFields("createdAt","readCount")
		.containsOnly(plan);
	}

	
	@Test
	@DisplayName("여행 게획 삭제")
	public void deletePlanTest() {
		//give
		//검색조건 
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(1L);
		
		PlanSearchCondition planSearchCondition2 = new PlanSearchCondition();
		planSearchCondition2.setAuthorUserId(2L);
		
		List<Plan> beforePlan= planDao.retrievePlan(planSearchCondition);
		List<Plan> beforePlan2= planDao.retrievePlan(planSearchCondition2);
		
		assertThat(beforePlan)
		.hasSize(1);	
		
		assertThat(beforePlan2)
		.hasSize(1);
		
		//when
		Long resultRow = planDao.deletePlan(planSearchCondition);
		Long resultRow2 = planDao.deletePlan(planSearchCondition2);
		
		//then
		
		assertThat(resultRow)
		.isEqualTo(1);
		
		assertThat(resultRow2)
		.isEqualTo(1);

		
		List<Plan> afterPlan= planDao.retrievePlan(planSearchCondition);
		List<Plan> afterPlan2= planDao.retrievePlan(planSearchCondition2);
		
		assertThat(afterPlan)
		.isEmpty();
		
		assertThat(afterPlan2)
		.isEmpty();
	}
}
