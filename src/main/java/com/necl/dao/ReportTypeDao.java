package com.necl.dao;

import java.util.List;

import com.necl.model.ReportType;

public interface ReportTypeDao {
	
	public ReportType findById(long id) throws Exception;
    public List<ReportType> findAll() throws Exception;
    public boolean save(ReportType reportType) throws Exception;
    public boolean update(ReportType reportType) throws Exception;
    public boolean delete(ReportType reportType) throws Exception;

}
