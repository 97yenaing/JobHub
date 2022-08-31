package cgmgl.springmvc.app.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.persistence.dao.CompanyDAO;
import cgmgl.springmvc.app.persistence.entity.Company;


@Repository
@Transactional

public class CompanyDAOimpl implements CompanyDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void dbsaveCompany(Company company) {
		this.sessionFactory.getCurrentSession().save(company);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> CompanyList() {
		return this.sessionFactory.getCurrentSession().createQuery("Select c from Company c where c.delete_at = null")
		        .list();

	}

	@Override
	public void addCompany(Company company) {
		sessionFactory.getCurrentSession().save(company);

	}

	@Override
	public void deleteCompany(int company_id, Date currentDate) {
		Company company = sessionFactory.getCurrentSession().load(Company.class, company_id);
		if (null != company) {
			company.setDeleted_at(new Date());
			this.sessionFactory.getCurrentSession().update(company);
		}
	}

	@Override
	public CompanyDto getCompany(int company_id) {
		String companyquery = "select c from Company  c where c:company_id=:company_id";
		@SuppressWarnings("unchecked")
		Query<Company> queryCompanyBuId = this.sessionFactory.getCurrentSession().createQuery(companyquery);
		queryCompanyBuId.setParameter("company_id", company_id);
		Company result = (Company) queryCompanyBuId.uniqueResult();
		CompanyDto companyForm = new CompanyDto(result);
		return companyForm;
	}

	@Override
	public void updateCompany(Company company) {
		this.sessionFactory.getCurrentSession().update(company);

	}

	@Override
	public Company findByEmail(String email) {
		String companyquery = "select c from Company  c where c:email_=:email";
		@SuppressWarnings("unchecked")
		Query<Company> queryCompanyByEmail = this.sessionFactory.getCurrentSession().createQuery(companyquery);
		queryCompanyByEmail.setParameter("email", email);
		return (Company) queryCompanyByEmail.uniqueResult();
	}

	@Override
	public void createCompany(Company company) {
		this.sessionFactory.getCurrentSession().save(company);

	}

	@Override
	public void deleteCompanyByEmail(String email) {
		String companyquery = "select c from Company  c where c:email_=:email";
		@SuppressWarnings("unchecked")
		Query<Company> queryCompanyByEmail = this.sessionFactory.getCurrentSession().createQuery(companyquery);
		if (companyquery != null) {
			Company company = new Company();
			company.setDeleted_at(new Date());
			this.sessionFactory.getCurrentSession().update(company);
		}
	}
}
