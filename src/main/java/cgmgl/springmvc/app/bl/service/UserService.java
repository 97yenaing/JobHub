package cgmgl.springmvc.app.bl.service;

import cgmgl.springmvc.app.persistence.entity.User;

public interface UserService {
    
    User doGetUserByName(String username);
    
    long doGetUserCount();

    boolean doIsEmailExist(String user_email);
}
