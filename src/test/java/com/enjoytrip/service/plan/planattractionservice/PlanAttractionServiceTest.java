package com.enjoytrip.service.plan.planattractionservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.service.plan.PlanAttractionService;
import com.enjoytrip.service.plan.PlanService;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlanAttractionServiceTest {
	
	@Autowired
	PlanAttractionService planAttractionService;
	
	@Test
	@DisplayName("계획 - 관광지 조회")
	public void retrievePlanAttractionTest() {
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		
		planSearchCondition.setPlanId(1L);
		
		
	}
	
	
}
