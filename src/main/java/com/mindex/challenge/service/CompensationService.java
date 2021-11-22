package com.mindex.challenge.service;

import java.util.List;

import com.mindex.challenge.data.Compensation;

public interface CompensationService {
	Compensation create(Compensation compensation);
	Compensation read(String id);
	List<Compensation> getAllComp();

}
