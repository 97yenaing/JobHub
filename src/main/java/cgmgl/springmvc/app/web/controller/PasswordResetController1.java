package cgmgl.springmvc.app.web.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.PasswordResetForm;
import cgmgl.springmvc.app.bl.dto.PasswordResetMailForm;
import cgmgl.springmvc.app.bl.service.PasswordResetService;
import cgmgl.springmvc.app.bl.service.UserService;

@Controller
public class PasswordResetController1 {
    @Autowired
    JavaMailSender mailSender;

    @Autowired
    UserService userService;

    @Autowired
    PasswordResetService passwordResetService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/forgot_password", method = RequestMethod.GET)
    public ModelAndView email(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("email");
        model.addObject("email", new PasswordResetMailForm());
        model.setViewName("email");
        return model;
    }

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public ModelAndView sendEmail(@Valid @ModelAttribute("email") PasswordResetMailForm passwordResetMailForm,
            BindingResult result,HttpServletRequest request){
        ModelAndView model= new ModelAndView("email");
        if (result.hasErrors()) {
            return model;
        }

        if (!userService.doIsEmailExist(passwordResetMailForm.getUser_email())) {
            model = new ModelAndView("email");
            model.addObject("errorMsg", "Invalid email address!");
            return model;
        }

        passwordResetMailForm = this.passwordResetService.createResetToken(passwordResetMailForm.getUser_email());
        String url = getBaseUrl(request) + request.getServletPath() + "/" + passwordResetMailForm.getToken();
        this.sendMail(url, passwordResetMailForm);
        ModelAndView newModel = new ModelAndView("sendMailSuccess");
        newModel.addObject("msg", "Password Reset link has been sent!");
        return newModel;

    }

    @RequestMapping(value = "/sendEmail/{token}", method = RequestMethod.GET)
    public ModelAndView showResetPassword(@PathVariable String token) {
        ModelAndView mv = new ModelAndView("invalidMail");
        PasswordResetMailForm passwordResetForm = passwordResetService.getDataByToken(token);
        if (passwordResetForm == null) {
            mv.addObject("errorMsg", "Invalid Token! Please check your token url!");
            return mv;
        }
        if (isTokenExpired(passwordResetForm.getExpired_at())) {
            mv.addObject("errorMsg", "Token has been expired!");
            return mv;
        }
        PasswordResetForm passwordChangeResetForm = new PasswordResetForm();
        passwordChangeResetForm.setToken(token);
        mv.setViewName("passwordReset");
        mv.addObject("passwordResetForm", passwordChangeResetForm);
        return mv;
    }

    @RequestMapping(value = "/password/reset", method = RequestMethod.POST)
    public ModelAndView resetPassword(@Valid @ModelAttribute("passwordResetForm") PasswordResetForm passwordResetForm,
            BindingResult result) {

        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("passwordReset");
            model.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
            return model;
        }
        String userEmail = passwordResetService.getDataByToken(passwordResetForm.getToken()).getUser_email();
        PasswordResetMailForm newPasswordResetForm = new PasswordResetMailForm();
        newPasswordResetForm.setUser_email(userEmail);
        newPasswordResetForm.setPassword(passwordResetForm.getPassword());
        this.passwordResetService.doUpdatePassword(newPasswordResetForm);
        this.passwordResetService.doDeleteToken(passwordResetForm.getToken());
        ModelAndView mv = new ModelAndView("sendMailSuccess");
        mv.addObject("msg", "Password has been changed!");
        return mv;

    }

    private boolean isTokenExpired(Timestamp expired_at) {
        Timestamp now = new Timestamp(new Date().getTime());
        return now.after(expired_at);
    }

    private String getBaseUrl(HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName();
        if (request.getServerPort() != 0) {
            url = url + ":" + request.getServerPort();
        }
        url = url + request.getContextPath();
        return url;
    }

    public void sendMail(String url, PasswordResetMailForm passwordResetMailForm) {
        String sender = "htetn4494@gmail.com";
        String subject = "Reset Your Password";
        String body = "Reset your password from following url : \n";
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(passwordResetMailForm.getUser_email());
        email.setFrom(sender);
        email.setSubject(subject);
        email.setText(body + url);
        mailSender.send(email);
    }
}
