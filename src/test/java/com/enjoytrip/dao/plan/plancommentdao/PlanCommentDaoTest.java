package com.enjoytrip.dao.plan.plancommentdao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.enjoytrip.dao.plan.PlanCommentDao;
import com.enjoytrip.dao.plan.PlanDao;
import com.enjoytrip.dto.plan.Plan;
import com.enjoytrip.dto.plan.PlanComment;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.PlanVisibility;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlanCommentDaoTest {

	@Autowired
	PlanCommentDao planCommentDao;	
	
	@Test
	@DisplayName("계획 댓글 조회")
	public void retrievePlanCommentTest() {
		//give
		//검색조건 
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setPlanId(1L);
		//when
		List<PlanComment> resultPlanComment= planCommentDao.retrievePlanComment(planSearchCondition);
		
		//then
		System.out.println(resultPlanComment);
	}		
	
	@Test
	@DisplayName("계획 댓글 생성")
	public void createPlanCommentTest() {
		//give
		//검색조건 
		PlanComment planComment = new PlanComment();
		planComment.setPlanId(2L);
		planComment.setUserId(3L);
		planComment.setReplyId(1L);
		planComment.setContent("청태산이뭐에용");		
		
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		//when
		
		Long resultRow = planCommentDao.createPlanComment(planComment);
		planSearchCondition.setCommentId(planComment.getCommentId());
		List<PlanComment> resultPlanComment= planCommentDao.retrievePlanComment(planSearchCondition);
		
		//then
		System.out.println(resultRow);
		System.out.println(resultPlanComment);
	}
	
	@Test
	@DisplayName("계획 댓글 수정")
	public void updatePlanCommentTest() {
		//give
		//검색조건 
		PlanComment planComment = new PlanComment();
		planComment.setCommentId(5L);
		planComment.setContent("청태산이뭐에용");		
		
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setCommentId(5L);;
		//when
		
		Long resultRow = planCommentDao.updatePlanComment(planComment);
		List<PlanComment> resultPlanComment= planCommentDao.retrievePlanComment(planSearchCondition);
		
		//then
		System.out.println(resultRow);
		System.out.println(resultPlanComment);
	}
	
	@Test
	@DisplayName("계획 댓글 삭제")
	public void deletePlanCommentTest() {
		//give
		//검색조건 
		PlanSearchCondition planSearchCondition = new PlanSearchCondition();
		planSearchCondition.setCommentId(5L);
		
		List<PlanComment> resultPlanComment= planCommentDao.retrievePlanComment(planSearchCondition);
		System.out.println(resultPlanComment);
		
		//when
		Long resultRow = planCommentDao.deletePlanComment(planSearchCondition);
		
		
		//then		
		System.out.println(resultRow);
		List<PlanComment> afterResultPlanComment= planCommentDao.retrievePlanComment(planSearchCondition);
		System.out.println( afterResultPlanComment);
	}
}
