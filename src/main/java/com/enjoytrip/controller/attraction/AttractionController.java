package com.enjoytrip.controller.attraction;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionSimpleInfo;
import com.enjoytrip.dto.attraction.Gugun;
import com.enjoytrip.dto.attraction.Sido;
import com.enjoytrip.dto.plan.response.AttractionTotalInfo;
import com.enjoytrip.exception.AttractionException;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.service.attraction.AttractionRetrieveService;
import com.enjoytrip.service.attraction.AttractionService;

import io.swagger.v3.oas.annotations.Operation;

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
	public ResponseEntity<?> retrieveAttractionTotalInfo(@PathVariable("attractionId") Long attractionId,@ModelAttribute 
			AttractionSearchCondition attractionSearchCondition) {
		try {
			attractionSearchCondition.setAttractionId(attractionId);
			System.out.println(attractionSearchCondition);
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

	
	@PostMapping
	public ResponseEntity<?> createAttraction(@RequestBody 
			AttractionTotalInfo attractionTotalInfo) {
		try {
			Long attractionId = attractionService.createAttraction(attractionTotalInfo);
			String currentContextUri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
			String resourceUri = currentContextUri + "/attractions/"+attractionId;
			return ResponseEntity.created(URI.create(resourceUri)).body(attractionId);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@GetMapping("/areas/sido")
	public ResponseEntity<?> retrieveSido(
			) {
		try {
			List<Sido> sidoList = attractionService.retrieveSido();
			return ResponseEntity.ok().body(sidoList);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@GetMapping("/areas/sido/{sidoCode}")
	public ResponseEntity<?> retrieveSido(
			@PathVariable("sidoCode") Long sidoCode
			) {
		try {
			List<Gugun> gugunList = attractionService.retrieveSidoGugun(sidoCode,null);
			return ResponseEntity.ok().body(gugunList);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@GetMapping("/areas/sido/{sidoCode}/gugun/{gugunCode}")
	public ResponseEntity<?> retrieveGugun(
			@PathVariable("sidoCode") Long sidoCode,
			@PathVariable("gugunCode") Long gugunCode
			) {
		try {
			List<Gugun> gugunList = attractionService.retrieveSidoGugun(sidoCode,gugunCode);
			return ResponseEntity.ok().body(gugunList);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
}
