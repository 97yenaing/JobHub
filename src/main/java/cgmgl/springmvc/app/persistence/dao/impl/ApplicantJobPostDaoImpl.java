package cgmgl.springmvc.app.persistence.dao.impl;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import cgmgl.springmvc.app.persistence.dao.ApplicantJobPostDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantJobPost;

@Repository
@Transactional
public class ApplicantJobPostDaoImpl implements ApplicantJobPostDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void dbAddApplicantJobPost(ApplicantJobPost applicantJobPost, Date currentDate) {
        applicantJobPost.setApply_date(currentDate);
        sessionFactory.getCurrentSession().saveOrUpdate(applicantJobPost);
    }

}
