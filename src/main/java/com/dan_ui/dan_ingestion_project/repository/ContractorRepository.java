package com.dan_ui.dan_ingestion_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dan_ui.dan_ingestion_project.model.Contractor;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Integer> {

	boolean existsByName(String name);
	boolean existsById(Integer id);
	
	Optional<Contractor> findById(Integer id);
	Optional<Contractor> findByName(String name);
}
