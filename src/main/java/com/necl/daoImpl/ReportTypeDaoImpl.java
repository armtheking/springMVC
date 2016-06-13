package com.necl.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.necl.dao.ReportTypeDao;
import com.necl.model.ReportType;

@Repository
public class ReportTypeDaoImpl implements ReportTypeDao{
	
		@Autowired
		private SessionFactory sessionFactory;

	 
	 @Override
		public ReportType findById(long id) throws Exception {
			// TODO Auto-generated method stub
		 ReportType reportType = (ReportType) sessionFactory.getCurrentSession().get(ReportType.class, id);
	        return reportType;
		}

	 	@SuppressWarnings("unchecked")
		@Override
		public List<ReportType> findAll() throws Exception {
			// TODO Auto-generated method stub
			 List<ReportType> reportTypeList = sessionFactory.getCurrentSession().createCriteria(ReportType.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			 return reportTypeList;
		}

		@Override
		public boolean save(ReportType reportType) throws Exception {
			// TODO Auto-generated method stub
			 sessionFactory.getCurrentSession().saveOrUpdate(reportType);
			 return true;
		}

		@Override
		public boolean update(ReportType reportType) throws Exception {
			// TODO Auto-generated method stub
			 sessionFactory.getCurrentSession().saveOrUpdate(reportType);
			 return true;
		}

		@Override
		public boolean delete(ReportType reportType) throws Exception {
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().delete(reportType);
	        return true;
		}
}
