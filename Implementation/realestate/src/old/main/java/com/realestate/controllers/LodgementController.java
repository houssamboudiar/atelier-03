package com.realestate.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.models.Lodgement;
import com.realestate.services.AppointementService;
import com.realestate.services.LodgementService;

@RestController
public class LodgementController {

	@Autowired
	private LodgementService lodgementService;
	
	@Autowired
	private AppointementService appointementService;
		
	@PostMapping("/search")
	public List<Lodgement> searchByState(@RequestParam String state, HttpServletRequest request) {	
		return lodgementService.getFreeLodgementByState(state);
	}
	
	@PostMapping("get_reviews")
	public List<String> get_reviews(@RequestParam int id, HttpServletRequest request) {
		System.out.println(appointementService. getAllReviewByAppointementId(id));
		return appointementService. getAllReviewByAppointementId(id);
	}
	
	
}
