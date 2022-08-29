package cgmgl.springmvc.app.persistence.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cgmgl.springmvc.app.persistence.dao.AuthorityDao;
import cgmgl.springmvc.app.persistence.entity.Authority;
@Repository
@Transactional
public class AuthorityDaoImpl implements AuthorityDao{
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public void dbSaveAuthority(Authority adminAuthority) {
       this.sessionFactory.getCurrentSession().save(adminAuthority);
        
    }
    @Override
    public long dbGetAuthorityCount() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(u) FROM Authority u");
        return (long) query.getSingleResult();
    }
}
