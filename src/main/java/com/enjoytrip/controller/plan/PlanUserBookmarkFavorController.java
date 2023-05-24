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
import com.enjoytrip.dto.plan.PlanUserBookmarkFavor;
import com.enjoytrip.dto.plan.request.PlanThumbnailRequest;
import com.enjoytrip.dto.plan.request.PlanTotalRequest;
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
@RequestMapping("/users/{userId}/bookmarks/plans")
public class PlanUserBookmarkFavorController {
	private static final Logger logger = LoggerFactory.getLogger(PlanUserBookmarkFavorController.class);

	
	private PlanUserBookmarkFavorService planUserBookmarkFavorService;
	
	
	@Autowired
	public PlanUserBookmarkFavorController(PlanUserBookmarkFavorService planUserBookmarkFavorService) {
		super();
		this.planUserBookmarkFavorService = planUserBookmarkFavorService;
	}

	@GetMapping
	public ResponseEntity<?> retrievePlanUserBookmark(@PathVariable("userId") Long userId) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setAuthorUserId(userId);
			List<PlanUserBookmarkFavor> planUserBookmarkFavors =
					planUserBookmarkFavorService.retrievePlanUserBookmarkFavor(planTotalRequest);
			return ResponseEntity.ok().body(planUserBookmarkFavors);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}

	@GetMapping("/{planId}")
	public ResponseEntity<?> retrievePlanUserBookmark(@PathVariable("userId") Long userId,
			@PathVariable("planId") Long planId) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setAuthorUserId(userId);
			planTotalRequest.setPlanId(planId);
			List<PlanUserBookmarkFavor> planUserBookmarkFavors =
					planUserBookmarkFavorService.retrievePlanUserBookmarkFavor(planTotalRequest);
			return ResponseEntity.ok().body(planUserBookmarkFavors);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}

	@PostMapping("/{planId}")
	public ResponseEntity<?> createPlanUserBookmark(@PathVariable("userId") Long userId,
			@PathVariable("planId") Long planId,
			@RequestBody PlanUserBookmarkFavor planUserBookmarkFavor) {
		try { 
			planUserBookmarkFavor.setUserId(userId);
			planUserBookmarkFavor.setPlanId(planId);
			planUserBookmarkFavorService
					.createPlanUserBookmarkFavorDao(planUserBookmarkFavor);
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

	@PatchMapping("/{planId}")
	public ResponseEntity<?> updatePlanUserBookmark(@RequestBody PlanUserBookmarkFavor planUserBookmarkFavor,
			@PathVariable("planId") Long planId,
			@PathVariable("userId") Long userId) {
		try {
			planUserBookmarkFavor.setPlanId(planId);
			planUserBookmarkFavor.setUserId(userId);
			planUserBookmarkFavorService.updatePlanUserBookmarkFavor(planUserBookmarkFavor);
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
	
	@DeleteMapping
	public ResponseEntity<?> deletePlanUserBookmark(
			@PathVariable("userId") Long userId) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setAuthorUserId(userId);
			planUserBookmarkFavorService.deletePlanUserBookmarkFavor(planTotalRequest);
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
	public ResponseEntity<?> deletePlanUserBookmark(
			@PathVariable("planId") Long planId,
			@PathVariable("userId") Long userId
			) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			planTotalRequest.setAuthorUserId(userId);
			planUserBookmarkFavorService.deletePlanUserBookmarkFavor(planTotalRequest);
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
