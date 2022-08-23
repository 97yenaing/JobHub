package cgmgl.springmvc.app.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cgmgl.springmvc.app.bl.dto.UserDto;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.common.Constant;

/**
 * Class UserController.
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = { "/view" }, method = RequestMethod.GET)
	public String view(@RequestParam(value = "name", required = false) String name, ModelMap model,
			HttpSession session) {

		UserDto user = userService.findById(1);
		if (user != null) {
			model.addAttribute("user", user);
			name = user.getUsername();
		}
		model.addAttribute("name", name);
		model.addAttribute("mail", Constant.MAIL_PW_RESET_SENDER);

		return "view";
	}

}
