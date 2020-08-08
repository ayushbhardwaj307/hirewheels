package com.upgrad.hirewheels.service;


import com.upgrad.hirewheels.dao.UserDAO;
import com.upgrad.hirewheels.dao.UserRoleDAO;
import com.upgrad.hirewheels.dto.LoginDTO;
import com.upgrad.hirewheels.dto.UsersDTO;
import com.upgrad.hirewheels.entities.*;
import com.upgrad.hirewheels.exception.DuplicateUserDetailsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserRoleDAO userRoleDAO;

    @Override
    public User createUser(UsersDTO userDTO) throws DuplicateUserDetailsException {
        if (userDAO.findByEmail(userDTO.getEmail()) != null) {
            throw new DuplicateUserDetailsException("Email Already Exists");
        }

        if (userDAO.findByMobileNo(userDTO.getMobileNo()) != null) {
            throw new DuplicateUserDetailsException("Mobile Number Already Exists");
        }
        User user = new User();
        user.setWalletMoney(userDTO.getWalletMoney());
        user.setUserRole(userRoleDAO.findByRoleId(2));
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMobileNo(userDTO.getMobileNo());
        return userDAO.save(user);
    }

    @Override
    public User getUserDetails(LoginDTO loginDTO) throws Exception {
        if (userDAO.findByEmail(loginDTO.getEmail()) == null){
            throw new Exception("User Not Registered");
        }
        if (userDAO.findByPassword(loginDTO.getPassword()) == null){
            throw new Exception("Unauthorized User");
        }
        return userDAO.findByEmail(loginDTO.getEmail());
    }


}
