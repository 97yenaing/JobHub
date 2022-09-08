package cgmgl.springmvc.app.web.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.UserDto;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.bl.service.JobPostService;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.entity.Authority;
import cgmgl.springmvc.app.persistence.entity.JobType;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * <h2>LoginController Class</h2>
 * <p>
 * Process for Displaying LoginController
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private JobPostService jobPostService;

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public ModelAndView Homepage(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("home");
        return model;
    }

    /**
     * <h2>homePage</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/home")
    public ModelAndView homePage(ModelAndView model, Principal authentication) {
        System.out.println(authentication.getName());
        // ModelAndView model = new ModelAndView();
        List<JobType> typeList = jobPostService.doGetJobTypeList();
        model.addObject("JobTypeList", typeList);
        System.out.println("Jobtype .........");
        System.out.println(typeList);
        User user = this.userService.doGetLoginInfo();
        System.out.println(user.getEmail());
        System.out.println(user.getName());
        model.setViewName("home");
        session.setAttribute("Login",this.userService.doGetLoginInfo());
        return model;
    }
    @RequestMapping(value = "/aboutus")
    public ModelAndView aboutUsPage(ModelAndView model) {
        model.setViewName("aboutus");
        return model;
    }

    /**
     * <h2> companyPage</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    @RequestMapping(value = "/company" , method = RequestMethod.GET)
    public String companyPage() {
        return "admin";
    }
  
    /**
     * <h2> AccessDenied</h2>
     * <h2>applicantPage</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView AccessDenied(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("access-denied");
        return model;
    }
    
    /**
     * <h2> Logout</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView Logout(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("redirect:/home");
        return model;
    }
}