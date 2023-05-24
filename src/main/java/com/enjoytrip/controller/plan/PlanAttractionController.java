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
import com.enjoytrip.dto.plan.request.PlanTotalRequest;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;
import com.enjoytrip.service.plan.PlanAttractionService;
import com.enjoytrip.service.plan.PlanService;

@RestController
@RequestMapping("/plans/{planId}/attractions")
public class PlanAttractionController {
	
	private PlanAttractionService planAttractionService;
	private PlanService planService;
	
	@Autowired
	public PlanAttractionController(PlanAttractionService planAttractionService, PlanService planService) {
		super();
		this.planAttractionService = planAttractionService;
		this.planService = planService;
	}
	
	@GetMapping
	public ResponseEntity<?> retrievePlanAttraction(@PathVariable("planId") Long planId) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			List<PlanAttraction> planAttractions =  
					planAttractionService.retrievePlanAttraction(planTotalRequest);
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.ok().body(planAttractions);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}

	
	@GetMapping("/{attractionId}")
	public ResponseEntity<?> retrievePlanAttraction(
			@PathVariable("attractionId") Long attractionId,
			@PathVariable("planId") Long planId
			) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			
			List<Long> attractionIdList = new ArrayList<Long>();
			attractionIdList.add(attractionId);
			planTotalRequest.setAttractionIdList(attractionIdList);
			
			List<PlanAttraction> planAttractions =  
					planAttractionService.retrievePlanAttraction(planTotalRequest);
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.ok().body(planAttractions);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@PostMapping("/{attractionId}")
	public ResponseEntity<?> createPlanAttraction(
			@RequestBody PlanAttraction planAttraction,
			@PathVariable("planId") Long planId,
			@PathVariable("attractionId") Long attractionId
			) {
		try {
			planAttraction.setPlanId(planId);
			planAttraction.setAttractionId(attractionId);
			String currentContextUri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
			String resourceUri = currentContextUri + "/plans/"+planId + "/attractions/"+attractionId;
			planAttractionService.createPlanAttraction(planAttraction);
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
	
	@PatchMapping("/{attractionId}")
	public ResponseEntity<?> updatePlanAttraction(
			@RequestBody PlanAttraction planAttraction,
			@PathVariable("planId") Long planId,
			@PathVariable("attractionId") Long attractionId
			) {
		try {
			planAttraction.setPlanId(planId);
			planAttraction.setAttractionId(attractionId);
			planAttractionService.updatePlanAttraction(planAttraction);
		    // 생성된 리소스의 URI 생성
			return ResponseEntity.accepted().body(planAttraction);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(PlanException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deletePlanAttraction(
			@PathVariable("planId") Long planId
			) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			planAttractionService.deletePlanAttraction(planTotalRequest);
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
	
	@DeleteMapping("/{attractionId}")
	public ResponseEntity<?> deletePlanAttraction(
			@PathVariable("planId") Long planId,
			@PathVariable("attractionId") Long attractionId
			) {
		try {
			PlanTotalRequest planTotalRequest = new PlanTotalRequest();
			planTotalRequest.setPlanId(planId);
			List<Long> attractionIdList = new ArrayList<Long>();
			attractionIdList.add(attractionId);
			planTotalRequest.setAttractionIdList(attractionIdList);
			planAttractionService.deletePlanAttraction(planTotalRequest);
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
