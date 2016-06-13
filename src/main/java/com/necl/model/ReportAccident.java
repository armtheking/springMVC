package com.necl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.commons.CommonsMultipartFile;



@Entity
@Table(name = "REPOR_ACCIDENT")
public class ReportAccident {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Report_ID")
	private int id;
	
	@Column(name = "Report_Name" , nullable = false)
	private String report_name;
	
	@Column(name = "Report_no")
	private String report_no;
	
	@Column(name = "Report_date")
	private String report_date;
	
	@Column(name = "Report_month")
	private String report_month;
	
	@Column(name = "Report_year")
	private String report_year;
	
	@Column(name = "Report_Status")
	private String report_status;
	
	@JoinColumn(name = "Type_ID")
	private String reportType;
	
	@JoinColumn(name = "Location_ID")
	private String reportLocation;
	
	@Column(name = "File_name")
	private String file_name;
	
	@Transient
	private CommonsMultipartFile file_data;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "REPORT_USER_USE", 
			joinColumns={@JoinColumn(name="Report_ID")},
			inverseJoinColumns={@JoinColumn(name = "EMPLOYEE_ID")})
	private List<User> user = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReport_name() {
		return report_name;
	}

	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}

	public String getReport_no() {
		return report_no;
	}

	public void setReport_no(String report_no) {
		this.report_no = report_no;
	}

	public String getReport_date() {
		return report_date;
	}

	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}

	public String getReport_month() {
		return report_month;
	}

	public void setReport_month(String report_month) {
		this.report_month = report_month;
	}

	public String getReport_year() {
		return report_year;
	}

	public void setReport_year(String report_year) {
		this.report_year = report_year;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
//
	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public CommonsMultipartFile getFile_data() {
		return file_data;
	}

	public void setFile_data(CommonsMultipartFile file_data) {
		this.file_data = file_data;
	}

	public String getReport_status() {
		return report_status;
	}

	public void setReport_status(String report_status) {
		this.report_status = report_status;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportLocation() {
		return reportLocation;
	}

	public void setReportLocation(String reportLocation) {
		this.reportLocation = reportLocation;
	}





	
	
	
	
	
}
