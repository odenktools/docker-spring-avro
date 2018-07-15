package com.odenktools.spring.kafka.avroconsumer.models;

import java.util.Date;

public class ApiKey {

	private Integer id;
	private Date created_at;
	private Date updated_at;
	private String modules;

	public ApiKey(Integer id, Date created_at, Date updated_at, String modules) {

		this.id = id;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.modules = modules;
	}

	@Override
	public String toString() {

		return "ApiKey{" +
				"id=" + id +
				", created_at=" + created_at +
				", updated_at=" + updated_at +
				", modules='" + modules + '\'' +
				'}';
	}
}
