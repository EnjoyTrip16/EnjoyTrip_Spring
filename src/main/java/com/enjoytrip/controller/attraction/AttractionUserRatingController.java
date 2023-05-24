package com.enjoytrip.controller.attraction;

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

import com.enjoytrip.dto.attraction.AttractionUserRating;
import com.enjoytrip.dto.attraction.AttractionUserSearchCondition;
import com.enjoytrip.exception.AttractionException;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.service.attraction.AttractionUserRatingService;

@RestController
@RequestMapping("/users/{userId}/ratings/attractions")
public class AttractionUserRatingController {
	
	AttractionUserRatingService attractionUserRatingService;
	
	
	@Autowired
	public AttractionUserRatingController(
			com.enjoytrip.service.attraction.AttractionUserRatingService attractionUserRatingService) {
		super();
		this.attractionUserRatingService = attractionUserRatingService;
	}

	@GetMapping
	public ResponseEntity<?> retrieveAttractionUserRating(
				@PathVariable("userId") Long userId
			) {
		try {
			AttractionUserSearchCondition attractionUserSearchCondition = new AttractionUserSearchCondition();
			attractionUserSearchCondition.setUserId(userId);
			List<AttractionUserRating> attractionUserRatings = attractionUserRatingService
					.retrieveAttractionUserRating(attractionUserSearchCondition);
			return ResponseEntity.ok().body(attractionUserRatings);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}

	@GetMapping("/{attractionId}")
	public ResponseEntity<?> retrieveAttractionUserRating(
				@PathVariable("userId") Long userId,
				@PathVariable("attractionId") Long attractionId
			) {
		try {
			AttractionUserSearchCondition attractionUserSearchCondition = new AttractionUserSearchCondition();
			attractionUserSearchCondition.setUserId(userId);
			List<Long> attractionIdList = new ArrayList<>();
			attractionIdList.add(attractionId);
			attractionUserSearchCondition.setAttractionIdList(attractionIdList);
			List<AttractionUserRating> attractionUserRatings = attractionUserRatingService
					.retrieveAttractionUserRating(attractionUserSearchCondition);
			return ResponseEntity.ok().body(attractionUserRatings);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@PostMapping("/{attractionId}")
	public ResponseEntity<?> createAttractionUserRating(
			@PathVariable("userId") Long userId,
			@PathVariable("attractionId") Long attractionId,
			@RequestBody AttractionUserRating attractionUserRating
			) {
		try {
			attractionUserRating.setAttractionId(attractionId);
			attractionUserRating.setUserId(userId);
			attractionUserRatingService.createAttractionUserRating(attractionUserRating);
			String currentContextUri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
			String resourceUri = currentContextUri + "/users/"+userId+"/ratings/attractions/"+attractionId;
			return ResponseEntity.created(URI.create(resourceUri)).body(attractionUserRating);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}	
	
	@PatchMapping("/{attractionId}")
	public ResponseEntity<?> updateAttractionUserRating(
			@PathVariable("userId") Long userId,
			@PathVariable("attractionId") Long attractionId,
			@RequestBody AttractionUserRating attractionUserRating
			) {
		try {
			attractionUserRating.setAttractionId(attractionId);
			attractionUserRating.setUserId(userId);
			attractionUserRatingService.updateAttractionUserRating(attractionUserRating);
			return ResponseEntity.accepted().build();
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	@DeleteMapping("/{attractionId}")
	public ResponseEntity<?> deleteAttractionUserRating(
			@PathVariable("userId") Long userId,
			@PathVariable("attractionId") Long attractionId
			) {
		try {
			AttractionUserSearchCondition attractionUserSearchCondition = new AttractionUserSearchCondition();
			List<Long> attractionIdList = new ArrayList<>();
			attractionIdList.add(attractionId);
			attractionUserSearchCondition.setAttractionIdList(attractionIdList);
			attractionUserSearchCondition.setUserId(userId);
			attractionUserRatingService.deleteAttractionUserRating(attractionUserSearchCondition);
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
