package com.necl.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.necl.dao.ConfigReportNoDao;
import com.necl.model.ConfigReportNo;
import com.necl.service.ConfigReportService;

@Service
@Transactional
public class ConfigReportNoSerivceImpl implements ConfigReportService{

	@Autowired
	ConfigReportNoDao configReportNoDao;
	
	
	
	@Override
	public ConfigReportNo findByKey(String key) throws Exception {
		// TODO Auto-generated method stub
		return configReportNoDao.findByKey(key);
	}

	@Override
	public boolean update(ConfigReportNo configReportNo) throws Exception {
		// TODO Auto-generated method stub
		return configReportNoDao.update(configReportNo);
	}

	@Override
	public boolean save(ConfigReportNo configReportNo) throws Exception {
		// TODO Auto-generated method stub
		return configReportNoDao.save(configReportNo);
	}

	@Override
	public boolean delete(ConfigReportNo configReportNo) throws Exception {
		// TODO Auto-generated method stub
		return configReportNoDao.delete(configReportNo);
	}

	@Override
	public List<ConfigReportNo> findAll() {
		// TODO Auto-generated method stub
		return configReportNoDao.findAll();
	}

}
