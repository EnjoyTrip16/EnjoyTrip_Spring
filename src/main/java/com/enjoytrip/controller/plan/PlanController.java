package com.enjoytrip.controller.plan;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.enjoytrip.dto.plan.Plan;
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
@RequestMapping("/plans")
public class PlanController {
	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);
	
	private PlanService planService;
	
	private PlanUserBookmarkFavorService planUserBookmarkFavorService;
	
	private PlanRetrieveService planRetrieveService;
	
	
	@Autowired
	public PlanController(PlanService planService, PlanUserBookmarkFavorService planUserBookmarkFavorService,
			PlanRetrieveService planRetrieveService) {
		super();
		this.planService = planService;
		this.planUserBookmarkFavorService = planUserBookmarkFavorService;
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
	
	@GetMapping("/{planId}")
	public ResponseEntity<?> retrievePlanThumbnailByCondition(
			@ModelAttribute PlanThumbnailRequest planThumbnailRequest,
			@PathVariable Long planId
			) {
		try {
			planThumbnailRequest.setPlanId(planId);
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

	@PostMapping
	public ResponseEntity<?> createPlan(@RequestBody Plan plan) {
		try {
			Long planId = planService.createPlan(plan);
			String currentContextUri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
			String resourceUri = currentContextUri + "/plans/"+planId;
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.created(URI.create(resourceUri)).body(planId);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}

	@PatchMapping("/{planId}")
	public ResponseEntity<?> updatePlan(@RequestBody Plan plan,@PathVariable("planId") Long planId) {
		try {
			logger.debug("ㅗ몸");
			plan.setPlanId(planId);
			planService.updataePlan(plan);
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.accepted().build();
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}

	@DeleteMapping("/{planId}")
	public ResponseEntity<?> deletePlan(@PathVariable("planId") Long planId) {
		try {
			Plan plan = new Plan();
			plan.setPlanId(planId);
			planService.deletePlan(plan);
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.accepted().build();
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
}
