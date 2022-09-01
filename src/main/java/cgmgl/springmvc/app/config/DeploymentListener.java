package cgmgl.springmvc.app.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import cgmgl.springmvc.app.persistence.dao.ApplicantInfoDao;
import cgmgl.springmvc.app.persistence.dao.AuthorityDao;
import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.Authority;
import cgmgl.springmvc.app.persistence.entity.User;



/**
 * <h2>DeploymentListener Class</h2>
 * <p>
 * Process for Displaying DeploymentListener
 * </p>
 * 
 * @author KyiSin
 *
 */
@Component
public class DeploymentListener {
	@Autowired
	private ApplicantInfoDao appInfoDao;
	/**
	 * <h2>passwordEncoder</h2>
	 * <p>
	 * passwordEncoder
	 * </p>
	 */
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/**
	 * <h2>authorityDAO</h2>
	 * <p>
	 * authorityDAO
	 * </p>
	 */
	@Autowired
	private AuthorityDao authorityDAO;

	/**
	 * <h2>userDAO</h2>
	 * <p>
	 * userDAO
	 * </p>
	 */
	@Autowired
	private UserDao userDAO;

	/**
	 * <h2>addInitialData</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return void
	 */
	@PostConstruct
	public void addInitialData() {

		// adding default data
		if (this.authorityDAO.dbGetAuthorityCount() <= 0 && this.userDAO.dbGetUserCount() <= 0) {
			List<Authority> adminAuthorities = new ArrayList<Authority>();
			Authority adminAuthority = new Authority(null, "ROLE_ADMIN");
			this.authorityDAO.dbSaveAuthority(adminAuthority);
			adminAuthorities.add(adminAuthority);
			User admin = new User(1, "admin", "admin@gmail.com", passwordEncoder.encode("123"), null, null, null, null, adminAuthorities);
			this.userDAO.dbSaveUser(admin);

			List<Authority> companyAuthorities = new ArrayList<Authority>();
			Authority companyAuthority = new Authority(null, "ROLE_COMPANY");
			this.authorityDAO.dbSaveAuthority(companyAuthority);
			companyAuthorities.add(companyAuthority);
			User company = new User(2, "company", "company1@gmail.com", passwordEncoder.encode("123"), null, null, null, null, companyAuthorities);
			this.userDAO.dbSaveUser(company);
			
			List<Authority> applicantAuthorities = new ArrayList<Authority>();
			Authority applicantAuthority = new Authority(null, "ROLE_APPLICANT");
			this.authorityDAO.dbSaveAuthority(applicantAuthority);			
			applicantAuthorities.add(applicantAuthority);
			companyAuthorities.add(companyAuthority);
			ApplicantInfo appInfo = new ApplicantInfo(1, null, "09-794114723", "2", null, null, "FEMALE", "North Dagon", null);
			this.appInfoDao.dbSaveApplicantInfo(appInfo);
			User applicant = new User(3, "applicant", "applicant1@gmail.com", passwordEncoder.encode("123"), null, null, null, appInfo, applicantAuthorities);
			this.userDAO.dbSaveUser(applicant);
			
		}
	}
}