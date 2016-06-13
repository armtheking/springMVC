package com.necl.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.necl.dao.ReportLocationDao;
import com.necl.model.ReportLocation;
import com.necl.service.ReportLocationService;

@Service
@Transactional
public class ReportLocationServiceImpl implements ReportLocationService{

	@Autowired
    private ReportLocationDao reportLocationDao;
	
	@Override
	public ReportLocation findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return reportLocationDao.findById(id);
	}

	@Override
	public List<ReportLocation> findAll() throws Exception {
		// TODO Auto-generated method stub
		return reportLocationDao.findAll();
	}

	@Override
	public boolean save(ReportLocation reportLocation) throws Exception {
		// TODO Auto-generated method stub
		return reportLocationDao.save(reportLocation);
	}

	@Override
	public boolean update(ReportLocation reportLocation) throws Exception {
		// TODO Auto-generated method stub
		return reportLocationDao.update(reportLocation);
	}

	@Override
	public boolean delete(ReportLocation reportLocation) throws Exception {
		// TODO Auto-generated method stub
		return reportLocationDao.delete(reportLocation);
	}


}
