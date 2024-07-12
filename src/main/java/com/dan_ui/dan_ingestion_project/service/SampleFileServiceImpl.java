package com.dan_ui.dan_ingestion_project.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dan_ui.dan_ingestion_project.model.SampleFile;
import com.dan_ui.dan_ingestion_project.repository.FileRepository;

@Service
public class SampleFileServiceImpl implements ISampleFileService {

	@Autowired
	private FileRepository fileRepo;
	
	@Override
	public List<SampleFile> findAllFiles() {
		List<SampleFile> files = fileRepo.findAll();
		return files;
	}

	@Override
	public SampleFile saveFile(SampleFile file) {
		SampleFile savedFile = fileRepo.save(file);
		return savedFile;
	}

	public boolean validFiletypes(MultipartFile[] uploadedfiles, Collection<String> selectedfiletypes) {
		boolean valid = false;
		List<String> uploadedFiletypes = new ArrayList<>();
		List<String> filetypes = new ArrayList<>();
		List<String> types = new ArrayList<>();

		for (String filetype : selectedfiletypes) {
			filetypes.add(filetype);
		}

		for (MultipartFile file : uploadedfiles) {
			String mimetype = file.getContentType();
			uploadedFiletypes.add(mimetype);
		}
		for (String type : uploadedFiletypes) {
			if (!types.contains(type) && type != null) {
				types.add(type);
			}						
		}
		Collections.sort(types);
		Collections.sort(filetypes);
		
		valid = filetypes.containsAll(types);
		return valid;
	}
}
