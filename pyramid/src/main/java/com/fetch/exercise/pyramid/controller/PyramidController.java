package com.fetch.exercise.pyramid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fetch.exercise.pyramid.model.Pyramid;
import com.fetch.exercise.pyramid.service.PyramidService;

@RestController
public class PyramidController {
	
	@Autowired
	PyramidService pyramidService;

	@CrossOrigin("*")
	@GetMapping(value = "/pyramid/{pyramid}", produces="application/json")
	public ResponseEntity<Pyramid> isPyramid(@PathVariable String pyramid) {
		Pyramid p = pyramidService.isPyramid(pyramid);
		if(p.getString() == null) {
			return new ResponseEntity<Pyramid>(p, HttpStatus.LENGTH_REQUIRED);
		}else {
			return new ResponseEntity<Pyramid>(p, HttpStatus.OK);
		}
	}
	
}
