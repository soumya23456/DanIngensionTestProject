package com.dan_ui.dan_ingestion_project.fileservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dan_ui.dan_ingestion_project.exception.FileStorageException;
import com.dan_ui.dan_ingestion_project.exception.StorageFileNotFoundException;
import com.dan_ui.dan_ingestion_project.model.SampleFile;
import com.dan_ui.dan_ingestion_project.service.SampleFileServiceImpl;

@Service
public class FileStorageServiceImpl implements StorageService {
	
	private final Path rootLocation;
	
	@Autowired
	private SampleFileServiceImpl filedbservice;
	
	@Autowired
	public FileStorageServiceImpl(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);
		}
		catch (IOException e) {
			throw new FileStorageException("Could not initialize storage", e);
		}
	}


	@Override
	public void saveFile(MultipartFile file) {		
		try {
			if (file.isEmpty()) {
				throw new FileStorageException("Failed to store empty file.");
			}
			LocalDateTime date = LocalDateTime.now();
			LocalDateTime req_date = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(),
					date.getHour(), date.getMinute());
			String mimetype = file.getContentType();
			Float filesize = (float) (file.getSize() / 1024);
			UUID uuid = UUID.randomUUID();
			String randomid = uuid.toString();
			String filename = randomid.concat(file.getOriginalFilename().trim());
			Path destinationFile = this.rootLocation.resolve(
					Paths.get(filename))
					.normalize().toAbsolutePath();
			SampleFile newFile = new SampleFile(filename, "paul harry", "ADMIN", mimetype, req_date.toString(), filesize);
			filedbservice.saveFile(newFile);
			System.out.println("destination file : "+ destinationFile);
			if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
				// This is a security check
				throw new FileStorageException("Cannot store file outside current directory.");
			}
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile,
					StandardCopyOption.REPLACE_EXISTING);
			}
		}
		catch (IOException e) {
			throw new FileStorageException("Failed to store file.", e);
		}
	}


	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.rootLocation, 1)
				.filter(path -> !path.equals(this.rootLocation))
				.map(this.rootLocation::relativize);
		}
		catch (IOException e) {
			throw new FileStorageException("Failed to read stored files", e);
		}
	}


	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}


	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				throw new StorageFileNotFoundException(
						"Could not read file: " + filename);

			}
		}
		catch (MalformedURLException e) {
			throw new StorageFileNotFoundException("Could not read file: " + filename, e);
		}
	}

}
