package cgmgl.springmvc.app.persistence.dao;

import java.util.Date;

import cgmgl.springmvc.app.persistence.entity.ApplicantJobPost;

public interface ApplicantJobPostDao {
    public void dbAddApplicantJobPost(ApplicantJobPost applicantJobPost,Date currentDate);
}
