package com.projectdemo.Services;

public class ResponseObjectService {
	private String status;
	private String message;
	private Object userdetail;
	public ResponseObjectService(String status, String message, Object userdetail) {
		this.status = status;
		this.message = message;
		this.userdetail = userdetail;
	}
	public ResponseObjectService() {
		
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getUserdetail() {
		return userdetail;
	}
	public void setUserdetail(Object userdetail) {
		this.userdetail = userdetail;
	}
}
