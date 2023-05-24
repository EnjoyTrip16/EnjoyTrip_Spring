package com.enjoytrip.controller.plan;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.enjoytrip.dto.plan.request.PlanTotalRequest;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;
import com.enjoytrip.service.plan.PlanMemoService;
import com.enjoytrip.service.plan.PlanService;

@RestController
@RequestMapping("/plans/{planId}/memos")
public class PlanMemoController {
	
	private PlanMemoService planMemoService;
	private PlanService planService;
	
	@Autowired
	public PlanMemoController(PlanMemoService planMemoService, PlanService planService) {
		super();
		this.planMemoService = planMemoService;
		this.planService = planService;
	}


	@GetMapping
	public ResponseEntity<?> retrievePlanMemo(@PathVariable("planId") Long planId) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			List<PlanMemo> planMemos =  
					planMemoService.retrievePlanMemo(planTotalRequest);
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.ok().body(planMemos);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}

	
	@GetMapping("/{memoId}")
	public ResponseEntity<?> retrievePlanMemo(
			@PathVariable("memoId") Long memoId,
			@PathVariable("planId") Long planId
			) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			planTotalRequest.setPlanMemoId(memoId);

			List<PlanMemo> planMemos =  
					planMemoService.retrievePlanMemo(planTotalRequest);
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.ok().body(planMemos);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> createPlanMemo(
			@RequestBody PlanMemo planMemo,
			@PathVariable("planId") Long planId
			) {
		try {
			planMemo.setPlanId(planId);
			Long memoId = planMemoService.createPlanMemo(planMemo);
			String currentContextUri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
			String resourceUri = currentContextUri + "/plans/"+planId + "/memos/"+memoId;
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
	
	@PatchMapping("/{memoId}")
	public ResponseEntity<?> updatePlanMemo(
			@RequestBody PlanMemo planMemo,
			@PathVariable("planId") Long planId,
			@PathVariable("memoId") Long planMemoId
			) {
		try {
			planMemo.setPlanId(planId);
			planMemo.setPlanMemoId(planMemoId);
		    // 생성된 리소스의 URI 생성
			planMemoService.updatePlanMemo(planMemo);
			return ResponseEntity.accepted().body(planMemo);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deletePlanMemo(
			@PathVariable("planId") Long planId
			) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			planMemoService.deletePlanMemo(planTotalRequest);
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
	
	@DeleteMapping("/{memoId}")
	public ResponseEntity<?> deletePlanAttraction(
			@PathVariable("planId") Long planId,
			@PathVariable("memoId") Long memoId
			) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			planTotalRequest.setPlanMemoId(memoId);
			planMemoService.deletePlanMemo(planTotalRequest);
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
