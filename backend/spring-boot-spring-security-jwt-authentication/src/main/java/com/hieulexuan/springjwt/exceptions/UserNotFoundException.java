package com.hieulexuan.springjwt.exceptions;

public class UserNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long user_id) {
		super("user not found by id " + user_id);
	}
	
//	public UserNotFoundException(String username) {
//		super("user not found by id " + username);
//	}
}
