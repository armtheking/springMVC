package com.necl.service;

import java.util.List;

import com.necl.model.ReportLocation;

public interface ReportLocationService {
	public ReportLocation findById(long id) throws Exception;
    public List<ReportLocation> findAll() throws Exception;
    public boolean save(ReportLocation reportLocation) throws Exception;
    public boolean update(ReportLocation reportLocation) throws Exception;
    public boolean delete(ReportLocation reportLocation) throws Exception;
}
