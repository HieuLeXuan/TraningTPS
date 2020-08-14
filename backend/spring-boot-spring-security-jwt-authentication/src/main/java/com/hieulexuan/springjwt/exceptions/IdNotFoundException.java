package com.hieulexuan.springjwt.exceptions;

public class IdNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdNotFoundException(String id) {
		super("user not found by id " + id);
	}

}