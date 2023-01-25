package com.example.apiblogapplication.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	
	private String resourcename;
	private String fieldName;
	private long fieldValue;
	
	public ResourceNotFoundException(String resourcename, String fieldName, long id) {
		super(String.format("%s , not found in %s:'%s'", resourcename,fieldName,id));
		this.resourcename = resourcename;
		this.fieldName = fieldName;
		this.fieldValue = id;
	}

	public String getResourcename() {
		return resourcename;
	}

	public String getFieldName() {
		return fieldName;
	}

	public long getFieldValue() {
		return fieldValue;
	}
	
	
	

}
