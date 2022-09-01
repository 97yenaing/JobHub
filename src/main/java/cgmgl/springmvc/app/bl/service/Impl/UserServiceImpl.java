package cgmgl.springmvc.app.bl.service.Impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.bl.dto.ApplicantDto;
import cgmgl.springmvc.app.bl.dto.UserDto;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.dao.ApplicantInfoDao;
import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * Class UserServiceImpl.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
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

	@Override
	public User doGetUserByEmail(String userEmail) {
		// TODO Auto-generated method stub
		User resultUser = this.userDAO.dbGetUserByEmail(userEmail);
		return resultUser;
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

	/** user dao. */
	/*
	 * @Autowired private UserDao userDao;
	 * 
	 *//** PasswordEncoder from spring security. */
	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 * 
	 *//** current timestamp */
	/*
	 * private Timestamp now = new Timestamp(new Date().getTime());
	 * 
	 * 
	 * public UserDto findById(int id) { UserDto userDto = new
	 * UserDto(userDao.findById(id)); return userDto; }
	 * 
	 * public UserDto findByEmail(String email) { User user =
	 * userDao.findByEmail(email); if (user == null) { return null; } UserDto
	 * userDto = new UserDto(user); return userDto; }
	 * 
	 * public void createUser(UserDto userDto) {
	 * userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
	 * userDto.setCreatedAt(now); userDto.setUpdatedAt(now);
	 * userDao.createUser(getUserObject(userDto)); }
	 * 
	 * public void updateUser(UserDto userDto) { userDto.setUpdatedAt(now);
	 * userDao.updateUser(getUserObject(userDto)); }
	 * 
	 * public void deleteUser(int id) { userDao.deleteUser(id); }
	 * 
	 * public boolean isUserExist(String email) { User user =
	 * userDao.findByEmail(email); return user != null; }
	 * 
	 *//**
	    * Gets the user object.
	    *
	    * @param UserDetailDto userDto
	    * @return User
	    *//*
	       * private User getUserObject(UserDto userDto) { User user = new User();
	       * user.setId(userDto.getId()); user.setUsername(userDto.getUsername());
	       * user.setEmail(userDto.getEmail()); user.setPassword(userDto.getPassword());
	       * user.setGender(userDto.getGender()); user.setAddress(userDto.getAddress());
	       * user.setCreatedAt(userDto.getCreatedAt());
	       * user.setUpdatedAt(userDto.getUpdatedAt()); return user; }
	       */
}
