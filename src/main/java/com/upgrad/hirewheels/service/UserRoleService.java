package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.entities.UserRole;
import com.upgrad.hirewheels.exception.UserRoleNotFoundException;

public interface UserRoleService {
    UserRole acceptUserRoleDetails(UserRole userRole);
    UserRole findUserRoleDetails(int userRoleId) throws UserRoleNotFoundException;
}
