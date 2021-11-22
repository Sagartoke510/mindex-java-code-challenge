package com.mindex.challenge.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.controller.ReportingStructureController;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

	private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);


	@Autowired
	private EmployeeRepository employeeRepository;

	
	@Override
	public ReportingStructure read(String id) {
		LOG.debug("ReportingStructure for employeeId [{}]", id);

		Employee employee = employeeRepository.findByEmployeeId(id);
		if(employee == null) {
			throw new RuntimeException("Invalid EmployeeId: " +id);
		}
		ReportingStructure reportingStructure = new ReportingStructure(employee);

		int reportsCount=0;
		
		List<Employee> directReportlist = employee.getDirectReports();
		reportsCount = directReportlist.size();
		
		for(Employee curr : directReportlist) {
			List<Employee> currEmpReports = curr.getDirectReports();
			if(currEmpReports != null) {
				reportsCount +=  curr.getDirectReports().size();
			}
		}
		reportingStructure.setNumberOfReports(reportsCount);

		return reportingStructure ;
	}

}
