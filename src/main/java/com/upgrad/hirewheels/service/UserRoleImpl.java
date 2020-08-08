package com.upgrad.hirewheels.service;


import com.upgrad.hirewheels.dao.UserRoleDAO;
import com.upgrad.hirewheels.entities.UserRole;
import com.upgrad.hirewheels.exception.UserRoleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userRoleService")
public class UserRoleImpl implements UserRoleService{

    @Autowired
    UserRoleDAO userRoleDAO;

    @Override
    public UserRole acceptUserRoleDetails(UserRole userRole) {
        return userRoleDAO.save(userRole);
    }


    @Override
    public UserRole findUserRoleDetails(int userRoleId) throws UserRoleNotFoundException {
        UserRole savedUserRole = userRoleDAO.findById(userRoleId).get();
        if(savedUserRole == null){
            throw  new UserRoleNotFoundException("User role not found for id : " + userRoleId);
        }
        return  savedUserRole;
    }
}
