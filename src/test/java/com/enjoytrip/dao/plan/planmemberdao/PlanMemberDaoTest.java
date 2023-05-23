package com.enjoytrip.dao.plan.planmemberdao;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.plan.PlanMemberDao;
import com.enjoytrip.dto.plan.PlanMember;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.PlanUserRole;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlanMemberDaoTest {
	
	@Autowired
	PlanMemberDao planMemberDao;	
	
	@Test
	@DisplayName("계획 멤버 생성 테스트")
	public void createPlanMembertest() {
		//give
		PlanMember planMember = new PlanMember();
		planMember.setPlanId(1L);
		planMember.setUserId(3L);
		planMember.setRole(PlanUserRole.Creater);
		
		//when
		planMemberDao.createPlanMember(planMember);
		
		//then
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(1L);
		List<PlanMember> result = planMemberDao.retrievePlanMember(planSearchCondition);
		System.out.println(result);
		
	}
	

	@Test
	@DisplayName("계획 멤버 조회 테스트")
	public void retrievePlanMembertest() {
		//give
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(1L);
		
		//when
		List<PlanMember> result = planMemberDao.retrievePlanMember(planSearchCondition);
		
		//then
		System.out.println(result);
		
	}	

	@Test
	@DisplayName("계획 멤버 수정 테스트")
	public void updatePlanMembertest() {
		//give
		PlanMember planMember = new PlanMember();
		planMember.setPlanId(1L);
		planMember.setUserId(2L);
		planMember.setRole(PlanUserRole.Reader);
		
		//when
		Long resultRow = planMemberDao.updatePlanMember(planMember);
		
		//then
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(1L);
		planSearchCondition.setMemberUserId(2L);
		List<PlanMember> result = planMemberDao.retrievePlanMember(planSearchCondition);
		System.out.println(result);
		
	}

	@Test
	@DisplayName("계획 멤버 삭제 테스트")
	public void deletePlanMembertest() {
		//give	
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(1L);
		planSearchCondition.setMemberUserId(2L);
		
		//when
		Long resultRow = planMemberDao.deletePlanMember(planSearchCondition);
		
		//then
		List<PlanMember> result = planMemberDao.retrievePlanMember(planSearchCondition);
		System.out.println(result);
		
	}
}
