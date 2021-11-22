package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

@RestController
public class ReportingStructureController {

	private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

	@Autowired
	ReportingStructureService reportingStructureService;	

	//for getting reporting structure 
	@GetMapping("/reportingStructure/{id}")
	public ReportingStructure read(@PathVariable String id) {
		LOG.debug("Request for reporting structure employee id [{}] received", id);

		return reportingStructureService.read(id);

	}



}