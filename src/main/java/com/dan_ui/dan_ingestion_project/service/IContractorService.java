package com.dan_ui.dan_ingestion_project.service;

import java.util.List;

import com.dan_ui.dan_ingestion_project.model.Contractor;

public interface IContractorService {

	public Contractor saveContractor(Contractor contractor);
	public boolean existsByName(String name);
	public Contractor findByName(String name);
	
	public List<Contractor> findAllContractors();
}
