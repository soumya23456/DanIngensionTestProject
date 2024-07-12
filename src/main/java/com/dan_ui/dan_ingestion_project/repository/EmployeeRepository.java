package com.dan_ui.dan_ingestion_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dan_ui.dan_ingestion_project.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	boolean existsByName(String name);
	boolean existsById(Integer id);
	
	Optional<Employee> findById(Integer id);
	Optional<Employee> findByName(String name);
}
