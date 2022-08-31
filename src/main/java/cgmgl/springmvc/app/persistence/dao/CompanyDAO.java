package cgmgl.springmvc.app.persistence.dao;

import java.util.Date;
import java.util.List;

import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.persistence.entity.Company;


public interface CompanyDAO {
	public void dbsaveCompany(Company company);

	public List<Company> CompanyList();

	public void addCompany(Company company);

	public void deleteCompany(int company_id, Date currentDate);

	public CompanyDto getCompany(int company_id);

	public void updateCompany(Company company);

	Company findByEmail(String email);

	void createCompany(Company company);

	void deleteCompanyByEmail(String email);

}
