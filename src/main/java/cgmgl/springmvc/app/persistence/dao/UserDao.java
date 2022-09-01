package cgmgl.springmvc.app.persistence.dao;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * Interface UserDao.
 */
public interface UserDao {
	void dbSaveUser(User admin);

	long dbGetUserCount();

	User dbGetUserById(long userId);

	void dbUpdateUser(@Valid User user);

	User dbGetUserByEmail(String userEmail);

	void dbAddUser(User user, ApplicantInfo applicantInfo, Date created_date);

	List<User> dbGetUserList();
}
