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
	public List<Company> dbCompanyList() {
		return sessionFactory.getCurrentSession().createQuery("SELECT c FROM Company c where c. deleted_at = null")
		        .list();

	}

	@Override
	public void dbaddCompany(Company company, Date currentDate) {
		company.setCreated_at(currentDate);
		sessionFactory.getCurrentSession().save(company);
	}

	@Override
	public void dbupdateCompany(Company company) {
		this.sessionFactory.getCurrentSession().update(company);

	}

	@Override
	public Company dbfindByEmail(String email) {
		String companyquery = "select c from Company  c where c.email=:email";
		@SuppressWarnings("unchecked")
		Query<Company> queryCompanyByEmail = this.sessionFactory.getCurrentSession().createQuery(companyquery);
		queryCompanyByEmail.setParameter("email", email);
		return (Company) queryCompanyByEmail.uniqueResult();
	}

	@Override
	public void dbcreateCompany(Company company) {
		this.sessionFactory.getCurrentSession().save(company);

	}

	@Override
	public CompanyDto dbgetCompany(int company_id) {
		String companyquery = "select c from Company c where c.company_id=:company_id";
		@SuppressWarnings("unchecked")
		Query<Company> queryCompanyByID = this.sessionFactory.getCurrentSession().createQuery(companyquery);
		queryCompanyByID.setParameter("company_id", company_id);
		Company result = (Company) queryCompanyByID.uniqueResult();
		CompanyDto companyForm = new CompanyDto(result);
		return companyForm;
	}

	@Override
	public void dbdeleteCompanyID(int company_id, Date currentDate) {
		Company company = this.sessionFactory.getCurrentSession().load(Company.class, company_id);
		if (null != company) {
			company.setDeleted_at(new Date());
			this.sessionFactory.getCurrentSession().update(company);
		}

	}

}
