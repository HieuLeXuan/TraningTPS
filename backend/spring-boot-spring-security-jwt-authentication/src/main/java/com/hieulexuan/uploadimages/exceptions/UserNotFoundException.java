package com.hieulexuan.uploadimages.exceptions;

public class UserNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String username) {
		super("user not found by id " + username);
	}

}
