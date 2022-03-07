package com.cg.mtb.exception;

import java.time.LocalDateTime;

public class ErrorInfo {
	private LocalDateTime timestamp;
	private String message;
	private String url;
	
	public ErrorInfo(LocalDateTime timestamp, String message, String url) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.url = url;
	}

	public ErrorInfo() {
		super();
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



}
