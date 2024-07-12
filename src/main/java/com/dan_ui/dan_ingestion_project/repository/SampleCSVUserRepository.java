package com.dan_ui.dan_ingestion_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dan_ui.dan_ingestion_project.model.SampleCSVUser;

@Repository
public interface SampleCSVUserRepository extends JpaRepository<SampleCSVUser, Integer> {

}
