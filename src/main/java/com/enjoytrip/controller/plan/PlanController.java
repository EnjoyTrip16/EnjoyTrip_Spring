package com.enjoytrip.controller.plan;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoytrip.dto.plan.PlanComment;
import com.enjoytrip.dto.plan.PlanSearchCondition;
import com.enjoytrip.dto.plan.request.PlanThumbnailRequest;
import com.enjoytrip.dto.plan.response.PlanThumbnail;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;
import com.enjoytrip.service.plan.PlanCommentService;
import com.enjoytrip.service.plan.PlanMemberService;
import com.enjoytrip.service.plan.PlanMemoService;
import com.enjoytrip.service.plan.PlanMemoTagService;
import com.enjoytrip.service.plan.PlanRetrieveService;
import com.enjoytrip.service.plan.PlanService;
import com.enjoytrip.service.plan.PlanUserBookmarkFavorService;

@RestController
@RequestMapping("/plan")
public class PlanController {
	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);
	
	private PlanService planService;
	
	private PlanUserBookmarkFavorService planUserBookmarkFavorService;
	
	private PlanMemberService planMemberService;
	
	private PlanMemoService planMemoService;
	
	private PlanMemoTagService planMemoTagService;
	
	private PlanCommentService planCommentService;
	
	private PlanRetrieveService planRetrieveService;
	
	@Autowired
	public PlanController(PlanService planService, PlanUserBookmarkFavorService planUserBookmarkFavorService,
			PlanMemberService planMemberService, PlanMemoService planMemoService, PlanMemoTagService planMemoTagService,
			PlanCommentService planCommentService, PlanRetrieveService planRetrieveService) {
		super();
		this.planService = planService;
		this.planUserBookmarkFavorService = planUserBookmarkFavorService;
		this.planMemberService = planMemberService;
		this.planMemoService = planMemoService;
		this.planMemoTagService = planMemoTagService;
		this.planCommentService = planCommentService;
		this.planRetrieveService = planRetrieveService;
	}

	@GetMapping
	public ResponseEntity<?> retrievePlanThumbnailByCondition(@ModelAttribute PlanThumbnailRequest planThumbnailRequest) {
		try {
			List<PlanThumbnail> planThumbnails = planRetrieveService.getPlanThumbnail(planThumbnailRequest);
			return ResponseEntity.ok().body(planThumbnails);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
}
