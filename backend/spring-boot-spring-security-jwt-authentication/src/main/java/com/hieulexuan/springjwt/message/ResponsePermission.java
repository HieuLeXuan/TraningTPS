package com.hieulexuan.springjwt.message;

public class ResponsePermission {

	private long id;
	private String name;
//	private boolean checked;

	public ResponsePermission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponsePermission(long id, String name) {
		super();
		this.id = id;
		this.name = name;
//		this.checked = false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public boolean isChecked() {
//		return checked;
//	}
//
//	public void setChecked(boolean checked) {
//		this.checked = checked;
//	}
	
}
