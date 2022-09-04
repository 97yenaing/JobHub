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
	public List<Company> dogetCompanyList() {
	
		return this.companydao.dbCompanyList();
	}

	@Override
	public void doaddCompay(CompanyDto companyDto) {
		Company company = new Company(companyDto);
		Date currentDate = new Date();
		this.companydao.dbaddCompany(company, currentDate);

	}

	@Override
	public void doupdateCompany(CompanyDto companyDto) {
		Company company = new Company(companyDto);
		CompanyDto updateCompany = this.companydao.dbgetCompany(companyDto.getCompany_id());
		updateCompany.setCompany_name(companyDto.getCompany_name());
		updateCompany.setEmail(companyDto.getEmail());
		updateCompany.setPhone(companyDto.getPhone());
		updateCompany.setAddress(companyDto.getAddress());
		updateCompany.setWeb_link(companyDto.getWeb_link());
		updateCompany.setUpdated_at(new Date());
		updateCompany.setCreated_at(companyDto.getCreated_at());
		this.companydao.dbupdateCompany(company);		

	}

	@Override
	public CompanyDto dogetCompany(int company_id) {
		return companydao.dbgetCompany(company_id);

	}

	@Override
	public boolean dofindByEmail(String email) {
		Company result = this.companydao.dbfindByEmail(email);
		boolean rollNoExist = false;
		if (result != null) {
			rollNoExist = true;
		}
		return rollNoExist;
	}

	@Override
	public void dodeleteCompanyID(int company_id) {
		companydao.dbdeleteCompanyID(company_id, new Date());;
		
	}
	
}
