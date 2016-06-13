package com.necl.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.necl.dao.ReportAccidentDao;
import com.necl.model.ReportAccident;
import com.necl.service.ReportAccidentService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ReportAccidentServiceImpl implements ReportAccidentService {

	@Autowired
    private ReportAccidentDao reportAccidentDao;

	
	@Override
	public ReportAccident findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return reportAccidentDao.findById(id);
	}

	@Override
	public List<ReportAccident> findAll() throws Exception {
		// TODO Auto-generated method stub
		return reportAccidentDao.findAll();
	}

	@Override
	public boolean save(ReportAccident reportaAcident) throws Exception {
		// TODO Auto-generated method stub
		return reportAccidentDao.save(reportaAcident);
	}

	@Override
	public boolean update(ReportAccident reportaAcident) throws Exception {
		// TODO Auto-generated method stub
		return reportAccidentDao.update(reportaAcident);
	}

	@Override
	public boolean delete(ReportAccident reportaAcident) throws Exception {
		// TODO Auto-generated method stub
		return reportAccidentDao.delete(reportaAcident);
	}

}
