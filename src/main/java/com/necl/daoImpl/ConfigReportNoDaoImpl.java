package com.necl.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.necl.dao.ConfigReportNoDao;
import com.necl.model.ConfigReportNo;

@Repository
public class ConfigReportNoDaoImpl implements ConfigReportNoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public ConfigReportNo findByKey(String key) throws Exception {
		
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ConfigReportNo.class);
		crit.add(Restrictions.eq("reportDesc", key));
		return (ConfigReportNo) crit.uniqueResult();
	}

	@Override
	public boolean update(ConfigReportNo configReportNo) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(configReportNo);
		return true;
	}

	@Override
	public boolean save(ConfigReportNo configReportNo) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(configReportNo);
		return true;
	}

	@Override
	public boolean delete(ConfigReportNo configReportNo) throws Exception {
		sessionFactory.getCurrentSession().delete(configReportNo);
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConfigReportNo> findAll() {
		List<ConfigReportNo> configReportNoList = sessionFactory.getCurrentSession().createCriteria(ConfigReportNo.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list(); 
		return configReportNoList;
	}

}
