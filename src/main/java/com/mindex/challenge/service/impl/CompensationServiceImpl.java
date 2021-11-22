package com.mindex.challenge.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;

@Service
public class CompensationServiceImpl implements CompensationService {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private CompensationRepository compensationRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//add the compensation  
	@Override
	public Compensation create(Compensation compensation) {

		LOG.debug("Creating Compensation [{}]", compensation);
		compensationRepository.insert(compensation);
		return compensation;
	}

	//read the compensation
	@Override
	public Compensation read(String id) {

		LOG.debug("Reading employee with id [{}]", id);
		
		Employee employee = employeeRepository.findByEmployeeId(id);
		
		if(employee == null) {
			 throw new RuntimeException("Invalid employeeId: " + id);
		}
		
		Compensation compensation = compensationRepository.findByEmployee(employee);
		if(compensation == null) {
			throw new RuntimeException("No compensation found for employee with id" + id);
		}
		
		return compensation;
	}

	@Override
	public List<Compensation> getAllComp() {
		return compensationRepository.findAll();
	}

}
