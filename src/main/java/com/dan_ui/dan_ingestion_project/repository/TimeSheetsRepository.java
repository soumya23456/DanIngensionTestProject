package com.dan_ui.dan_ingestion_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dan_ui.dan_ingestion_project.model.TimeSheets;

@Repository
public interface TimeSheetsRepository extends JpaRepository<TimeSheets, Integer> {

	TimeSheets findByEmployeeName(String employeeName);
	List<TimeSheets> findAll();
	boolean existsByEmployeeName(String employeeName);
}
