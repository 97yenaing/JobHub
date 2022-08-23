package cgmgl.springmvc.app.persistence.dao;

import cgmgl.springmvc.app.persistence.entity.User;

/**
 * Interface UserDao.
 */
public interface UserDao {

	/**
	 * Find by id.
	 *
	 * @param int id
	 * @return user
	 */
	User findById(int id);

	/**
	 * Find by email.
	 *
	 * @param String email
	 * @return user
	 */
	User findByEmail(String email);

	/**
	 * Creates user.
	 *
	 * @param User user
	 */
	void createUser(User user);
	
	/**
	 * Update user.
	 *
	 * @param User user
	 */
	void updateUser(User user);

	/**
	 * Delete user.
	 *
	 * @param int id
	 */
	void deleteUser(int id);

	/**
	 * Delete user by email.
	 *
	 * @param String email
	 */
	void deleteUserByEmail(String email);
}
