package cgmgl.springmvc.app.persistence.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cgmgl.springmvc.app.persistence.dao.ApplicantInfoDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;


@Transactional
@Repository
public class ApplicantInfoDaoImpl implements ApplicantInfoDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void dbSaveApplicantInfo(ApplicantInfo appInfo) {
		// TODO Auto-generated method stub
		System.out.println(appInfo.getId());
		System.out.println(appInfo.getAddress());
		this.sessionFactory.getCurrentSession().save(appInfo);
	}


}