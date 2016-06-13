package com.necl.service;

import java.util.List;

import com.necl.model.ConfigReportNo;

public interface ConfigReportService {

	public ConfigReportNo findByKey(String key) throws Exception;
    public boolean update(ConfigReportNo configReportNo) throws Exception;
    public boolean save(ConfigReportNo configReportNo) throws Exception;
    public boolean delete(ConfigReportNo configReportNo) throws Exception;
    List<ConfigReportNo> findAll();
    
}
