package cgmgl.springmvc.app.persistence.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * <h2> UserDaoImpl Class</h2>
 * <p>
 * Process for Displaying UserDaoImpl
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    /**
     * <h2> sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    SessionFactory sessionFactory;
    /**
     * <h2> dbGetUserByName </h2>
     * <p>
     * 
     * </p>
     * 
     * @param username
     * @return
     */
    @Override
    public User dbGetUserByName(String username) {
        Query query = this.sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }
    /**
     * <h2> dbGetUserCount </h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public long dbGetUserCount() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(u) FROM User u");
        return (long) query.getSingleResult();
    }
    /**
     * <h2> dbSaveUser </h2>
     * <p>
     * 
     * </p>
     * 
     * @param user
     */
    @Override
    public void dbSaveUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
        
    }
    /**
     * <h2> dbFindUserByAllEmail </h2>
     * <p>
     * 
     * </p>
     * 
     * @param user_email
     * @return
     */
    @Override
    public User dbFindUserByAllEmail(String user_email) {
        String userQuery = "SELECT u FROM User u WHERE u.email = :email";
        Query query = this.sessionFactory.getCurrentSession().createQuery(userQuery);
        query.setParameter("email", user_email);
        User user = (User) query.uniqueResult();
        return user;

    }
    /**
     * <h2> dbUpdateUserPassword </h2>
     * <p>
     * 
     * </p>
     * 
     * @param user
     */
    @Override
    public void dbUpdateUserPassword(User user) {
       
        User user1 = this.sessionFactory.getCurrentSession().load(User.class, user.getId());
        if (user1 != null) {
            user1.setPassword(user.getPassword());
            this.sessionFactory.getCurrentSession().update(user);
        }
    }
}