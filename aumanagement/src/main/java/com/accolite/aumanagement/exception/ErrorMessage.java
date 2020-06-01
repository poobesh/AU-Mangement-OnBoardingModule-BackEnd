package com.accolite.aumanagement.exception;

import java.util.Date;

public class ErrorMessage {
	private Date date;
	private String message;
	private String details;
	private String httpCodeMessage;
	
	
	public ErrorMessage(Date date, String message, String details, String httpCodeMessage) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
		this.httpCodeMessage = httpCodeMessage;
	}

	
	public String getHttpCodeMessage() {
		return httpCodeMessage;
	}


	public void setHttpCodeMessage(String httpCodeMessage) {
		this.httpCodeMessage = httpCodeMessage;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
