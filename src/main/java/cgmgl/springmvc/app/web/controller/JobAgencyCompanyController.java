package cgmgl.springmvc.app.web.controller;

import java.io.PrintStream;
import java.text.ParseException;
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
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.bl.service.CompanyService;
import cgmgl.springmvc.app.persistence.entity.Company;

@Controller
public class JobAgencyCompanyController {
	@Autowired
	private CompanyService companyservice;

	@Autowired
	private MessageSource messageSources;
	
	@RequestMapping(value = "/error")
	public String error() {
		return "access-denied";
	}


	@RequestMapping(value = "/companyList", method = RequestMethod.GET)
	public ModelAndView getCompanyList(ModelAndView model) {
		List<Company> companyList = companyservice.getCompanyList();
		model.addObject("companyList", companyList);

		return model;
	}

	@RequestMapping(value = "/createCompany", method = RequestMethod.GET)
	public ModelAndView newCompany(ModelAndView model) {

		CompanyDto company = new CompanyDto();
		ModelAndView createCompany = new ModelAndView("createCompany");
		createCompany.addObject("rollBackCompanyForm", company);
		createCompany.setViewName("createCompany");
		System.out.println("Create company");
		return createCompany;
	}

	@RequestMapping(value = "/companyConfirm", params = "companyConfirm", method = RequestMethod.POST)
	public ModelAndView createCompanyConfirm(@ModelAttribute("rollBackCompanyForm") @Valid CompanyDto companydto,
	        BindingResult result, HttpServletRequest request) throws ParseException {
		ModelAndView companyConfirm = new ModelAndView("companyConfirm");
		if (result.hasErrors()) {
			System.out.println("valid test");
			Company company = new Company(companydto);
			companyConfirm.addObject("rollBackCompanyForm", company);
			companyConfirm.addObject("errorMsg", messageSources.getMessage("M_SC_0004", null, null));
			companyConfirm.setViewName("createCompany");
			
			return companyConfirm;
		}

		companyConfirm.addObject("CompanyForm", companydto);
		companyConfirm.setViewName("companyConfirm");
		System.out.println("companyfirm");

		return companyConfirm;
	}

	@RequestMapping(value = "/insertCompany", params = "addCompany", method = RequestMethod.POST)
	public ModelAndView insertCompany(@ModelAttribute("CompanyForm") @Valid CompanyDto companydto, BindingResult result,
	        HttpServletRequest request, HttpServletResponse response) {
		System.out.println("insert compay");
		ModelAndView createCompanyView = new ModelAndView("redirect:/createCompany");
		this.companyservice.addCompay(companydto);
//		System.out.println(companydto.getCompany_name());
		return createCompanyView;

	}

}
