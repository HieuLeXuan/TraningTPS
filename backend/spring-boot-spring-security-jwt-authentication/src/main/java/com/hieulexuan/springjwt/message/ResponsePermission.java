package com.hieulexuan.springjwt.message;

public class ResponsePermission {

	private int id;
	private String name;

	public ResponsePermission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponsePermission(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
