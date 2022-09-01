package cgmgl.springmvc.app.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.persistence.dao.JobPostDao;
import cgmgl.springmvc.app.persistence.entity.JobPost;

/**
 * <h2>JobPostDaoImpl Class</h2>
 * <p>
 * Process for Displaying JobPostDaoImpl
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
@Repository
@Transactional
public class JobPostDaoImpl implements JobPostDao {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>dbGetJobPostList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JobPost> dbGetJobPostList() {
        return sessionFactory.getCurrentSession().createQuery("from JobPost").list();
    }

    /**
     * <h2>dbGetJobPostById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobPostId
     * @return
     */
    @SuppressWarnings("deprecation")
    @Override
    public JobPost dbGetJobPostById(Integer jobPostId) {
        String jobPostHqlQuery = "SELECT jp FROM JobPost jp where jp.id = :id";
        Query queryJobPostById = this.sessionFactory.getCurrentSession().createQuery(jobPostHqlQuery);
        queryJobPostById.setParameter("id", jobPostId);
        JobPost resultJobPost = (JobPost) queryJobPostById.uniqueResult();
        return resultJobPost;
    }

    /**
     * <h2>dbAddJobPost</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobPost
     * @param currentDate
     */
    @Override
    public void dbAddJobPost(JobPost jobPost, Date currentDate) {
        jobPost.setCreated_at(currentDate);
        jobPost.setExpired_at(currentDate);
        sessionFactory.getCurrentSession().saveOrUpdate(jobPost);
    }

    /**
     * <h2>dbDeleteJobPost</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobPostId
     */
    @Override
    public void dbDeleteJobPost(Integer jobPostId) {
        JobPost jobPost = sessionFactory.getCurrentSession().load(JobPost.class, jobPostId);
        if (null != jobPost) {
            this.sessionFactory.getCurrentSession().delete(jobPost);
        }
    }

    /**
     * <h2>dbUpdateJobPost</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobPost
     * @param updateAt
     */
    @Override
    public void dbUpdateJobPost(JobPost jobPost, Date updateAt) {
        this.sessionFactory.getCurrentSession().update(jobPost);
    }
}