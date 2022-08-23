package cgmgl.springmvc.app.bl.service.Impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.bl.dto.UserDto;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * Class UserServiceImpl.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	/** user dao. */
	@Autowired
	private UserDao userDao;

	/** PasswordEncoder from spring security. */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/** current timestamp */
	private Timestamp now = new Timestamp(new Date().getTime());


	public UserDto findById(int id) {
		UserDto userDto = new UserDto(userDao.findById(id));
		return userDto;
	}

	public UserDto findByEmail(String email) {
		User user = userDao.findByEmail(email);
		if (user == null) {
			return null;
		}
		UserDto userDto = new UserDto(user);
		return userDto;
	}

	public void createUser(UserDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userDto.setCreatedAt(now);
		userDto.setUpdatedAt(now);
		userDao.createUser(getUserObject(userDto));
	}

	public void updateUser(UserDto userDto) {
		userDto.setUpdatedAt(now);
		userDao.updateUser(getUserObject(userDto));
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	public boolean isUserExist(String email) {
		User user = userDao.findByEmail(email);
		return user != null;
	}

	/**
	 * Gets the user object.
	 *
	 * @param UserDetailDto userDto
	 * @return User
	 */
	private User getUserObject(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setGender(userDto.getGender());
		user.setAddress(userDto.getAddress());
		user.setCreatedAt(userDto.getCreatedAt());
		user.setUpdatedAt(userDto.getUpdatedAt());
		return user;
	}

}
