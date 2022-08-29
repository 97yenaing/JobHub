package cgmgl.springmvc.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.PasswordResetMailForm;
import cgmgl.springmvc.app.bl.dto.UserDto;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.common.Constant;

/**
 * Class UserController.
 */
@Controller
public class UserController {
	
    @Autowired 
    UserService userService;
    @RequestMapping( value = "/login-page" , method = RequestMethod.GET)
    public ModelAndView email(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("login");
        model.addObject("userForm", new UserDto());
        model.setViewName("login");
        return model;
    }
   
    /*
     * @RequestMapping(value = "/home" , method = RequestMethod.POST ) public
     * ModelAndView sendEmail(
     * 
     * @Valid @ModelAttribute("userForm") UserForm userForm, BindingResult result,
     * HttpServletRequest request, HttpServletResponse response) { ModelAndView
     * model = new ModelAndView("Login-form"); model.setViewName("Login-form");
     * return model; }
     */
    
    @RequestMapping(value = "/home")
    public String userPage() {
        return "home";
    }

    @RequestMapping(value = "/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping(value = "/error")
    public String error() {
        return "access-denied";
    }
}
