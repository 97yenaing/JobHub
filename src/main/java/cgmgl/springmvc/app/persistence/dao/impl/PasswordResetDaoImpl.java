package cgmgl.springmvc.app.persistence.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.persistence.dao.PasswordResetDao;
import cgmgl.springmvc.app.persistence.entity.PasswordReset;


@Repository
@Transactional
public class PasswordResetDaoImpl implements PasswordResetDao{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void createToken(Object pswToken) {
        this.sessionFactory.getCurrentSession().save(pswToken);
        
    }
    @Override
    public PasswordReset getTokenDataByEmail(String user_email) {
        String userHqlQuery = "SELECT pw FROM PasswordReset pw WHERE pw.user_email = :email";
        Query queryUserByEmail = this.sessionFactory.getCurrentSession().createQuery(userHqlQuery);
        queryUserByEmail.setParameter("email", user_email);
        PasswordReset passwordReset = (PasswordReset) queryUserByEmail.uniqueResult();
        return passwordReset;
    }
    @Override
    public void deleteTokenByEmail(String user_email) {
        String userHqlQuery = "DELETE FROM PasswordReset pw WHERE pw.user_email = :email";
        Query queryUserByEmail = this.sessionFactory.getCurrentSession().createQuery(userHqlQuery);
        queryUserByEmail.setParameter("email", user_email);
        queryUserByEmail.executeUpdate();
        
    }
    @Override
    public PasswordReset dbGetDataByToken(String token) {
        String userHqlQuery = "SELECT pw FROM PasswordReset pw WHERE pw.token = :token";
        Query queryUserByToken = this.sessionFactory.getCurrentSession().createQuery(userHqlQuery);
        queryUserByToken.setParameter("token", token);
        PasswordReset passwordReset = (PasswordReset) queryUserByToken.uniqueResult();
        return passwordReset;
    }
    @Override
    public void dbDeleteToken(String token) {
        PasswordReset passwordReset = this.sessionFactory.getCurrentSession().load(PasswordReset.class, token);
        this.sessionFactory.getCurrentSession().delete(passwordReset);
        
    }

}
