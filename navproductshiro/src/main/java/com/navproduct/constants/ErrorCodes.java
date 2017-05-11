package com.navproduct.constants;

public enum ErrorCodes {

	APP_COMMON("ERROR_000","Generic error",HttpStatusCode.INTERNAL_SERVER_ERROR),
	
	INVALID_INPUT("ERROR_001","Inavlid Input",HttpStatusCode.PARTIAL_CONTENT);
	
	private String errorCode;
	
	private String errorMessage;
	
	private HttpStatusCode httpStatusCode;
	
	private ErrorCodes(String errorCode,String errorMessage,HttpStatusCode httpStatusCode){
		this.errorCode=errorCode;
		this.errorMessage=errorMessage;
		this.httpStatusCode = httpStatusCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public HttpStatusCode getHttpStatusCode() {
		return httpStatusCode;
	}

	public String toString(){
		return "Error Code: "+this.errorCode+" this.errorDescription: "+this.errorMessage+" this.httpStatusCode"+this.httpStatusCode;
	}
	

}
