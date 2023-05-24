package com.enjoytrip.controller.attraction;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionSimpleInfo;
import com.enjoytrip.dto.plan.response.AttractionTotalInfo;
import com.enjoytrip.dto.plan.response.PlanThumbnail;
import com.enjoytrip.exception.AttractionException;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.exception.PlanException;
import com.enjoytrip.service.attraction.AttractionRetrieveService;
import com.enjoytrip.service.attraction.AttractionService;

@RestController
@RequestMapping("/attractions")
public class AttractionController {
	
	AttractionRetrieveService attractionRetrieveService;
	AttractionService attractionService;
	
	public AttractionController(AttractionRetrieveService attractionRetrieveService,
			AttractionService attractionService) {
		super();
		this.attractionRetrieveService = attractionRetrieveService;
		this.attractionService = attractionService;
	}
	
	@GetMapping
	public ResponseEntity<?> retrieveAttractionSimpleInfo(@ModelAttribute 
			AttractionSearchCondition attractionSearchCondition) {
		try {
			List<AttractionSimpleInfo> attractionSimpleInfos = attractionRetrieveService
					.retrieveSimpleInfo(attractionSearchCondition);
			return ResponseEntity.ok().body(attractionSimpleInfos);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@GetMapping("/{attractionId}")
	public ResponseEntity<?> retrieveAttractionTotalInfo(@ModelAttribute 
			AttractionSearchCondition attractionSearchCondition) {
		try {
			AttractionTotalInfo attractionTotalInfo = attractionRetrieveService
					.retrieveTotalInfo(attractionSearchCondition);
			return ResponseEntity.ok().body(attractionTotalInfo);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
}
