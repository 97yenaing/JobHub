package cgmgl.springmvc.app.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h2> LoginController Class</h2>
 * <p>
 * Process for Displaying LoginController
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Controller
public class LoginController {
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String login() {
        return "login";
    }
   
    /**
     * <h2> homePage</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/home")
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("home");
        return model;
    }
    /**
     * <h2> signUp</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public ModelAndView signUp(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("sign-up");
        model.setViewName("sign-up");
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
     * <h2> applicantPage</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    @RequestMapping(value = "/applicant")
    public String applicantPage() {
        return "applicant";
    }

    /**
     * <h2> AdminPage</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    @RequestMapping(value = "/admin")
    public String AdminPage() {
        return "admin";
    }
}
