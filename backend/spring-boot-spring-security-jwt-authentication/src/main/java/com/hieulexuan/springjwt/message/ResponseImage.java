package com.hieulexuan.springjwt.message;

public class ResponseImage {
	private String name;
	private byte[] data;
	private String url;
	private String type;
	private long size;

	public ResponseImage(String name, byte[] data, String url, String type, long size) {
		this.name = name;
		this.data = data;
		this.url = url;
		this.type = type;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
}
