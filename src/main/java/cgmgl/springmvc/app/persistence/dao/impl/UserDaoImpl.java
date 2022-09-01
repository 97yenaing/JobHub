package cgmgl.springmvc.app.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * Class UserDaoImpl.
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void dbSaveUser(User user) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public long dbGetUserCount() {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(u) FROM User u");
		return (long) query.getSingleResult();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public User dbGetUserById(long userId) {
		// TODO Auto-generated method stub
		Query userById = this.sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u where u.id = :id");
		userById.setParameter("id", userId);
		User userOneByid = (User) userById.uniqueResult();
		return userOneByid;
	}

	@Override
	public void dbUpdateUser(@Valid User user) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(user);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public User dbGetUserByEmail(String userEmail) {
		// TODO Auto-generated method stub
		Query userById = this.sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u where u.email = :email");
		userById.setParameter("email", userEmail);
		User userOneByid = (User) userById.uniqueResult();
		return userOneByid;
	}

	@Override
	public void dbAddUser(User user, ApplicantInfo applicantInfo, Date created_date) {
		// TODO Auto-generated method stub
		user.setApplicantInfo(applicantInfo);
		user.setCreated_at(created_date);
		this.sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> dbGetUserList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
}