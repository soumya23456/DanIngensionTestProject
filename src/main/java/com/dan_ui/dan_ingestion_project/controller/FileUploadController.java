package com.dan_ui.dan_ingestion_project.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dan_ui.dan_ingestion_project.csvdataservice.CsvDataService;
import com.dan_ui.dan_ingestion_project.exception.StorageFileNotFoundException;
import com.dan_ui.dan_ingestion_project.fileservice.StorageService;
import com.dan_ui.dan_ingestion_project.service.SampleFileServiceImpl;

@Controller
public class FileUploadController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	private final StorageService storageService;

	public FileUploadController(StorageService storageService) {
		super();
		this.storageService = storageService;
	}

	@Autowired
	private SampleFileServiceImpl filedbservice;

	@Autowired
	private CsvDataService csvdataService;
	
	@GetMapping("/home/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
	
	@PostMapping("/home/user/fileUpload")
	public String uploadFile(
			@RequestParam("multifile") MultipartFile[] multifiles, 
			@RequestParam(value="filetype", required = false) Collection<String> filetypes,
			RedirectAttributes redirectAttributes) {
		if(multifiles == null || filetypes == null) {
			redirectAttributes.addFlashAttribute("errormessage",
					"No Files uploaded!");
			return "redirect:/home/user/admin-dashboard";
		}
		boolean valid = filedbservice.validFiletypes(multifiles, filetypes);
		if(valid) {
			Arrays.asList(multifiles).stream().forEach(file -> {
				storageService.saveFile(file);
				boolean hasCSVFormat = CsvDataService.hasCSVFormat(file);
				logger.info("has CSV Format :: "+ hasCSVFormat);
				if(hasCSVFormat) {
					try {
						csvdataService.saveCSVData(file.getInputStream());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				});
			redirectAttributes.addFlashAttribute("message", "You successfully uploaded al files!");
			return "redirect:/home/user/admin-dashboard";			
		}
		redirectAttributes.addFlashAttribute("errormessage", "Not selected correct filetypes!");
		return "redirect:/home/user/admin-dashboard";					
	}
	
	  @GetMapping("/home/users/exportEmployeesDatatoCSV")
	    public void exportEmployeesToCSV(HttpServletResponse response) throws IOException {
		  	response.setContentType("text/csv");
	        response.addHeader("Content-Disposition","attachment; filename=\"employees.csv\"");
	        csvdataService.writeEmployeesToCsv(response.getWriter());
	         
	    }
	  
	  @GetMapping("/home/users/exportContractorsDatatoCSV")
	    public void exportContractorsToCSV(HttpServletResponse response) throws IOException {
		  	response.setContentType("text/csv");
	        response.addHeader("Content-Disposition","attachment; filename=\"contractors.csv\"");
	        csvdataService.writeContractorsToCsv(response.getWriter());
	         
	    }
	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}
}
