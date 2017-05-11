package com.navproduct.exception;

public class NavDaoException extends NavException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3056381998307050501L;

	public NavDaoException(int httpCode, String errorCode, String errorMessage, Throwable throwable){
		super(httpCode, errorCode, errorMessage, throwable);
	}
	

	public static class Builder extends NavException.ExceptionBuilder<NavDaoException>{
		private Builder(String errorCode){
			super(errorCode);
		}
		
		private Builder (NavException e){
			super(e);
		}
		
		public static Builder create(String errorCode){
			return new Builder(errorCode);
		}
		
		public static Builder create(){
			return new Builder("1");
		}
		
		public static Builder create(NavException e){
			return new Builder(e);
		}
		
		public NavDaoException build(){
			return new NavDaoException(httpCode,errorCode,message,throwable);
		}
	}
}
