package com.navproduct.exception;

public class NavBusinessException extends NavServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5505754218991760819L;
	
	protected NavBusinessException(int httpCode, String errorCode, String errorMessage, Throwable throwable){
		super(httpCode, errorCode, errorMessage, throwable);
	}
	
	public static class Builder extends NavException.ExceptionBuilder<NavBusinessException>{
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
		
		public NavBusinessException build(){
			return new NavBusinessException(httpCode,errorCode,message,throwable);
		}
	}
}
