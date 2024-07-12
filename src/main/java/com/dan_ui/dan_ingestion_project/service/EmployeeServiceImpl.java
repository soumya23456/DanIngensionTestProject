package com.dan_ui.dan_ingestion_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan_ui.dan_ingestion_project.model.Employee;
import com.dan_ui.dan_ingestion_project.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> employees = employeeRepo.findAll();
		return employees;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeRepo.save(employee);
		return savedEmployee;
	}

	@Override
	public boolean existsByName(String name) {
		boolean exists = employeeRepo.existsByName(name);
		return exists;
	}

	@Override
	public Employee findByName(String name) {
		Employee e = employeeRepo.findByName(name).get();
		return e;
	}

}
