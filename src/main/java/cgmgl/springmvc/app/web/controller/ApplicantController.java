package cgmgl.springmvc.app.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.service.ApplicantInfoService;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.User;

@Controller
public class ApplicantController {
	@Autowired
	private ApplicantInfoService applicantService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/applicant/list")
	public ModelAndView getApplicantList(ModelAndView model) throws IOException {
		List<ApplicantInfo> applicantList = applicantService.doGetApplicantList();
		model.addObject("ApplicantList", applicantList);
		model.setViewName("applicantList");
		return model;
	}
	
	@RequestMapping(value = "/applicant/profile", method = RequestMethod.GET)
	public ModelAndView showApplicantProfile(ModelAndView model) throws IOException {
		User user = userService.doGetLoginInfo();
		long userIdForApplicant = user.getId();
		User applicant = this.userService.doGetApplicantById(userIdForApplicant);
		model.addObject("ApplicantProfile", applicant);
		model.setViewName("applicantProfile");
		return model;
	}
	
	@RequestMapping(value = "/applicant/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		long applicantId = Integer.parseInt(request.getParameter("id"));
		applicantService.doDeleteUser(applicantId);
		//String fileName = StringUtil
		return new ModelAndView("redirect:/applicant/list");
	}

}