package com.dan_ui.dan_ingestion_project.service;

import java.util.List;

import com.dan_ui.dan_ingestion_project.model.SampleFile;

public interface ISampleFileService {

	public SampleFile saveFile(SampleFile file);
	public List<SampleFile> findAllFiles();
}
