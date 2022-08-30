package cgmgl.springmvc.app.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import cgmgl.springmvc.app.persistence.dao.AuthorityDao;
import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.Authority;
import cgmgl.springmvc.app.persistence.entity.User;



@Component
public class DeploymentListencer {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityDao authorityDAO;

    @Autowired
    private UserDao userDAO;
    @PostConstruct
    public void addInitialData() {

        // adding default data
        if (this.authorityDAO.dbGetAuthorityCount() <= 0 && this.userDAO.dbGetUserCount() <= 0) {
            List<Authority> adminAuthorities = new ArrayList<Authority>();
            Authority adminAuthority = new Authority(null, "ROLE_ADMIN");
            this.authorityDAO.dbSaveAuthority(adminAuthority);
            adminAuthorities.add(adminAuthority);
            User admin = new User(null, "admin", passwordEncoder.encode("123"),
                    "yinyinswe1999@gmail.com", null, null, null, null, 0, adminAuthorities);
            this.userDAO.dbSaveUser(admin);

            List<Authority> userAuthorities = new ArrayList<Authority>();
            Authority userAuthority = new Authority(null, "ROLE_USER");
            this.authorityDAO.dbSaveAuthority(userAuthority);
            userAuthorities.add(userAuthority);
            User user = new User(null, "user", passwordEncoder.encode("123"),
                    "yinyinswe199@gmail.com"  , null, null, null, null, 0, userAuthorities);
            
            this.userDAO.dbSaveUser(user);
            
            List<Authority> fullAdminAuthorities = new ArrayList<Authority>();
            Authority admin1Authority = new Authority(null, "ROLE_FULL_ADMIN");
            this.authorityDAO.dbSaveAuthority(admin1Authority);
            fullAdminAuthorities.add(admin1Authority);
            User user1 = new User(null, "full-admin", passwordEncoder.encode("123"),
                    null, null, null, null, null, 0, fullAdminAuthorities);
            this.userDAO.dbSaveUser(user1);
        }
    }

}
