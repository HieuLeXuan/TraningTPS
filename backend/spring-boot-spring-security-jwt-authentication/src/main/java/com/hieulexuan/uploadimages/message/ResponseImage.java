package com.hieulexuan.uploadimages.message;

import java.util.Date;

public class ResponseImage {
	private String id;
	private String name;
	private byte[] data;
	private String url;
	private String description;
	private String type;
	private long size;
	private Date createdate;

	public ResponseImage(String id, String name, String url, byte[] data, String description, String type, long size,
			Date createdate) {
		this.id = id;
		this.name = name;
		this.data = data;
		this.url = url;
		this.description = description;
		this.type = type;
		this.size = size;
		this.createdate = createdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
