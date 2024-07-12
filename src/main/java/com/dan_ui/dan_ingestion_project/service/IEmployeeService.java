package com.dan_ui.dan_ingestion_project.service;

import java.util.List;

import com.dan_ui.dan_ingestion_project.model.Employee;

public interface IEmployeeService {

	public Employee saveEmployee(Employee employee);
	public List<Employee> findAllEmployees();
	public boolean existsByName(String name);
	public Employee findByName(String name);
}
