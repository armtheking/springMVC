package com.necl.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.necl.dao.ReportTypeDao;
import com.necl.model.ReportType;
import com.necl.service.ReportTypeService;

@Service
@Transactional
public class ReportTypeServiceImpl implements ReportTypeService{
	
	@Autowired
    private ReportTypeDao reportTypeDao;
	
	@Override
	public ReportType findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return reportTypeDao.findById(id);
	}

	@Override
	public List<ReportType> findAll() throws Exception {
		// TODO Auto-generated method stub
		return reportTypeDao.findAll();
	}

	@Override
	public boolean save(ReportType reportType) throws Exception {
		// TODO Auto-generated method stub
		return reportTypeDao.save(reportType);
	}

	@Override
	public boolean update(ReportType reportType) throws Exception {
		// TODO Auto-generated method stub
		return reportTypeDao.update(reportType);
	}

	@Override
	public boolean delete(ReportType reportType) throws Exception {
		// TODO Auto-generated method stub
		return reportTypeDao.delete(reportType);
	}
}
