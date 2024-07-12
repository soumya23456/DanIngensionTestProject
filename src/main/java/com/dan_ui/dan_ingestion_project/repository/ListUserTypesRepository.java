package com.dan_ui.dan_ingestion_project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dan_ui.dan_ingestion_project.model.Usersdto;

@Repository
public interface ListUserTypesRepository extends CrudRepository<Usersdto, Integer> {	
}
