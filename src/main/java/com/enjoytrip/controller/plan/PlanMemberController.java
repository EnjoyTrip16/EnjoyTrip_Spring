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
import com.enjoytrip.dto.plan.PlanMember;
import com.enjoytrip.dto.plan.request.PlanTotalRequest;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;
import com.enjoytrip.service.plan.PlanAttractionService;
import com.enjoytrip.service.plan.PlanMemberService;
import com.enjoytrip.service.plan.PlanService;

@RestController
@RequestMapping("/plans/{planId}/members")
public class PlanMemberController {
	
	private PlanMemberService planMemberService;
	private PlanService planService;
	
	@Autowired
	public PlanMemberController(PlanMemberService planMemberService, PlanService planService) {
		super();
		this.planMemberService = planMemberService;
		this.planService = planService;
	}


	@GetMapping
	public ResponseEntity<?> retrievePlanMember(@PathVariable("planId") Long planId) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			List<PlanMember> planMembers =  
					planMemberService.retrievePlanMember(planTotalRequest);
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.ok().body(planMembers);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}

	
	@GetMapping("/{userId}")
	public ResponseEntity<?> retrievePlanMember(
			@PathVariable("userId") Long memberUserId,
			@PathVariable("planId") Long planId
			) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			planTotalRequest.setMemberUserId(memberUserId);

			List<PlanMember> planMembers =  
					planMemberService.retrievePlanMember(planTotalRequest);
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.ok().body(planMembers);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@PostMapping("/{userId}")
	public ResponseEntity<?> createPlanMember(
			@RequestBody PlanMember planMember,
			@PathVariable("userId") Long userId,
			@PathVariable("planId") Long planId
			) {
		try {
			planMember.setPlanId(planId);
			planMember.setUserId(userId);
			String currentContextUri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
			String resourceUri = currentContextUri + "/plans/"+planId + "/members/"+userId;
			planMemberService.createPlanMember(planMember);
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
	
	@PatchMapping("/{userId}")
	public ResponseEntity<?> updatePlanMember(
			@RequestBody PlanMember planMember,
			@PathVariable("planId") Long planId,
			@PathVariable("userId") Long userId
			) {
		try {
			planMember.setPlanId(planId);
			planMember.setUserId(userId);
		    // 생성된 리소스의 URI 생성
			planMemberService.updatePlanMember(planMember);
			return ResponseEntity.accepted().body(planMember);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deletePlanMember(
			@PathVariable("planId") Long planId
			) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			planMemberService.deletePlanMember(planTotalRequest);
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
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deletePlanAttraction(
			@PathVariable("planId") Long planId,
			@PathVariable("userId") Long memberUserId
			) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			planTotalRequest.setMemberUserId(memberUserId);
			planMemberService.deletePlanMember(planTotalRequest);
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
