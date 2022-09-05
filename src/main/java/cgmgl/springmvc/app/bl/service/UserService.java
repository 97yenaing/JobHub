package cgmgl.springmvc.app.bl.service;

import java.util.List;

import javax.validation.Valid;

import cgmgl.springmvc.app.bl.dto.ApplicantDto;
import cgmgl.springmvc.app.bl.dto.UserDto;
import cgmgl.springmvc.app.persistence.entity.User;

public interface UserService {
    User doGetUserByName(String username);

    long doGetUserCount();

    boolean doIsEmailExist(String user_email);

    public void doSaveUser(@Valid ApplicantDto applicantForm);

    public User doGetUserById(long userId);

    public void doUpdateUser(@Valid User user);

    public User doGetUserByEmail(String userEmail);

    public List<User> doGetUserList();

    public UserDto getUserByID(Long userId);

    public void doUpdateUser(@Valid UserDto userForm);

    /**
     * Find by id.
     *
     * @param int id
     * @return UserDetailDto
     */
    /*
     * UserDto findById(int id);
     * 
     *//**
        * Find by email.
        *
        * @param String email
        * @return UserDetailDto
        */
    /*
     * UserDto findByEmail(String email);
     * 
     *//**
        * Create new user.
        *
        * @param UserDetailDto userDto
        */
    /*
     * void createUser(UserDto userDto);
     * 
     *//**
        * Update user.
        *
        * @param UserUpdateDto userDto
        */
    /*
     * void updateUser(UserDto userDto);
     * 
     *//**
        * Delete user.
        *
        * @param int id
        *//*
           * void deleteUser(int id);
           */
}