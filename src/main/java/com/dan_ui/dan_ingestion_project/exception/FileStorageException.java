package com.dan_ui.dan_ingestion_project.exception;

public class FileStorageException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	public FileStorageException(String msg) {
		this.msg = msg;
	}
	public FileStorageException(String message, Throwable cause) {
		super(message, cause);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
