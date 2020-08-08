package com.upgrad.hirewheels.util;


import com.upgrad.hirewheels.dto.UsersDTO;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exception.UserRoleNotFoundException;
import com.upgrad.hirewheels.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOEntityMapper {
    @Autowired
    UserRoleService userRoleService;

    public User convertUserDTOUser(UsersDTO userDTO) throws UserRoleNotFoundException {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setWalletMoney(userDTO.getWalletMoney());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setUserRole(userRoleService.findUserRoleDetails(userDTO.getUserRoleId()));
        return user;
    }
}
