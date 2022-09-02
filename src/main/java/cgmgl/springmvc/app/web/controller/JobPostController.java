package cgmgl.springmvc.app.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.JobPostDto;
import cgmgl.springmvc.app.bl.service.JobPostService;
import cgmgl.springmvc.app.persistence.entity.JobPost;
import cgmgl.springmvc.app.persistence.entity.JobType;

/**
 * <h2>JobPostController Class</h2>
 * <p>
 * Process for Displaying JobPostController
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
@Controller
public class JobPostController {
    /**
     * <h2>jobPostService</h2>
     * <p>
     * jobPostService
     * </p>
     */
    @Autowired
    private JobPostService jobPostService;
    /**
     * <h2>messageSource</h2>
     * <p>
     * messageSource
     * </p>
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * <h2>getJobPostList</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/jobPostList")
    public ModelAndView getJobPostList(ModelAndView model) {
        List<JobPost> jobPostList = jobPostService.doGetJobPostList();
        model.addObject("JobPostList", jobPostList);
        model.setViewName("jobPostList");
        return model;
    }

    /**
     * <h2>newJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/createJobPosts", method = RequestMethod.GET)
    public ModelAndView newJobPost(ModelAndView model) {
        ModelAndView createJobPost = new ModelAndView("createJobPost");
        JobPostDto jobPost = new JobPostDto();
        createJobPost.addObject("rollBackJobPostDto", jobPost);
        List<JobType> typeList = jobPostService.doGetJobTypeList();
        createJobPost.addObject("JobTypeList", typeList);
        createJobPost.setViewName("createJobPost");
        return createJobPost;
    }

    /**
     * <h2>insertJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/createJobPostConfirm", params = "confirmJobPost", method = RequestMethod.POST)
    public ModelAndView insertJobPost(@ModelAttribute("rollBackJobPostDto") @Valid JobPostDto jobPostDto,
            BindingResult result, HttpServletRequest request) {
        ModelAndView JobPostConfirmView = new ModelAndView("createJobPostConfirm");
        List<JobType> typeList = jobPostService.doGetJobTypeList();
        if (result.hasErrors()) {
            ModelAndView errorView = new ModelAndView("createJobPost");
            errorView.addObject("JobTypeList", typeList);
            errorView.addObject("rollBackJobPostDto", jobPostDto);
            errorView.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
            return errorView;
        } else {
            JobPostConfirmView.addObject("JobTypeList", typeList);
            JobPostConfirmView.addObject("jobPostDto", jobPostDto);
            JobPostConfirmView.setViewName("createJobPostConfirm");
        }
        return JobPostConfirmView;
    }

    /**
     * <h2>createJobPostConfirm</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPostDto
     * @param result
     * @param request
     * @param response
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/insertJobPost", params = "addJobPost", method = RequestMethod.POST)
    public ModelAndView createJobPostConfirm(@ModelAttribute("jobPostDto") @Valid JobPostDto jobPostDto,
            BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView createJobPostView = new ModelAndView("redirect:/jobPostList");
        List<JobType> typeList = jobPostService.doGetJobTypeList();
        JobType jobTypeId = jobPostService.doGetJobTypeById(jobPostDto.getJobType().getId());
        jobPostDto.setJobType(jobTypeId);
        createJobPostView.addObject("JobTypeList", typeList);
        createJobPostView.addObject("rollBackJobPostDto", jobPostDto);
        this.jobPostService.doAddJobPost(jobPostDto);
        return createJobPostView;
    }

    /**
     * <h2>cancelJobPosrConfirm</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPostDto
     * @param result
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/insertJobPost", params = "cancel", method = RequestMethod.POST)
    public ModelAndView cancelJobPosrConfirm(@ModelAttribute("jobPostDto") @Valid JobPostDto jobPostDto,
            BindingResult result) {
        ModelAndView createJobPostView = new ModelAndView("createJobPost");
        createJobPostView.addObject("rollBackJobPostDto", jobPostDto);
        return createJobPostView;
    }

    /**
     * <h2>editJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPostId
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/editJobPosts", method = RequestMethod.GET)
    public ModelAndView editJobPost(@RequestParam("id") Integer jobPostId) {
        ModelAndView editJobPostView = new ModelAndView("updateJobPost");
        JobPostDto jobPostDto = jobPostService.doGetJobPostById(jobPostId);
        editJobPostView.addObject("editJobPostDto", jobPostDto);
        List<JobType> typeList = jobPostService.doGetJobTypeList();
        editJobPostView.addObject("JobTypeList", typeList);
        editJobPostView.setViewName("editJobPost");
        return editJobPostView;
    }

    /**
     * <h2>confirmEditedJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPostDto
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/editedJobPostConfirm", method = RequestMethod.POST)
    public ModelAndView confirmEditedJobPost(@Valid JobPostDto jobPostDto) {
        ModelAndView editedConfirmView = new ModelAndView("updateJobPostConfirm");
        editedConfirmView.addObject("confirmEditedJobPostDto", jobPostDto);
        List<JobType> typeList = jobPostService.doGetJobTypeList();
        editedConfirmView.addObject("JobTypeList", typeList);
        editedConfirmView.setViewName("confirmEditedJobPost");
        return editedConfirmView;
    }

    /**
     * <h2>updateJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPostDto
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/updateJobPost", params = "saveUpdateJobPost", method = RequestMethod.POST)
    public ModelAndView updateJobPost(@Valid JobPostDto jobPostDto) {
        ModelAndView updateJobPostView = new ModelAndView("redirect:/jobPostList");
        this.jobPostService.doUpdateJobPost(jobPostDto);
        return updateJobPostView;
    }

    /**
     * <h2>cancelUpdateJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/updateJobPost", params = "cancelUpdate", method = RequestMethod.POST)
    public ModelAndView cancelUpdateJobType() {
        ModelAndView updateJobPostView = new ModelAndView("redirect:/jobPostList");
        return updateJobPostView;
    }

    /**
     * <h2>deleteJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/deleteJobPost", method = RequestMethod.GET)
    public ModelAndView deleteJobPost(HttpServletRequest request) {
        int jobPostId = Integer.parseInt(request.getParameter("id"));
        jobPostService.doDeleteJobPost(jobPostId);
        return new ModelAndView("redirect:/jobPostList");
    }
}