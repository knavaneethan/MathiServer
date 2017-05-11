package com.navproduct.exception;

public class NavServiceException extends NavException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5505754218991760819L;
	
	protected NavServiceException(int httpCode, String errorCode, String errorMessage, Throwable throwable){
		super(httpCode, errorCode, errorMessage, throwable);
	}
	
	public static class Builder extends NavException.ExceptionBuilder<NavServiceException>{
		private Builder(String errorCode){
			super(errorCode);
		}
		
		private Builder (NavException e){
			super(e);
		}
		
		public static Builder create(String errorCode){
			return new Builder(errorCode);
		}
		
		public static Builder create(NavException e){
			return new Builder(e);
		}
		
		public NavServiceException build(){
			return new NavServiceException(httpCode,errorCode,message,throwable);
		}
	}
}
