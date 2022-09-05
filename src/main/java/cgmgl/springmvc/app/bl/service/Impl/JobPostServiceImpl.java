package cgmgl.springmvc.app.bl.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.bl.dto.JobPostDto;
import cgmgl.springmvc.app.bl.service.JobPostService;
import cgmgl.springmvc.app.persistence.dao.JobPostDao;
import cgmgl.springmvc.app.persistence.dao.JobTypeDao;
import cgmgl.springmvc.app.persistence.entity.JobPost;
import cgmgl.springmvc.app.persistence.entity.JobType;

/**
 * <h2>JobPostServiceImpl Class</h2>
 * <p>
 * Process for Displaying JobPostServiceImpl
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
@Transactional
@Service
public class JobPostServiceImpl implements JobPostService {
    /**
     * <h2>jobPostDao</h2>
     * <p>
     * jobPostDao
     * </p>
     */
    @Autowired
    private JobPostDao jobPostDao;

    /**
     * <h2>jobTypeDao</h2>
     * <p>
     * jobTypeDao
     * </p>
     */
    @Autowired
    private JobTypeDao jobTypeDao;

    /**
     * <h2>doGetJobPostList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public List<JobPost> doGetJobPostList() {
        return jobPostDao.dbGetJobPostList();
    }
    /**
     * <h2> doGetJobPostByJobTypeId </h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobTypeId
     * @return
     */
    @Override
    public List<JobPost> doGetJobPostByJobTypeId(Integer jobTypeId) {
        return jobPostDao.dbGetJobPostByJobTypeId(jobTypeId);
    }
    /**
     * <h2>doGetJobPostById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobPostId
     * @return
     */
    @Override
    public JobPostDto doGetJobPostById(int jobPostId) {
        JobPost jobPost = jobPostDao.dbGetJobPostById(jobPostId);
        JobPostDto jobPostDto = jobPost != null ? new JobPostDto(jobPost) : null;
        return jobPostDto;
    }

    /**
     * <h2>doAddJobPost</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobPostDto
     */
    @Override
    public void doAddJobPost(JobPostDto jobPostDto) {
        Date currentDate = new Date();
        JobPost jobPost = new JobPost(jobPostDto);
        this.jobPostDao.dbAddJobPost(jobPost, currentDate);
    }

    /**
     * <h2>doDeleteJobPost</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobPostId
     */
    @Override
    public void doDeleteJobPost(Integer jobPostId) {
        Date currentDate = new Date();
        jobPostDao.dbDeleteJobPost(jobPostId,currentDate);
    }

    /**
     * <h2>doUpdateJobPost</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobPostDto
     */
    @Override
    public void doUpdateJobPost(JobPostDto jobPostDto) {
        JobPost updateJobPost = this.jobPostDao.dbGetJobPostById(jobPostDto.getId());
        JobType jobTypeId = jobTypeDao.dbGetJobTypeById(jobPostDto.getJobType().getId());
        updateJobPost.setJobType(jobTypeId);
        updateJobPost.setPosition(jobPostDto.getPosition());
        updateJobPost.setOffered_salary(Integer.parseInt(jobPostDto.getOffered_salary()));
        updateJobPost.setExperience_year(jobPostDto.getExperience_year());
        updateJobPost.setNum_of_position(jobPostDto.getNum_of_position());
        this.jobPostDao.dbUpdateJobPost(updateJobPost, new Date());
    }

    /**
     * <h2>doGetJobTypeList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public List<JobType> doGetJobTypeList() {
        return this.jobTypeDao.dbGetJobTypeList();
    }

    /**
     * <h2>doGetJobTypeById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobTypeId
     * @return
     */
    @Override
    public JobType doGetJobTypeById(int jobTypeId) {
        return this.jobTypeDao.dbGetJobTypeById(jobTypeId);
    }
}