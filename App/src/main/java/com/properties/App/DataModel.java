package com.properties.App;

import javax.persistence.*;


@Entity
@Table(name="data")
public class DataModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="rules")
	private String properties;
	@Column(name="value")
	private String values;
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	public String getValues() {
		return values;
	}
	public void setValues(String values) {
		this.values = values;
	}
	@Override
	public String toString() {
		return "DataModel [id=" + id + ", properties=" + properties + ", values=" + values + "]";
	}
	
}
