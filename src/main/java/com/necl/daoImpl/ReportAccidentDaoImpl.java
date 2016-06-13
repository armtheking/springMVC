package com.necl.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.necl.dao.ReportAccidentDao;
import com.necl.model.ReportAccident;

@Repository
public class ReportAccidentDaoImpl implements ReportAccidentDao {

	 @Autowired
	 private SessionFactory sessionFactory;

	@Override
	public ReportAccident findById(long id) throws Exception {
		// TODO Auto-generated method stub
		ReportAccident reportAccident = (ReportAccident) sessionFactory.getCurrentSession().get(ReportAccident.class, id);
        return reportAccident;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportAccident> findAll() throws Exception {
		// TODO Auto-generated method stub
		 List<ReportAccident> reportAccidentList = sessionFactory.getCurrentSession().createCriteria(ReportAccident.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		 return reportAccidentList;
	}

	@Override
	public boolean save(ReportAccident reportaAcident) throws Exception {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().saveOrUpdate(reportaAcident);
		 return true;
	}

	@Override
	public boolean update(ReportAccident reportaAcident) throws Exception {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().saveOrUpdate(reportaAcident);
		 return true;
	}

	@Override
	public boolean delete(ReportAccident reportaAcident) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(reportaAcident);
        return true;
	}

}
