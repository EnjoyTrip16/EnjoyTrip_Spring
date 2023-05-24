package com.enjoytrip.controller.plan;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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
import com.enjoytrip.dto.plan.PlanAttraction;
import com.enjoytrip.dto.plan.PlanMemo;
import com.enjoytrip.dto.plan.PlanMemoTag;
import com.enjoytrip.dto.plan.request.PlanTotalRequest;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;
import com.enjoytrip.service.plan.PlanMemoService;
import com.enjoytrip.service.plan.PlanMemoTagService;
import com.enjoytrip.service.plan.PlanService;

@RestController
@RequestMapping("/plans/memos/tags")
public class PlanMemoTagController {
	
	private PlanMemoTagService planMemoTagService;
	private PlanService planService;

	@Autowired
	public PlanMemoTagController(PlanMemoTagService planMemoTagService, PlanService planService) {
		super();
		this.planMemoTagService = planMemoTagService;
		this.planService = planService;
	}

	//tagName으로 태그명검색지원
	@GetMapping
	public ResponseEntity<?> retrievePlanMemoTag(@ModelAttribute PlanTotalRequest planTotalRequest) {
		try {
			List<PlanMemoTag> planMemoTags =  
					planMemoTagService.retrievePlanMemoTag(planTotalRequest);
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.ok().body(planMemoTags);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}

	
	@GetMapping("/{tagId}")
	public ResponseEntity<?> retrievePlanMemo(
			@PathVariable("tagId") Long tagId
			) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setTagId(tagId);

			List<PlanMemoTag> planMemoTags =  
					planMemoTagService.retrievePlanMemoTag(planTotalRequest);
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.ok().body(planMemoTags);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> createPlanMemoTag(@RequestBody PlanMemoTag planMemoTag) {
		try {
			Long tagId = planMemoTagService.createPlanMemoTag(planMemoTag);
			String currentContextUri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
			String resourceUri = currentContextUri + "/plans/memos/tags/"+tagId;
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.created(URI.create(resourceUri)).build();
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}	
	
	@PatchMapping("/{tagId}")
	public ResponseEntity<?> updatePlanMemo(
			@RequestBody PlanMemoTag planMemoTag,
			@PathVariable("tagId") Long tagId
			) {
		try {
			planMemoTag.setTagId(tagId);
		    // 생성된 리소스의 URI 생성
			planMemoTagService.updatePlanMemoTag(planMemoTag);
			return ResponseEntity.accepted().body(planMemoTag);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	@DeleteMapping("/{tagId}")
	public ResponseEntity<?> deletePlanAttraction(
			@PathVariable("tagId") Long tagId
			) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setTagId(tagId);
			planMemoTagService.deletePlanMemoTag(planTotalRequest);
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
