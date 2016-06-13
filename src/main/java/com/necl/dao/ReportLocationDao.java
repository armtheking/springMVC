package com.necl.dao;

import java.util.List;

import com.necl.model.ReportLocation;

public interface ReportLocationDao {

	public ReportLocation findById(long id) throws Exception;
    public List<ReportLocation> findAll() throws Exception;
    public boolean save(ReportLocation reportLocation) throws Exception;
    public boolean update(ReportLocation reportLocation) throws Exception;
    public boolean delete(ReportLocation reportLocation) throws Exception;
}
