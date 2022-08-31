package cgmgl.springmvc.app.bl.service;

import java.util.Date;
import java.util.List;

import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.persistence.entity.Company;



public interface CompanyService {
	public List<Company> getCompanyList();

	public void addCompay(CompanyDto companyform);

	public void deleteCompany(int company_id);

	public CompanyDto getCompany(int company_id);

	public void updateCompany(CompanyDto companyform);


}
