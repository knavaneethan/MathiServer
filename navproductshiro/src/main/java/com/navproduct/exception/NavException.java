package com.navproduct.exception;

import com.navproduct.constants.HttpStatusCode;

public abstract class NavException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5736272845006421588L;

	private int httpCode;
	private String errorCode;
	
	protected NavException(int httpCode, String errorCode, String errorMsg, Throwable throwable){
		super(errorMsg, throwable);
		setHttpCode(httpCode);
		this.errorCode=errorCode;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
	
	public static abstract class ExceptionBuilder<T>{
		protected int httpCode = HttpStatusCode.INTERNAL_SERVER_ERROR.getStatusCode();
		
		protected String errorCode;
		
		protected String message;
		
		protected Throwable throwable;
		protected NavException exception;
		
		protected ExceptionBuilder(){}
		
		protected ExceptionBuilder(String errorCode){
			this.errorCode=errorCode;
		}
		
		protected ExceptionBuilder(NavException e){
			errorCode = e.getErrorCode();
			message =  e.getMessage();
			throwable = e.getCause();
			httpCode = e.getHttpCode();
		}
		
		public ExceptionBuilder<T> message(String message){
			this.message = message;
			return this;
		}
		
		public ExceptionBuilder<T> throwable(Throwable throwable){
			this.throwable = throwable;
			return this;
		}
		
		public ExceptionBuilder<T> httpCode(int httpCode){
			this.httpCode = httpCode;
			return this;
		}
	}
}
