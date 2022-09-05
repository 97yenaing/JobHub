package cgmgl.springmvc.app.bl.service.Impl;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.bl.dto.ApplicantDto;
import cgmgl.springmvc.app.bl.dto.CustomUserDetail;
import cgmgl.springmvc.app.bl.dto.UserDto;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.dao.ApplicantInfoDao;
import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDAO;

    @Autowired
    private ApplicantInfoDao applicantInfoDao;

    @Override
    public User doGetUserById(long userId) {
        // TODO Auto-generated method stub
        User resultPost = this.userDAO.dbGetUserById(userId);
        return resultPost;
    }

    @Override
    public void doUpdateUser(@Valid User user) {
        // TODO Auto-generated method stub
        this.userDAO.dbUpdateUser(user);
    }

    /**
     * <h2>doGetUserByName</h2>
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
     * <h2>doGetUserCount</h2>
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
     * <h2>loadUserByUsername</h2>
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
        UserDetails user = new CustomUserDetail(userInfo.getName(), userInfo.getPassword(), userInfo.getAuthorities());
        return user;
    }

    @Override
    public void doSaveUser(@Valid ApplicantDto applicantForm) {
        // TODO Auto-generated method stub
        ApplicantInfo applicantInfo = new ApplicantInfo(applicantForm);
        Date created_date = new Date();
        applicantInfoDao.dbSaveApplicantInfo(applicantInfo);
        User user = new User(applicantForm);
        user.setPassword(passwordEncoder.encode(applicantForm.getUser().getPassword()));
        this.userDAO.dbAddUser(user, applicantInfo, created_date);

    }

    @Override
    public List<User> doGetUserList() {
        // TODO Auto-generated method stub
        return userDAO.dbGetUserList();
    }

    @Override
    public UserDto getUserByID(Long userId) {
        // TODO Auto-generated method stub
        User resultPost = this.userDAO.dbGetUserById(userId);
        UserDto resultPostform = resultPost != null ? new UserDto(resultPost) : null;
        return resultPostform;
    }

    @Override
    public void doUpdateUser(@Valid UserDto userForm) {
        // TODO Auto-generated method stub
        Date updatedDate = new Date();
        User updateUser = this.userDAO.dbGetUserById(userForm.getId());
        updateUser.setName(userForm.getUsername());
        updateUser.setEmail(userForm.getEmail());
        updateUser.setPassword(userForm.getPassword());
        updateUser.setUpdated_at(updatedDate);
        this.userDAO.dbUpdateUser(updateUser);
    }

    /**
     * <h2>doIsEmailExist</h2>
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

    @Override
    public User doGetUserByEmail(String userEmail) {
        User resultUser = this.userDAO.dbGetUserByEmail(userEmail);
        return resultUser;
    }

	@Override
	public void doDeleteUser(long userId) {
		// TODO Auto-generated method stub
		Date deletedAt = new Date();
		User user = this.userDAO.dbGetUserById(userId);
		this.userDAO.dbDeleteUser(user, deletedAt);
	}

	@Override
	public List<String> doGetEmailList() {
		// TODO Auto-generated method stub
		return userDAO.dbGetUserEmailList();
	}

	@Override
	public void doSaveUser(@Valid UserDto userDto) {
		// TODO Auto-generated method stub
		Date created_date = new Date();
		User user = new User(userDto);
		this.userDAO.dbAddUser(user, null, created_date);
	}
}