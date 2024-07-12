package com.dan_ui.dan_ingestion_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan_ui.dan_ingestion_project.model.Contractor;
import com.dan_ui.dan_ingestion_project.repository.ContractorRepository;

@Service
public class ContractorServiceImpl implements IContractorService {

	@Autowired
	private ContractorRepository contractorRepo;
	
	@Override
	public boolean existsByName(String name) {
		boolean isName = contractorRepo.existsByName(name);
		return isName;
	}

	@Override
	public Contractor findByName(String name) {
		Optional<Contractor> contractor = contractorRepo.findByName(name);
		return contractor.get();
	}

	@Override
	public List<Contractor> findAllContractors() {
		List<Contractor> contractors = contractorRepo.findAll();
		return contractors;
	}

	@Override
	public Contractor saveContractor(Contractor contractor) {
		Contractor savedContractor = contractorRepo.save(contractor);
		return savedContractor;
	}

}
