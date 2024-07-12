package com.dan_ui.dan_ingestion_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan_ui.dan_ingestion_project.model.TimeSheets;
import com.dan_ui.dan_ingestion_project.repository.TimeSheetsRepository;

@Service
public class TimeSheetsServiceImpl implements ITimeSheetsService{

	@Autowired
	private TimeSheetsRepository timesheetsRepo;

	@Override
	public TimeSheets saveTimeSheets(TimeSheets timesheets) {
		TimeSheets t = timesheetsRepo.save(timesheets);
		return t;
	}

	@Override
	public boolean existsByEmployeeName(String employeeName) {
		boolean exists = timesheetsRepo.existsByEmployeeName(employeeName);
		return exists;
	}

	@Override
	public TimeSheets findByEmployeeName(String employeeName) {
		TimeSheets t = timesheetsRepo.findByEmployeeName(employeeName);
		return t;
	}

	@Override
	public List<TimeSheets> findAll() {
		List<TimeSheets> timesheets = timesheetsRepo.findAll();
		return timesheets;
	}
	
}
