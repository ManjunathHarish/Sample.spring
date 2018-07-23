package com.properties.App.Exception;

public class ExceptionResponse {
	private String Description;
	private String path;
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [Description=" + Description + ", path=" + path + "]";
	}
	
	
}


