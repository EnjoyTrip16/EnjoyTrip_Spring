package com.enjoytrip.service.plan.planretrieveservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dto.plan.request.PlanThumbnailRequest;
import com.enjoytrip.dto.plan.response.PlanThumbnail;
import com.enjoytrip.service.plan.PlanRetrieveService;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlanRetrieveServiceTest {
	
	@Autowired
	PlanRetrieveService planRetrieveService;
	
	@Test
	@DisplayName("retrievePlanThumbnailTest")
	public void retrievePlan() {
		PlanThumbnailRequest planThumbnailRequest = new PlanThumbnailRequest();
		List<PlanThumbnail> planThumbnailList = planRetrieveService.getPlanThumbnail(planThumbnailRequest);
		assertThat(planThumbnailList)
		.isNotEmpty();
	}
}
