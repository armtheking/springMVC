package com.necl.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.necl.dao.ReportLocationDao;
import com.necl.model.ReportLocation;


@Repository
public class ReportLocationDaoImpl implements ReportLocationDao{

	 @Autowired
	 private SessionFactory sessionFactory;

	 
	 @Override
		public ReportLocation findById(long id) throws Exception {
			// TODO Auto-generated method stub
		 ReportLocation reportLocation = (ReportLocation) sessionFactory.getCurrentSession().get(ReportLocation.class, id);
	        return reportLocation;
		}
	 	@SuppressWarnings("unchecked")
		@Override
		public List<ReportLocation> findAll() throws Exception {
			// TODO Auto-generated method stub
			 List<ReportLocation> reportLocationList = sessionFactory.getCurrentSession().createCriteria(ReportLocation.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			 return reportLocationList;
		}

		@Override
		public boolean save(ReportLocation reportLocation) throws Exception {
			// TODO Auto-generated method stub
			 sessionFactory.getCurrentSession().saveOrUpdate(reportLocation);
			 return true;
		}

		@Override
		public boolean update(ReportLocation reportLocation) throws Exception {
			// TODO Auto-generated method stub
			 sessionFactory.getCurrentSession().saveOrUpdate(reportLocation);
			 return true;
		}

		@Override
		public boolean delete(ReportLocation reportLocation) throws Exception {
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().delete(reportLocation);
	        return true;
		}
}
