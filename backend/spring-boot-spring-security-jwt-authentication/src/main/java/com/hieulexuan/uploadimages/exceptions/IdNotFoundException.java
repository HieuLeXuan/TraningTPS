package com.hieulexuan.uploadimages.exceptions;

public class IdNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdNotFoundException(String id) {
		super("user not found by id " + id);
	}

	public IdNotFoundException(Long id) {
		super("user not found by id " + id);
	}
	
}
