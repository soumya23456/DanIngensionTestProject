package com.dan_ui.dan_ingestion_project.csvdataservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dan_ui.dan_ingestion_project.model.Contractor;
import com.dan_ui.dan_ingestion_project.model.Employee;
import com.dan_ui.dan_ingestion_project.model.TimeSheets;
import com.dan_ui.dan_ingestion_project.service.ContractorServiceImpl;
import com.dan_ui.dan_ingestion_project.service.EmployeeServiceImpl;
import com.dan_ui.dan_ingestion_project.service.TimeSheetsServiceImpl;

@Service
public class CsvDataService {

	@Autowired
	private ContractorServiceImpl contractorservice;
	
	@Autowired
	private EmployeeServiceImpl employeeservice;

	@Autowired
	private TimeSheetsServiceImpl tsService;
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public static boolean hasCSVFormat(MultipartFile file) {
		if(!file.getContentType().equals("text/csv")) {
			return false;
		}
		return true;
	}
	
	public void saveCSVData(InputStream is) {
		 try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			        CSVParser csvParser = new CSVParser(fileReader,
			            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
					LocalDateTime date = LocalDateTime.now();  
					List<String> headers = csvParser.getHeaderNames();
					logger.info("headers in csv FIle :: "+ headers.toString());
					String[] req_headers = {"name","phone","email","address","postalZip","region","country"};
					logger.info("Required Headers :: "+ req_headers.toString());
			      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			      for (CSVRecord csvRecord : csvRecords) {
			    	  String name = csvRecord.get("name");
			    	  String phone = csvRecord.get("phone");
			    	  String email = csvRecord.get("email");
			    	  String address = csvRecord.get("address");
			    	  String postalZip = csvRecord.get("postalZip");
			    	  String region = csvRecord.get("region");
			    	  String country = csvRecord.get("country");
			    	  
			    	  boolean employeeExists = employeeservice.existsByName(name);
			    	  boolean contractorExists = contractorservice.existsByName(name);
			    	  boolean timesheetExists = tsService.existsByEmployeeName(name);
			    	  if(employeeExists) {
			    		  Employee e = employeeservice.findByName(name);
			    		  e.setPhone(phone);
			    		  e.setEmail(email);
			    		  e.setAddress(address);
			    		  e.setPostalZip(postalZip);
			    		  e.setRegion(region);
			    		  e.setCountry(country);
			    		  e.setUpdatedAt(date.toString());
			    		employeeservice.saveEmployee(e);
			    	  }
			    	  else {
			    		  Employee newEmployee = new Employee(name,phone,email,address,postalZip,region,country,date.toString(),date.toString());
			    		  employeeservice.saveEmployee(newEmployee);
			    	  }
			    	  if(contractorExists) {
			    		  Contractor c = contractorservice.findByName(name);
			    		  c.setPhone(phone);
			    		  c.setEmail(email);
			    		  c.setAddress(address);
			    		  c.setPostalZip(postalZip);
			    		  c.setRegion(region);
			    		  c.setCountry(country);
			    		  c.setUpdatedAt(date.toString());
			    		  contractorservice.saveContractor(c);
			    	  }else {
			    		  Contractor contractor = new Contractor(name,phone,email,address,postalZip,region,country,date.toString(),date.toString());
			    		  contractorservice.saveContractor(contractor);
			    	  }
			    	  if(timesheetExists) {
			    		  TimeSheets t = tsService.findByEmployeeName(name);
			    		  t.setProjectName("update project");
			    		  t.setWorkedHours(9);
			    		  tsService.saveTimeSheets(t);
			    	  }else {
			    		  TimeSheets timesheet = new TimeSheets(name,8,"project");
			    		  tsService.saveTimeSheets(timesheet);
			    	  }
			      }
			    } catch (IOException e) {
			      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
			    }
	}
	
	 public void writeEmployeesToCsv(Writer writer) {

	        List<Employee> employees = employeeservice.findAllEmployees();
	        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
	            csvPrinter.printRecord("employeeId","employeeName","phone","email","address","postalZip","region","country","createdAt","updatedAt");
	        	for (Employee e : employees) {
	                csvPrinter.printRecord(e.getId(),e.getName(),e.getPhone(),e.getEmail(),e.getAddress(),e.getPostalZip(),e.getRegion(),e.getCountry(),e.getCreatedAt(),e.getUpdatedAt());
	            }
	        } catch (IOException e) {
	            logger.error("Error While writing CSV ", e);
	        }
	    }
	 
	 public void writeContractorsToCsv(Writer writer) {

	        List<Contractor> contractors = contractorservice.findAllContractors();
	        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
	            csvPrinter.printRecord("contractorId","contractorName","phone","email","address","postalZip","region","country","createdAt","updatedAt");
	        	for (Contractor e : contractors) {
	                csvPrinter.printRecord(e.getId(),e.getName(),e.getPhone(),e.getEmail(),e.getAddress(),e.getPostalZip(),e.getRegion(),e.getCountry(),e.getCreatedAt(),e.getUpdatedAt());
	            }
	        } catch (IOException e) {
	            logger.error("Error While writing CSV ", e);
	        }
	    }
}
