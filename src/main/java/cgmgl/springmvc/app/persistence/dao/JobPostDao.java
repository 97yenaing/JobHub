package cgmgl.springmvc.app.persistence.dao;

import java.util.Date;
import java.util.List;

import cgmgl.springmvc.app.persistence.entity.JobPost;

/**
 * <h2> JobPostDao Class</h2>
 * <p>
 * Process for Displaying JobPostDao
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
public interface JobPostDao {
    /**
     * <h2> dbGetJobPostList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<JobPost>
     */
    public List<JobPost> dbGetJobPostList();

    /**
     * <h2> dbGetJobPostById</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPostId
     * @return
     * @return JobPost
     */
    public JobPost dbGetJobPostById(Integer jobPostId);

    /**
     * <h2> dbAddJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPost
     * @param currentDate
     * @return void
     */
    public void dbAddJobPost(JobPost jobPost, Date currentDate);

    /**
     * <h2> dbDeleteJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPostId
     * @return void
     */
    public void dbDeleteJobPost(Integer jobPostId);

    /**
     * <h2> dbUpdateJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPost
     * @param updateAt
     * @return void
     */
    public void dbUpdateJobPost(JobPost jobPost,Date updateAt);
}