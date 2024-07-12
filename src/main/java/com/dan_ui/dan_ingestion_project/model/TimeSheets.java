package com.dan_ui.dan_ingestion_project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TIMESHEETS")
public class TimeSheets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	
	@NotBlank
	private String employeeName;

	@NotNull
	private Integer workedHours;

	@NotBlank
	private String projectName;
	
	
	public TimeSheets() {
		super();
	}


	public TimeSheets(Integer employeeId, @NotBlank String employeeName, @NotNull Integer workedHours,
			@NotBlank String projectName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.workedHours = workedHours;
		this.projectName = projectName;
	}


	public TimeSheets(@NotBlank String employeeName, @NotNull Integer workedHours, @NotBlank String projectName) {
		super();
		this.employeeName = employeeName;
		this.workedHours = workedHours;
		this.projectName = projectName;
	}


	@Override
	public String toString() {
		return "TimeSheets [employeeId=" + employeeId + ", employeeName=" + employeeName + ", workedHours="
				+ workedHours + ", projectName=" + projectName + "]";
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public Integer getWorkedHours() {
		return workedHours;
	}


	public void setWorkedHours(Integer workedHours) {
		this.workedHours = workedHours;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}