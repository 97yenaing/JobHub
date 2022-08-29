package cgmgl.springmvc.app.persistence.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public User dbGetUserByName(String username) {
        Query query = this.sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }
    @Override
    public long dbGetUserCount() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(u) FROM User u");
        return (long) query.getSingleResult();
    }
    @Override
    public void dbSaveUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
        
    }
    @Override
    public User dbFindUserByAllEmail(String user_email) {
        String userQuery = "SELECT u FROM User u WHERE u.email = :email";
        Query query = this.sessionFactory.getCurrentSession().createQuery(userQuery);
        query.setParameter("email", user_email);
        User user = (User) query.uniqueResult();
        return user;

    }
    @Override
    public void dbUpdateUserPassword(User user) {
       
        User user1 = this.sessionFactory.getCurrentSession().load(User.class, user.getId());
        if (user1 != null) {
            user1.setPassword(user.getPassword());
            this.sessionFactory.getCurrentSession().update(user);
        }
    }
}
