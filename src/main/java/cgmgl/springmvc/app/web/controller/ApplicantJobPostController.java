package cgmgl.springmvc.app.web.controller;

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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.ApplicantJobPostDto;
import cgmgl.springmvc.app.bl.dto.JobPostDto;
import cgmgl.springmvc.app.bl.service.ApplicantJobPostService;
import cgmgl.springmvc.app.bl.service.JobPostService;
import cgmgl.springmvc.app.persistence.entity.JobPost;

@Controller
public class ApplicantJobPostController {
    @Autowired
    private ApplicantJobPostService applicantJobPostService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private JobPostService jobPostService;

    @RequestMapping(value = "/post/apply", method = RequestMethod.GET)
    public ModelAndView applyJobPost(ModelAndView model, @RequestParam int id) {
        ModelAndView applyJobPost = new ModelAndView("applyJobPost");
        ApplicantJobPostDto applicantJobPostDto = new ApplicantJobPostDto();
        JobPostDto jobPostDto=this.jobPostService.doGetJobPostById(id);
        JobPost jobPost = new JobPost(jobPostDto);
        applicantJobPostDto.setJobPost(jobPost);
        applyJobPost.addObject("ApplicantJobPostDto", applicantJobPostDto);
        applyJobPost.setViewName("applyJobPost");
        return applyJobPost;
    }

    @RequestMapping(value = "/post/apply/insert", method = RequestMethod.POST)
    public ModelAndView applyJobPost(@RequestParam CommonsMultipartFile[] cvUpload,
            @ModelAttribute("ApplicantJobPostDto") @Valid ApplicantJobPostDto applicantJobDto, BindingResult result,
            HttpServletRequest request, HttpServletResponse response) {
        ModelAndView applyJobPostView = new ModelAndView("redirect:/post/applicant/list");
        if (result.hasErrors()) {
            System.out.println(result.getFieldError());
            System.out.println("ERROR CV File name......" + cvUpload);
            ModelAndView errorView = new ModelAndView("applyJobPost");
            errorView.addObject("ApplicantJobPostDto", applicantJobDto);
            errorView.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
            return errorView;
        }
        if (cvUpload == null || cvUpload.length <= 0) {
            ModelAndView errorView = new ModelAndView("applyJobPost");
            errorView.addObject("ApplicantJobPostDto", applicantJobDto);
            errorView.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
            return errorView;
        }
        if (cvUpload != null && cvUpload.length > 0) {
            for (CommonsMultipartFile aFile : cvUpload) {
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                applicantJobDto.setCv_file_name(aFile.getOriginalFilename());
                applicantJobDto.setFile_data(aFile.getBytes());

            }
        }
        this.applicantJobPostService.doAddApplicantJobPost(applicantJobDto);
        System.out.println("CV File name......" + cvUpload);
        return applyJobPostView;
    }

    @RequestMapping(value = "/post/apply/list")
    public ModelAndView applicantApplyJobList(ModelAndView model) {
        return model;
    }
}