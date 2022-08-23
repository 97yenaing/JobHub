package cgmgl.springmvc.app.persistence.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import cgmgl.springmvc.app.persistence.dao.AbstractDao;
import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * Class UserDaoImpl.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findById(int id) {
		return getById(id);
	}

	public User findByEmail(String email) {
		String userQuery = "SELECT u FROM User u WHERE u.email = :email AND deleted_at = null";
		Query<User> query = createQuery(userQuery);
		return query.uniqueResult();
	}

	public void createUser(User user) {
		create(user);
	}

	public void updateUser(User user) {
		update(user);
	}

	public void deleteUser(int id) {
		deleteById(id);
	}

	public void deleteUserByEmail(String email) {
		delete(findByEmail(email));
	}
}
