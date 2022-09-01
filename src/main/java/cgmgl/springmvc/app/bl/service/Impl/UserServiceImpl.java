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

/**
 * <h2> UserServiceImpl Class</h2>
 * <p>
 * Process for Displaying UserServiceImpl
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    
    /**
     * <h2> userDAO</h2>
     * <p>
     * userDAO
     * </p>
     */
    @Autowired
    private UserDao userDAO;

    /**
     * <h2> doGetUserByName </h2>
     * <p>
     * 
     * </p>
     * 
     * @param username
     * @return
     */
    @Override
    public User doGetUserByName(String username) {
        return this.userDAO.dbGetUserByName(username);
    }

    /**
     * <h2> doGetUserCount </h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public long doGetUserCount() {

        return this.userDAO.dbGetUserCount();
    }

    /**
     * <h2> loadUserByUsername </h2>
     * <p>
     * 
     * </p>
     * 
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
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

    /**
     * <h2> doIsEmailExist </h2>
     * <p>
     * 
     * </p>
     * 
     * @param user_email
     * @return
     */
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
