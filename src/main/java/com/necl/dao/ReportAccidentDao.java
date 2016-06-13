package com.necl.dao;

import java.util.List;

import com.necl.model.ReportAccident;

public interface ReportAccidentDao {
	 	public ReportAccident findById(long id) throws Exception;
	    public List<ReportAccident> findAll() throws Exception;
	    public boolean save(ReportAccident reportaAcident) throws Exception;
	    public boolean update(ReportAccident reportaAcident) throws Exception;
	    public boolean delete(ReportAccident reportaAcident) throws Exception;
}
