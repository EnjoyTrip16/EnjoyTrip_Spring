package com.enjoytrip.dao.plan.plansimpleinfodao;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.plan.PlanSimpleInfoDao;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.PlanSearchOrder;
import com.enjoytrip.dto.plan.PlanSimpleInfo;
import com.enjoytrip.dto.plan.PlanVisibility;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlanSimpleinfoDaoTest {
	
	@Autowired
	PlanSimpleInfoDao planSimpleInfoDao;
	
	@Test
	@DisplayName("조회 테스트")
	public void retrievePlanSimpleinfoTest() {
		//give
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setVisibility(PlanVisibility.PRIVATE);
		
		List<PlanSimpleInfo> result = planSimpleInfoDao.retrievePlanSimpleInfo(planSearchCondition);
		
		System.out.println(result);
	}
	
}
