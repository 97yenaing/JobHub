package cgmgl.springmvc.app.bl.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.bl.service.CompanyService;
import cgmgl.springmvc.app.persistence.dao.CompanyDAO;
import cgmgl.springmvc.app.persistence.entity.Company;


@Service
public class CompanyServiceimpl implements CompanyService {
	@Autowired
	CompanyDAO companydao;

	@Override
	public List<Company> getCompanyList() {
		return companydao.CompanyList();
	}

	@Override 
	public void addCompay(CompanyDto companyDto) {
		Company company=new Company(companyDto);
		this.companydao.addCompany(company);
		
	}

	@Override
	public void deleteCompany(int company_id) {
		this.companydao.deleteCompany(company_id,new Date());	
	}

	@Override
	public CompanyDto getCompany(int company_id) {
		
		return companydao.getCompany(company_id);
	}

	@Override
	public void updateCompany(CompanyDto companyForm) {
		Company company=new Company();
		this.companydao.updateCompany(company);
		
	}

}
