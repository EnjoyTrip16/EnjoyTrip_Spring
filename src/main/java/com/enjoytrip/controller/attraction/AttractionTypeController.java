package com.enjoytrip.controller.attraction;

import java.net.URI;
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

import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionType;
import com.enjoytrip.exception.AttractionException;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.service.attraction.AttractionService;
import com.enjoytrip.service.attraction.AttractionTypeService;

@RestController
@RequestMapping("/attractions/types")
public class AttractionTypeController {

	private AttractionTypeService attractionTypeService;

	private AttractionService attractionService;

	@Autowired
	public AttractionTypeController(AttractionTypeService attractionTypeService, AttractionService attractionService) {
		super();
		this.attractionTypeService = attractionTypeService;
		this.attractionService = attractionService;
	}
	
	@GetMapping
	public ResponseEntity<?> retrieveAttractionType(
			@ModelAttribute AttractionSearchCondition attractionSearchCondition
	) {
		try {
			List<AttractionType> attractionTypes= attractionTypeService.
					retrieveAttractionType(attractionSearchCondition);
			return ResponseEntity.ok().body(attractionTypes);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
		
	}
	
	@GetMapping("/{attractionTypeId}")
	public ResponseEntity<?> retrieveAttractionType(
			@PathVariable("attractionTypeId") Long attractionTypeId
	) {
		AttractionSearchCondition attractionSearchCondition  = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionTypeId(attractionTypeId);
		try {
			List<AttractionType> attractionTypes= attractionTypeService.
					retrieveAttractionType(attractionSearchCondition);
			return ResponseEntity.ok().body(attractionTypes);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
		
	}
	
	@PostMapping
	public ResponseEntity<?> createAttractionType(
			@RequestBody AttractionType attractionType
	) {
		try {
			Long attractionTypeId = attractionTypeService.createAttractionType(attractionType);
			String currentContextUri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
			String resourceUri = currentContextUri + "/attractions/types/"+attractionTypeId;
			return ResponseEntity.created(URI.create(resourceUri)).body(attractionTypeId);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
		
	}
	
	@PatchMapping("/{attractionTypeId}")
	public ResponseEntity<?> updateAttractionType(
			@RequestBody AttractionType attractionType,
			@PathVariable Long attractionTypeId
	) {
		try {
			attractionType.setAttractionTypeId(attractionTypeId);
			attractionTypeService.updateAttractionType(attractionType);
			return ResponseEntity.accepted().build();
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
		
	}
	
	@DeleteMapping("/{attractionTypeId}")
	public ResponseEntity<?> deleteAttractionType(
			@PathVariable("attractionTypeId") Long attractionTypeId
	) {
		AttractionSearchCondition attractionSearchCondition  = new AttractionSearchCondition();
		attractionSearchCondition.setAttractionTypeId(attractionTypeId);
		attractionTypeService.deleteAttractionType(attractionSearchCondition);
		try {
			return ResponseEntity.accepted().build();
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
		
	}
	
	
}
