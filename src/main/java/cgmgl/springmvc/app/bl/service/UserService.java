package cgmgl.springmvc.app.bl.service;

import cgmgl.springmvc.app.bl.dto.UserDto;

/**
 * Interface UserService for user CRUD functions.
 */
public interface UserService {
	
	/**
	 * Find by id.
	 *
	 * @param int id
	 * @return UserDetailDto
	 */
	UserDto findById(int id);

	/**
	 * Find by email.
	 *
	 * @param String email
	 * @return UserDetailDto
	 */
	UserDto findByEmail(String email);

	/**
	 * Create new user.
	 *
	 * @param UserDetailDto userDto
	 */
	void createUser(UserDto userDto);

	/**
	 * Update user.
	 *
	 * @param UserUpdateDto userDto
	 */
	void updateUser(UserDto userDto);

	/**
	 * Delete user.
	 *
	 * @param int id
	 */
	void deleteUser(int id);
}
