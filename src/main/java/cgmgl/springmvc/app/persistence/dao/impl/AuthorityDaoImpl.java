package cgmgl.springmvc.app.persistence.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cgmgl.springmvc.app.persistence.dao.AuthorityDao;
import cgmgl.springmvc.app.persistence.entity.Authority;
/**
 * <h2> AuthorityDaoImpl Class</h2>
 * <p>
 * Process for Displaying AuthorityDaoImpl
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Repository
@Transactional
public class AuthorityDaoImpl implements AuthorityDao{
    
    /**
     * <h2> sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    SessionFactory sessionFactory;
    
    /**
     * <h2> dbSaveAuthority </h2>
     * <p>
     * 
     * </p>
     * 
     * @param adminAuthority
     */
    @Override
    public void dbSaveAuthority(Authority adminAuthority) {
       this.sessionFactory.getCurrentSession().save(adminAuthority);
        
    }
    /**
     * <h2> dbGetAuthorityCount </h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public long dbGetAuthorityCount() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(u) FROM Authority u");
        return (long) query.getSingleResult();
    }
}