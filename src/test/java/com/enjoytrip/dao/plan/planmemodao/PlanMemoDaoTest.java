package com.enjoytrip.dao.plan.planmemodao;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.plan.PlanMemoDao;
import com.enjoytrip.dto.plan.PlanMemo;
import com.enjoytrip.dto.plan.PlanSearchCondition;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlanMemoDaoTest {
	
	@Autowired
	PlanMemoDao planMemoDao;	
	
	@Test
	@DisplayName("계획 메모 생성 테스트")
	public void createPlanMembertest() {
		//give
		PlanMemo planMemo = new PlanMemo();
		planMemo.setPlanId(1L);
		planMemo.setUserId(2L);
		planMemo.setContent("내용내용");
		planMemo.setTagId(1L);
		
		//when
		Long resultId = planMemoDao.createPlanMemo(planMemo);
		
		//then
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setMemberUserId(2L);
		List<PlanMemo> result = planMemoDao.retrievePlanMemo(planSearchCondition);
		System.out.println(result);
		System.out.println(planMemo.getPlanMemoId());
		
	}	
	
	@Test
	@DisplayName("계획 메모 수정 테스트")
	public void updatePlanMembertest() {
		//give
		PlanMemo planMemo = new PlanMemo();
		planMemo.setPlanMemoId(6L);
		planMemo.setUserId(2L);
		planMemo.setPlanId(1L);
		planMemo.setContent("테스트 수정");
		planMemo.setTagId(3L);
		
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanMemoId(6L);
		List<PlanMemo> result = planMemoDao.retrievePlanMemo(planSearchCondition);
		System.out.println("수정 전 : "+result);
		
		//when
		Long resultId = planMemoDao.updatePlanMemo(planMemo);
		
		//then		
		List<PlanMemo> afterResult = planMemoDao.retrievePlanMemo(planSearchCondition);
		System.out.println("수정 후 : "+afterResult);
		
	}

}
