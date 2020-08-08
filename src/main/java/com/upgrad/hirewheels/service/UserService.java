package com.upgrad.hirewheels.service;


import com.upgrad.hirewheels.dto.LoginDTO;
import com.upgrad.hirewheels.dto.UsersDTO;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exception.DuplicateUserDetailsException;
import com.upgrad.hirewheels.exception.GlobalExceptionHandler;
import com.upgrad.hirewheels.exception.UserRoleNotFoundException;


public interface UserService{
    User createUser(UsersDTO users) throws GlobalExceptionHandler, UserRoleNotFoundException, DuplicateUserDetailsException;
    User getUserDetails(LoginDTO loginDTO) throws Exception;
}