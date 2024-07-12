package com.dan_ui.dan_ingestion_project.service;

import java.util.List;

import com.dan_ui.dan_ingestion_project.model.TimeSheets;

public interface ITimeSheetsService {

	public TimeSheets saveTimeSheets(TimeSheets timesheets);
	public boolean existsByEmployeeName(String employeeName);
	public TimeSheets findByEmployeeName(String employeeName);
	public List<TimeSheets> findAll();
}
