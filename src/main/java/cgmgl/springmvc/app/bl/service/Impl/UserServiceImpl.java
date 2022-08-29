package cgmgl.springmvc.app.bl.service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cgmgl.springmvc.app.bl.dto.CustomUserDetail;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    
    @Autowired
    private UserDao userDAO;

    @Override
    public User doGetUserByName(String username) {
        return this.userDAO.dbGetUserByName(username);
    }

    @Override
    public long doGetUserCount() {

        return this.userDAO.dbGetUserCount();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = this.userDAO.dbGetUserByName(username);
        
        if (userInfo == null) {
            throw new UsernameNotFoundException("Invalid Username or Password!");
        }
        UserDetails user = new CustomUserDetail(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getAuthorities());
        return user;
    }

    @Override
    public boolean doIsEmailExist(String user_email) {
        boolean result = false;
        User user = this.userDAO.dbFindUserByAllEmail(user_email);
        if (user != null) {
            result = true;
        }
        return result;
    }

}
