package com.necl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REPORT_TYPE")
public class ReportType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Type_ID")
	private int id;
	
	@Column(name = "Type_Name", nullable = false)
	private String typeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	
	
	
	
}
