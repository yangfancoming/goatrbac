package com.goat.rbac.goatrbac.system.model;


import java.io.Serializable;

public class Dict implements Serializable{

	private static final long serialVersionUID = 7780820231535870010L;

	private Long dictId;

	private String keyy;

	private String value;

	private String tableName;

	private String fieldName;


	public Long getDictId() {
		return dictId;
	}

	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	public String getKeyy() {
		return keyy;
	}

	public void setKeyy(String keyy) {
		this.keyy = keyy;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName == null ? null : fieldName.trim();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName == null ? null : tableName.trim();
	}
}