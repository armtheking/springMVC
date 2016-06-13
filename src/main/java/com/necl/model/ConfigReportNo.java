package com.necl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIG_REPORT_NO")
public class ConfigReportNo {

	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "REPORT_PREFIX")
	private String reportPrefix;
	
	@Column(name = "REPORT_DESC")
	private String reportDesc;
	
	@Column(name = "REPORT_NO", length = 5)
	private String reportNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getReportPrefix() {
		return reportPrefix;
	}

	public void setReportPrefix(String reportPrefix) {
		this.reportPrefix = reportPrefix;
	}

	public String getReportDesc() {
		return reportDesc;
	}

	public void setReportDesc(String reportDesc) {
		this.reportDesc = reportDesc;
	}
	
	
}
