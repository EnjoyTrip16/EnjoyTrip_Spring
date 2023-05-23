package com.enjoytrip.dao.plan.planmemotagdao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.plan.PlanMemoTagDao;
import com.enjoytrip.dto.plan.PlanMemoTag;
import com.enjoytrip.dto.plan.PlanSearchCondition;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlanMemoTagDaoTest {
	
	@Autowired
	PlanMemoTagDao planMemoTagDao;	
	
	@Test
	@DisplayName("계획 메모 생성 테스트")
	public void createPlanMemoTagtest() {
		//give
		PlanMemoTag planMemoTag = new PlanMemoTag();
		planMemoTag.setTagName("레포츠");
		
		//when
		Long resultRow = planMemoTagDao.createPlanMemoTag(planMemoTag);
		
		//then
		assertThat(resultRow)
		.isEqualTo(1);

		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setTagId(planMemoTag.getTagId());
		
		List<PlanMemoTag> result = planMemoTagDao.retrievePlanMemoTag(planSearchCondition);
		
		System.out.println(result);
		
	}	
	
	@Test
	@DisplayName("계획 메모 삭제 테스트")
	public void deletePlanMemoTagtest() {
		//give
		PlanMemoTag planMemoTag = new PlanMemoTag();
		planMemoTag.setTagId(3L);
		planMemoTag.setTagName("시간");

		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setTagId(3L);

		List<PlanMemoTag> result = planMemoTagDao.retrievePlanMemoTag(planSearchCondition);
		
		assertThat(result)
		.hasSize(1);
		
		System.out.println("수정 전 "+result);
		
		//when
		Long resultRow = planMemoTagDao.updatePlanMemoTag(planMemoTag);
		
		//then
		assertThat(resultRow)
		.isEqualTo(1);
		
		List<PlanMemoTag> afterResult = planMemoTagDao.retrievePlanMemoTag(planSearchCondition);
		

		assertThat(afterResult)
		.hasSize(1);
		
		System.out.println("수정 후 "+afterResult);
		
	}
	
	@Test
	@DisplayName("계획 메모 수정 테스트")
	public void updatePlanMemoTagtest() {
		//give

		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setTagId(3L);

		List<PlanMemoTag> result = planMemoTagDao.retrievePlanMemoTag(planSearchCondition);
		
		assertThat(result)
		.hasSize(1);
		
		//when
		Long resultRow = planMemoTagDao.deletePlanMemoTag(planSearchCondition);
		
		//then
		assertThat(resultRow)
		.isEqualTo(1);
		
		List<PlanMemoTag> afterResult = planMemoTagDao.retrievePlanMemoTag(planSearchCondition);
		

		assertThat(afterResult)
		.hasSize(0);
		
	}

}
