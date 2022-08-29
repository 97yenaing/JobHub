package cgmgl.springmvc.app.persistence.dao;

import cgmgl.springmvc.app.persistence.entity.User;

/**
 * Interface UserDao.
 */
public interface UserDao {

    public User dbGetUserByName(String username);

    public long dbGetUserCount();

    public void dbSaveUser(User user);

    public User dbFindUserByAllEmail(String user_email);

    public void dbUpdateUserPassword(User user);
}
