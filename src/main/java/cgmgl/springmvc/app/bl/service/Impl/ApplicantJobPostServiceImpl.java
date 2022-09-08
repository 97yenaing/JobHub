package cgmgl.springmvc.app.bl.service.Impl;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.bl.dto.ApplicantJobPostDto;
import cgmgl.springmvc.app.bl.service.ApplicantJobPostService;
import cgmgl.springmvc.app.persistence.dao.ApplicantJobPostDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantJobPost;

@Transactional
@Service
public class ApplicantJobPostServiceImpl implements ApplicantJobPostService {
    private ApplicantJobPostDao applicantJobPostDao;

    @Override
    public void doAddApplicantJobPost(ApplicantJobPostDto applicantJobPostDto) {
        Date currentDate = new Date();
        ApplicantJobPost applicantJobPost=new ApplicantJobPost(applicantJobPostDto);
        this.applicantJobPostDao.dbAddApplicantJobPost(applicantJobPost, currentDate);
    }
}
