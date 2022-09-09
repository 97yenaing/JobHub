package cgmgl.springmvc.app.bl.service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.bl.dto.ApplicantJobPostDto;
import cgmgl.springmvc.app.bl.service.ApplicantJobPostService;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.dao.ApplicantJobPostDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.ApplicantJobPost;

/**
 * <h2> ApplicantJobPostServiceImpl Class</h2>
 * <p>
 * Process for Displaying ApplicantJobPostServiceImpl
 * </p>
 * 
 * @author HtetSuMoe
 *
 */
@Transactional
@Service
public class ApplicantJobPostServiceImpl implements ApplicantJobPostService {
    /**
     * <h2> applicantJobPostDao</h2>
     * <p>
     * applicantJobPostDao
     * </p>
     */
    @Autowired
    private ApplicantJobPostDao applicantJobPostDao;

    /**
     * <h2> userService</h2>
     * <p>
     * userService
     * </p>
     */
    @Autowired
    private UserService userService;

    /**
     * <h2> doAddApplicantJobPost </h2>
     * <p>
     * 
     * </p>
     * 
     * @param applicantJobPostDto
     */
    @Override
    public void doAddApplicantJobPost(ApplicantJobPostDto applicantJobPostDto) {
        ApplicantInfo applicantInfo = new ApplicantInfo();
        applicantInfo.setId(userService.doGetLoginInfo().getId());
        Date currentDate = new Date();
        ApplicantJobPost applicantJobPost = new ApplicantJobPost(applicantJobPostDto);
        applicantJobPost.setStatus("Pending");
        applicantJobPost.setApplicantInfo(applicantInfo);
        applicantJobPost.setJobPost(applicantJobPostDto.getJobPost());
        this.applicantJobPostDao.dbAddApplicantJobPost(applicantJobPost, currentDate);
    }
}