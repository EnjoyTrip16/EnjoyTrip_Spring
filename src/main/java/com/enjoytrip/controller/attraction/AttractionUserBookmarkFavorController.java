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

import com.enjoytrip.dto.attraction.AttractionSearchCondition;
import com.enjoytrip.dto.attraction.AttractionSimpleInfo;
import com.enjoytrip.dto.attraction.AttractionUserBookmarkFavor;
import com.enjoytrip.dto.attraction.AttractionUserSearchCondition;
import com.enjoytrip.dto.plan.response.AttractionTotalInfo;
import com.enjoytrip.exception.AttractionException;
import com.enjoytrip.exception.BadParameterException;
import com.enjoytrip.service.attraction.AttractionRetrieveService;
import com.enjoytrip.service.attraction.AttractionService;
import com.enjoytrip.service.attraction.AttractionUserBookmarkFavorService;

@RestController
@RequestMapping("/users/{userId}/bookmarks/attractions")
public class AttractionUserBookmarkFavorController {
	
	AttractionUserBookmarkFavorService attractionUserBookmarkFavorService;
	
	
	@Autowired
	public AttractionUserBookmarkFavorController(
			com.enjoytrip.service.attraction.AttractionUserBookmarkFavorService attractionUserBookmarkFavorService) {
		super();
		this.attractionUserBookmarkFavorService = attractionUserBookmarkFavorService;
	}

	@GetMapping
	public ResponseEntity<?> retrieveAttractionUserBookmarkFavor(
				@PathVariable("userId") Long userId
			) {
		try {
			AttractionUserSearchCondition attractionUserSearchCondition = new AttractionUserSearchCondition();
			attractionUserSearchCondition.setUserId(userId);
			List<AttractionUserBookmarkFavor> attractionUserBookmarkFavors = attractionUserBookmarkFavorService
					.retrieveAttractionUserBookmarkFavor(attractionUserSearchCondition);
			return ResponseEntity.ok().body(attractionUserBookmarkFavors);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}

	@GetMapping("/{attractionId}")
	public ResponseEntity<?> retrieveAttractionUserBookmarkFavor(
				@PathVariable("userId") Long userId,
				@PathVariable("attractionId") Long attractionId
			) {
		try {
			AttractionUserSearchCondition attractionUserSearchCondition = new AttractionUserSearchCondition();
			attractionUserSearchCondition.setUserId(userId);
			List<Long> attractionIdList = new ArrayList<>();
			attractionIdList.add(attractionId);
			attractionUserSearchCondition.setAttractionIdList(attractionIdList);
			List<AttractionUserBookmarkFavor> attractionUserBookmarkFavors = attractionUserBookmarkFavorService
					.retrieveAttractionUserBookmarkFavor(attractionUserSearchCondition);
			return ResponseEntity.ok().body(attractionUserBookmarkFavors);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}
	
	@PostMapping("/{attractionId}")
	public ResponseEntity<?> createAttractionUserBookmarkFavor(
			@PathVariable("userId") Long userId,
			@PathVariable("attractionId") Long attractionId,
			@RequestBody AttractionUserBookmarkFavor attractionUserBookmarkFavor
			) {
		try {
			attractionUserBookmarkFavor.setAttractionId(attractionId);
			attractionUserBookmarkFavor.setUserId(userId);
			attractionUserBookmarkFavorService.createAttractionUserBookmarkFavorDao(attractionUserBookmarkFavor);
			String currentContextUri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
			String resourceUri = currentContextUri + "/users/"+userId+"/bookmarks/attractions/"+attractionId;
			return ResponseEntity.created(URI.create(resourceUri)).body(attractionUserBookmarkFavor);
		}
		catch(BadParameterException be) {
			return ResponseEntity.badRequest().body(be.getMessage());
		}
		catch(AttractionException pe) {
			return ResponseEntity.internalServerError().body(pe.getMessage());
		}
	}	
	@DeleteMapping("/{attractionId}")
	public ResponseEntity<?> deleteAttractionUserBookmarkFavor(
			@PathVariable("userId") Long userId,
			@PathVariable("attractionId") Long attractionId
			) {
		try {
			AttractionUserSearchCondition attractionUserSearchCondition = new AttractionUserSearchCondition();
			List<Long> attractionIdList = new ArrayList<>();
			attractionIdList.add(attractionId);
			attractionUserSearchCondition.setAttractionIdList(attractionIdList);
			attractionUserSearchCondition.setUserId(userId);
			attractionUserBookmarkFavorService.deleteAttractionUserBookmarkFavor(attractionUserSearchCondition);
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
