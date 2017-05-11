package com.navproduct.constants;

public enum HttpStatusCode {

	OK(200,"OK"),
	
	CREATED(201,"Created"),
	
	NO_CONTENT(204,"No Content"),
	
	
	REST_CONTENT(205,"Reset Content"),
	
	
	PARTIAL_CONTENT(206,"Partial Content"),
	
	MOVED_PERMANENTLY(301,"Moved Permanently"),
	
	BAD_REQUEST(400,"Bad Request"),
	
	
	UNAUTHORIZED(401,"Unauthorized"),
	
	
	PAYMENT_REQUIRED(402,"Payment Required"),
	
	
	FORBIDDEN(403,"Forbidden"),
	
	
	NOT_FOUND(404,"Not Found"),
	
	
	REQUEST_TIMEOUT(408,"Request Timeout"),
	
	
	INTERNAL_SERVER_ERROR(500,"Internal Server Error"),
	
	
	NOT_IMPLEMENTED(501,"Not Implemented");
	
	private final int code;
	private final String description;
	
	private HttpStatusCode(int statusCode, String description){
		this.code = statusCode;
		this.description = description;
	}
	
	public int getStatusCode(){
		return code;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String toString(){
		return description;
	}
}
