package cgmgl.springmvc.app.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.ApplicantDto;
import cgmgl.springmvc.app.bl.dto.UserDto;
import cgmgl.springmvc.app.bl.service.AuthorityService;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.entity.Authority;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * Class UserController.
 */
@Controller
public class UserController {
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView newUser() {
		List<Authority> authorities = authorityService.doGetAuthList();
		UserDto userForm = new UserDto();
		ModelAndView createUser = new ModelAndView("register");
		createUser.addObject("userForm", userForm);
		createUser.addObject("authorityRoles", authorities);
		createUser.setViewName("register");
		return createUser;
	}

	@RequestMapping(value = { "/userInfo" }, method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("userForm") @Valid UserDto userDto, BindingResult result,
	        HttpServletRequest request, HttpServletResponse response) {
		ModelAndView userView = new ModelAndView("register");
		System.out.println(userDto.getEmail());
		List<Authority> authorities = new ArrayList<Authority>();
		int authoId = userDto.getAuthority().getId();
		Authority authority = authorityService.doGetAuthById(authoId);
		authorities.add(authority);
		if (userDto.getPassword() != userDto.getConfirmPwd()) {
			UserDto newUser = new UserDto();
			userView.addObject("userForm", newUser);
			userView.addObject("authorityRoles", authorities);
			userView.addObject("errorMsg", "Confirm password must be equal with the first password.");
		}

		System.out.println(authoId);
		if (authoId == 3) {
			ApplicantDto applicantDto = new ApplicantDto();
			ModelAndView applicantRegister = new ModelAndView("applicantInfo");
			applicantRegister.addObject("applicantInfoForm", applicantDto);
			applicantRegister.addObject("user", userDto);
			applicantRegister.setViewName("applicantInfo");
			return applicantRegister;
		}
		return userView;
	}

	@RequestMapping(value = "/applicantInfoSave", params = "addApplicant", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("applicantInfoForm") @Valid ApplicantDto applicantForm,
	        BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(applicantForm.getUser().getEmail());
		this.userService.doSaveUser(applicantForm);
		ModelAndView createUserView = new ModelAndView("redirect:/home");
		return createUserView;
	}
	
	@RequestMapping(value = "/userList")
	public ModelAndView getUserList(ModelAndView model) throws IOException {
		List<User> userList = userService.doGetUserList();
		model.addObject("UserList", userList);
		model.setViewName("userList");
		return model;
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam("id") Long userId, HttpServletRequest request) {
		UserDto userForm = userService.getUserByID(userId);
		List<Authority> authorities = authorityService.doGetAuthList();
		for (Authority authority : userForm.getAuthorityList()) {
			userForm.setAuthority(authority);
		}
		ModelAndView model = new ModelAndView("updateUser");
		model.addObject("user", userForm);
		model.addObject("authorityRoles", authorities);
		model.setViewName("updateUser");
		return model;
	}
	
	@RequestMapping(value = "/updateUser", params = "updateUser", method = RequestMethod.POST)
	public ModelAndView callUpdateUserConfirm(@ModelAttribute("user") @Valid UserDto userForm, BindingResult result)
	        throws ParseException, FileNotFoundException, IOException {
		userForm.setPassword(passEncoder.encode(userForm.getPassword()));
		this.userService.doUpdateUser(userForm);
		ModelAndView updateUserView = new ModelAndView("redirect:/userList");
		return updateUserView;
	}

	/*
	 * @RequestMapping(value = { "/view" }, method = RequestMethod.GET) public
	 * String view(@RequestParam(value = "name", required = false) String name,
	 * ModelMap model, HttpSession session) {
	 * 
	 * UserDto user = userService.findById(1); if (user != null) {
	 * model.addAttribute("user", user); name = user.getUsername(); }
	 * model.addAttribute("name", name); model.addAttribute("mail",
	 * Constant.MAIL_PW_RESET_SENDER);
	 * 
	 * return "view"; }
	 */
}